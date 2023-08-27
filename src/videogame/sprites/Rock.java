package videogame.sprites;

import javafx.scene.image.Image;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Rock extends Sprite {

    private static final String IMAGE_PATH = "assets/Rocks_source_no_shadow.png";
    public static final  int MAX_ROCKS = 5;
    public static final  int ROCK_WIDTH = 30;
    public static final  int ROCK_HEIGHT = 30;

    public Rock() {

        this((int)(Math.random() * MAX_ROCKS));
    }

    public Rock(int rockType) {

        super(ROCK_WIDTH, ROCK_HEIGHT);

        try {
            spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (rockType) {
            case 0:
                // Grey rock
                this.spriteX = 2;
                this.spriteY = 240;
                break;
            case 1:
                // Standard rock
                this.spriteX = 33;
                this.spriteY = 240;
                break;
            case 2:
                // Granite
                this.spriteX = 67;
                this.spriteY = 240;
                break;
            case 3:
                // Golden rock
                this.spriteX = 98;
                this.spriteY = 240;
                break;
            case 4:
                // Hole rock
                this.spriteX = 97;
                this.spriteY = 273;
                break;
        }
    }

    public void move() {

        this.y++;
    }
}
