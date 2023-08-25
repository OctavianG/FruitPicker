package videogame.scenes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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

        // Every time the scene redraws;
        showCreditsMessage();
    }
}
