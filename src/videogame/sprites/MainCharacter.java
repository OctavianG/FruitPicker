package videogame.sprites;

import javafx.scene.image.Image;
import videogame.scenes.GeneralScene;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MainCharacter extends AnimatedSprite {

    public static final int MAIN_CHARACTER_WIDTH = 96;
    public static final int MAIN_CHARACTER_HEIGHT = 96;
    public static final String IMAGE_PATH = "assets/bear.png";
    public static final int STEP = 4;


    public MainCharacter() {

        super(MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);

        try {
            spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // the sprite coordinates int the bear.png
        spriteXCoordinates[RIGHT] = new int[] {480, 576, 672, 576};
        spriteYCoordinates[RIGHT] = new int[] {0, 0, 0, 0};
        spriteXCoordinates[LEFT] = new int[] {1248, 1344, 1440, 1344};
        spriteYCoordinates[LEFT] = new int[] {0, 0, 0, 0};

        updateSpriteCoordinates();
    }

    // the caracter only moves on X line
    public void move(int movement) {

        int newX = x;

        if (movement == LEFT) {
            newX -= Math.min(STEP, x); //collision with the border
        } else if (movement == RIGHT) {
            newX += Math.min(STEP, GeneralScene.GAME_WIDTH - MAIN_CHARACTER_WIDTH - x); //collision with the border
        }

        moveTo(newX, y);
        animate(movement);
    }

    public void resetPosition() {

        moveTo(GeneralScene.GAME_WIDTH / 2 - MAIN_CHARACTER_WIDTH / 2,
                GeneralScene.GAME_HEIGHT - 30 - MAIN_CHARACTER_HEIGHT);
    }
}
