package videogame.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import videogame.FruitPicker;

public class CreditsScene extends GeneralScene {

    public CreditsScene() {

        super();
    }

    private void showCreditsMessage() {

        Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
        gc.setFont(myFont); // add font to GraphicsContext
        gc.setFill(Color.GREEN); // font color
        // message + horizontal coordinate +  vertical coordinate
        gc.fillText("Game Over", 325, 200);

        myFont = Font.font("Arial", FontWeight.NORMAL, 20);
        gc.setFont(myFont);
        gc.setFill(Color.WHITE);
        gc.fillText("Press Spacebar to go back to Welcome Scene", 200, 275);
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

                showCreditsMessage();

                if (activeKeys.contains(KeyCode.SPACE)) {
                    this.stop();
                    FruitPicker.setScene(FruitPicker.WELCOME_SCENE);
                }
            }
        };

        animationTimer.start();
    }
}
