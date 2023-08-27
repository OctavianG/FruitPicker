package videogame.sprites;

import javafx.scene.image.Image;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Fruit extends Sprite {

    private static final String IMAGE_PATH = "assets/fruits.png";
    public static final  int MAX_FRUITS = 5;
    public static final  int FRUIT_WIDTH = 30;
    public static final  int FRUIT_HEIGHT = 30;
    public static float STEP_INCREMENT = 0f;

    public Fruit() {

        this((int)(Math.random() * MAX_FRUITS));
    }

    public Fruit(int fruitType) {

        super(FRUIT_WIDTH, FRUIT_HEIGHT);

        try {
            spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (fruitType) {
            case 0:
                // Banna
                this.spriteX = 4;
                this.spriteY = 40;
                break;
            case 1:
                // Strawberry
                this.spriteX = 42;
                this.spriteY = 40;
                break;
            case 2:
                // Pear
                this.spriteX = 8;
                this.spriteY = 6;
                break;
            case 3:
                // Watermelon
                this.spriteX = 42;
                this.spriteY = 7;
                break;
            case 4:
                // Orange
                this.spriteX = 79;
                this.spriteY = 7;
                break;
        }
    }

    public void move() {

        this.y += (int) (1 + STEP_INCREMENT);
    }

    public void increaseDifficulty() {

        STEP_INCREMENT += 0.1f;
    }







}
