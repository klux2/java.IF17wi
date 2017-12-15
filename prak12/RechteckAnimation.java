import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RechteckAnimation extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Rechteck-Animation mit KeyValues");
        Scene scene = new Scene(Rechteck.animiereRechteck());
        stage.setScene(scene);
        stage.show();
    }
}
