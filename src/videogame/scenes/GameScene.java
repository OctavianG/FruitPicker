package videogame.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import videogame.FruitPicker;

public class GameScene extends GeneralScene {

    public GameScene() {

        super();
    }

    private void showGameMessage() {

        Font myFont = Font.font("Arial", FontWeight.NORMAL, 24);
        gc.setFont(myFont); // add font to GraphicsContext
        gc.setFill(Color.YELLOW); // font color
        // message + horizontal coordinate +  vertical coordinate
        gc.fillText("Game Scene", 325, 200);
    }


    @Override
    public void draw() {

        // In case there is any pending keys
        activeKeys.clear();

        // Repeats the code many times/second
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                // Black background
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

                showGameMessage();

                if (activeKeys.contains(KeyCode.ESCAPE)) {
                    this.stop();
                    FruitPicker.setScene(FruitPicker.WELCOME_SCENE);
                } else if (activeKeys.contains(KeyCode.ENTER)) {
                    this.stop();
                    FruitPicker.setScene(FruitPicker.CREDITS_SCENE);
                }
            }
        };

        animationTimer.start();
    }
}
