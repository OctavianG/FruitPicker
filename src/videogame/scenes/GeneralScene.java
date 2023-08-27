package videogame.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.lang.reflect.Member;
import java.util.HashSet;
import java.util.Set;

public abstract class GeneralScene extends Scene {

    public static final int GAME_WIDTH = 816;
    public static final int GAME_HEIGHT = 480;

    // Container to include the canvas
    private StackPane root = new StackPane();
    protected Set<KeyCode> activeKeys;
    protected Set<KeyCode> releasedKeys;
    protected MediaPlayer mediaPlayer;
    protected Media sound;

    // Objects that permits to draw different elements inside the canvas
    protected GraphicsContext gc;

    public GeneralScene() {

        // Call Scene constructor to initialize it
        super(new StackPane(), GAME_WIDTH, GAME_HEIGHT);

        // Change scene's root to our own stack pane
        root = new StackPane();
        this.setRoot(root);

        // Initialize canvas and graphics context
        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        // Initialize set of currently pressed and released keys
        activeKeys = new HashSet<>();
        releasedKeys = new HashSet<>();

        // Events
        this.setOnKeyPressed(e -> {
            activeKeys.add(e.getCode());
        });
        this.setOnKeyReleased(e -> {
            activeKeys.remove(e.getCode());
            releasedKeys.add(e.getCode());
        });
    }

    // To permit any subclass to draw itself in the canvas
    public abstract void draw();
}


