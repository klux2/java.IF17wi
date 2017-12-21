import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VierGewinnt extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Vier gewinnt");
        SpielFeld spielFeld = new SpielFeld();
        Scene scene = new Scene(spielFeld);
        stage.setScene(scene);
        stage.show();
    }
}