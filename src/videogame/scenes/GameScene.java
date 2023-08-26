package videogame.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import videogame.FruitPicker;
import javafx.scene.image.Image;
import videogame.sprites.MainCharacter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GameScene extends GeneralScene {

    private static final String BACKGROUND_IMAGE = "assets/background.png";

    private Image background;
    private MainCharacter bear;

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

        // In case there is any pending keys
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
            }
        };

        animationTimer.start();
    }
}
