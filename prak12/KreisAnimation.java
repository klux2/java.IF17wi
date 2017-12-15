import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KreisAnimation extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Kreis-Animation");
        Ball ball = new Ball(500, 400, 200, 200, 50, 2, 1, 20);
        Scene scene = new Scene(ball.animiereBall());
        stage.setScene(scene);
        stage.show();
    }
}