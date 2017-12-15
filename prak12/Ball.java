import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball {

    private Random rnd;
    private int pb, ph;
    private int x, y, r;
    private Color color;
    private int dx, dy;
    private final int dx_start, dy_start;
    private int intervall;
    private Circle circle;
    private Pane animationPane;

    public Ball(int pb, int ph, int x, int y, int r, int dx, int dy, int intervall) {
        rnd = new Random();

        this.pb = pb;
        this.ph = ph;
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1);
        this.dx = dx;
        this.dy = dy;
        this.dx_start = dx;
        this.dy_start = dy;
        this.intervall = intervall;
    }

    public Pane animiereBall() {
        animationPane = new Pane();
        animationPane.setPrefSize(pb, ph);

        circle = new Circle(x, y, r, color);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame moveBall = new KeyFrame(Duration.millis(intervall), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (((circle.getCenterX() + dx < r) && (dx < 0)) || ((circle.getCenterX() + dx > animationPane.getWidth() - r) && (dx > 0))) {
                    dx = -dx;
                }
                circle.setCenterX(circle.getCenterX() + dx);
                
                if (((circle.getCenterY() + dy < r) && (dy < 0)) || ((circle.getCenterY() + dy > animationPane.getHeight() - r) && (dy > 0))) {
                    dy = -dy;
                }
                circle.setCenterY(circle.getCenterY() + dy);
            }
        });

        timeline.getKeyFrames().add(moveBall);
        timeline.play();

        HBox hBox = this.navigiereAnimation(timeline);

        animationPane.getChildren().addAll(circle, hBox);

        return animationPane;
    }

    private HBox navigiereAnimation(Timeline tl) {
        HBox hBox = new HBox();
        hBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Label status = new Label("Animation wurde gestartet.");

        Button play = new Button("Start"), pause = new Button("Pause"), stop = new Button("Stopp"), restart = new Button("Restart");
        play.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tl.play();
                status.setText("Animation wurde gestartet.");
            }
        });
        pause.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tl.pause();
                status.setText("Animation wurde pausiert.");
            }
        });
        stop.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tl.stop();
                circle.setCenterX(x);
                circle.setCenterY(y);
                dx = dx_start;
                dy = dy_start;
                status.setText("Animation wurde gestoppt.");
            }
        });
        restart.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                circle.setCenterX(x);
                circle.setCenterY(y);
                dx = dx_start;
                dy = dy_start;
                tl.playFromStart();
                status.setText("Animation wurde neu gestartet.");
            }
        });

        hBox.getChildren().addAll(play, pause, stop, restart, status);

        return hBox;
    }
}
