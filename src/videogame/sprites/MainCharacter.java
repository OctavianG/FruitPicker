package videogame.sprites;

import javafx.scene.image.Image;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MainCharacter extends Sprite {

    public static final int MAIN_CHARACTER_WIDTH = 96;
    public static final int MAIN_CHARACTER_HEIGHT = 96;
    public static final String IMAGE_PATH = "assets/bear.png";
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public MainCharacter() {

        super(MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);

        try {
            spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        spriteX = 0;
        spriteY = 0;
    }

    // the caracter only moves on X line
    public void move(int movement) {

        int newX = x;

        if (movement == LEFT) {
            newX -= 1;
        } else if (movement == RIGHT) {
            newX += 1;
        }

        moveTo(newX, y);
    }
}
