package videogame.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

    protected int width, height; // sprite dimensions
    protected int x, y; // sprite coordinates in the scene
    protected int spriteX, spriteY; // sprite coordinates int the hole image
    protected Image spriteImage; // the image with the sprites

    public Sprite(int width, int height) {

        this.width = width;
        this.height = height;
    }

    // change the sprite in the scene
    public void moveTo(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public void draw(GraphicsContext gc) {

        // the sprite Image, the coordinates of the sprite, the dimensions of the sprite
        // the x and y coordinates int the scene and the dimensions in the scene
        gc.drawImage(spriteImage, spriteX, spriteY, width,
                height, x, y, width, height);
    }
}
