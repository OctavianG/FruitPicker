package videogame.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import videogame.sprites.Fruit;
import videogame.FruitPicker;
import javafx.scene.image.Image;
import videogame.sprites.Fruit;
import videogame.sprites.MainCharacter;
import videogame.sprites.Rock;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameScene extends GeneralScene {

    private static final String BACKGROUND_IMAGE = "assets/background.png";
    private static final String BACKGROUND_SONG = "assets/autumn-leaves.wav";
    public static final String SOUND_EFFECT = "assets/quick-jump.wav";
    public static final String SOUND_EFFECT_ROCK = "assets/rock-destroy.mp3";

    private Image background;
    private MainCharacter bear;
    private Fruit fruit = null;
    private Rock rock = null;
    private MediaPlayer mediaPlayerEffects;
    private Media effect;
    private MediaPlayer MediaPlayerEffectsRock;
    private  Media effectRock;
    public static  int points = 0;
    private int lives = 3;

    public GameScene() {

        super();
        try {
            background = new Image(Files.newInputStream(Paths.get(BACKGROUND_IMAGE)));
            bear = new MainCharacter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* private void showGameMessage() {

        Font myFont = Font.font("Arial", FontWeight.NORMAL, 24);
        gc.setFont(myFont); // add font to GraphicsContext
        gc.setFill(Color.YELLOW); // font color
        // message + horizontal coordinate +  vertical coordinate
        gc.fillText("Game Scene", 325, 200);
    }*/


    @Override
    public void draw() {

        reset();

        // Initializing sound
        // To play - need to add configuration file for player - see module-info.java
        sound = new Media(new File(BACKGROUND_SONG).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        // In case there is any pending key
        activeKeys.clear();

        // placing the bear on the ground and center
        bear.moveTo(380, 375);


        // Repeats the code many times/second
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                // Black background
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

                gc.drawImage(background, 0, 0); // top left corner

                // image, image position, image size, x and y in the scene, scale dimensions;
               bear.draw(gc);

               // HUD draw
                updateHud();

               //fruit
                if (fruit != null) {
                    fruit.draw(gc);
                }

                // rock
                if (rock != null) {
                    rock.draw(gc);
                }

                if (activeKeys.contains(KeyCode.ESCAPE)) {
                    this.stop();
                    FruitPicker.setScene(FruitPicker.WELCOME_SCENE);
                } else if (activeKeys.contains(KeyCode.ENTER)) {
                    this.stop();
                    FruitPicker.setScene(FruitPicker.CREDITS_SCENE);
                } else if (activeKeys.contains(KeyCode.LEFT)) {
                    bear.move(MainCharacter.LEFT);
                } else if (activeKeys.contains(KeyCode.RIGHT)) {
                    bear.move(MainCharacter.RIGHT);
                }

                // Generate or move fruit
                if (fruit == null) {
                    fruit = new Fruit();
                    fruit.moveTo((int)(Math.random() * (GeneralScene.GAME_WIDTH - Fruit.FRUIT_WIDTH)), 0);
                } else {
                    fruit.move();
                    if (fruit.colidesWith(bear)) {
                        points += 10;
                        fruit.increaseDifficulty();
                        playEffect(SOUND_EFFECT);
                        fruit = null;
                    } else if (fruit.getY() > GeneralScene.GAME_HEIGHT) {
                        lives--;
                        fruit = null;
                    }
                }

                if (lives == 0) {
                    this.stop();
                    mediaPlayer.stop();
                    FruitPicker.setScene(FruitPicker.CREDITS_SCENE);
                }

                // Generate or move rock
                if (rock == null) {
                    rock = new Rock();
                    rock.moveTo((int)(Math.random() * (GeneralScene.GAME_WIDTH - Rock.ROCK_WIDTH)), 0);
                } else {
                    rock.move();
                    if (rock.colidesWith(bear)) {
                        playEffect(SOUND_EFFECT_ROCK);
                        points -= 10;
                        rock = null;
                    } else if (rock.getY() > GeneralScene.GAME_HEIGHT) {
                        rock = null;
                    }
                }
            }
        };

        animationTimer.start();
    }

    public void playEffect(String path) {

        effect = new Media(new File(path).toURI().toString());
        mediaPlayerEffects = new MediaPlayer(effect);
        mediaPlayerEffects.play();
    }

    private void reset() {

        bear.resetPosition();
        lives = 3;
        points = 0;
        Fruit.STEP_INCREMENT = 0f;
    }

    private void updateHud() {
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 18);
        gc.setFont(myFont);
        gc.setFill(Color.BLUE);
        gc.fillText("Score: " + points, 20, GeneralScene.GAME_HEIGHT - 15);

        gc.setFill(Color.YELLOW);
        gc.fillText("Lives: " + lives, GeneralScene.GAME_WIDTH - 100, GeneralScene.GAME_HEIGHT - 15);
    }
}
