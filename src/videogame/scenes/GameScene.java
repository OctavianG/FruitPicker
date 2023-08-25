package videogame.scenes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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

        // Every time the scene redraws;
        showGameMessage();
    }
}
