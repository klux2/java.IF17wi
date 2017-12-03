import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.*;
import javafx.scene.input.*;

public class EinErstesBeispiel extends Application
    {
    /*
       Application:
       Anwendungsklasse; Sie stellt ein Fenster mit Rahmen,
       Systemmenü und Standardschaltflächen zur Verfügung.
     */

    public static void main(String[] args)
    {
            // launch() startet die Anwendung

            Application.launch(args);
    }

    /*
       Überschriebene Methode start() : wird beim Erzeugen der
       Anwendung aufgerufen und legt den Inhalt des Fensters fest.
     */

    public void start(Stage primaryStage)
    {
            /*
               Stage: oberster JavaFX-Container, in der Regel ein Fenster
             */

            primaryStage.setTitle("Ein JavaFX Beispiel");
            primaryStage.setResizable(false);

            /*
               Erzeugung der Komponente Label
             */
            //Label label = new Label("Ein erstes JavaFX Beispiel!");

            Canvas canvas = new Canvas(300, 250);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e->paint(gc, e));

            /*
               VBox: Layout Container, in dem die Inhalte fließend vertikal angeordnet werden
             */
            VBox root = new VBox();

            /*
               Label zur VBox hinzufügen
             */
            //root.getChildren().add(label);

            root.getChildren().add(canvas);

            /*
               Scene: beschreibt den Inhalt des Fensters
             */
            Scene scene = new Scene(root);

            /*
               Scene dem Fenster hinzufügen
             */
            primaryStage.setScene(scene);

            /*
               show() zeigt das Fenster auf dem Bildschirm an.
             */
            primaryStage.show();
    }

    /**
     * Malt einen Punkt der Gr&ouml;&szlig;e 20 auf die Zeichenfl&auml;che.
     * Daf&uuml;r wird die x- und y-Koordinate des Mausklick-MouseEvent verwendet.
     *
     * @param gc    GraphicsContext des Canvas, also der Zeichenfl&auml;che
     * @param e     Maus-Klick-Event
     */

    public void paint(GraphicsContext gc, MouseEvent e) {
            gc.fillOval(e.getX(), e.getY(), 20, 20);
    }
}
