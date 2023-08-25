package videogame.scenes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
        gc.fillText("Press Spacebar to play", 325, 275);
    }

    @Override
    public void draw() {

        // Every time the scene redraws;
        showWelcomeMessage();
    }
}
