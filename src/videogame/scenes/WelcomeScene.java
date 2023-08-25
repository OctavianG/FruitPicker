package videogame.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import jdk.jfr.internal.consumer.EventLog;
import videogame.FruitPicker;

public class WelcomeScene extends GeneralScene {

    public WelcomeScene() {

        super();
        showWelcomeMessage();
    }

    private void showWelcomeMessage() {

        Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
        gc.setFont(myFont); // add font to GraphicsContext
        gc.setFill(Color.RED); // font color
        // message + horizontal coordinate +  vertical coordinate
        gc.fillText("FruitPicker game", 275, 200);

        myFont = Font.font("Arial", FontWeight.NORMAL, 20);
        gc.setFont(myFont);
        gc.setFill(Color.WHITE);
        gc.fillText("Press Spacebar to play", 295, 275);
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

                showWelcomeMessage();

                if (activeKeys.contains(KeyCode.SPACE)) {
                    this.stop();
                    FruitPicker.setScene(FruitPicker.GAME_SCENE);
                } else if (activeKeys.contains(KeyCode.ESCAPE)) {
                    this.stop();
                    FruitPicker.exit();
                }
            }
        };

        animationTimer.start();
    }
}

