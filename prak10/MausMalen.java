import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.scene.image.*;

public class MausMalen extends Application {

    private Point2D aktuellerPunkt, vorherigerPunkt;
    private Color zeichenFarbe;

    public static void main(String[] args) {
            Application.launch(args);		// startet die Anwendung
    }

    /**
	 * &Uuml;berschriebene Methode start(): wird beim Erzeugen der Anwendung aufgerufen und legt den Inhalt des Fensters fest.
     */

    public void start(Stage primaryStage) {

		

		primaryStage.setTitle("Maus-Malen");
		primaryStage.setResizable(false);

		Canvas canvas = new Canvas(300, 250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e->setAktuellerPunkt(e, gc));
		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e->neuerAktuellerPunkt(e, gc));

		ColorPicker cp = new ColorPicker();
		cp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		cp.addEventHandler(ActionEvent.ACTION, e->setZeichenfarbe(cp.getValue()));

		//ImageView imageView = new ImageView(new Image("radiergummi.png"));  // dafuer muss das Bild im aktuellen Verzeichnis sein

		//Button button = new Button("Clear", imageView);                     // sonst gibt es eine Fehlermeldung
		Button button = new Button("Clear");                                  // Diese Zeile muss raus, damit das Bild da ist.
		button.addEventHandler(ActionEvent.ACTION, e->loeschen(canvas, gc));
		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button.setStyle("-fx-font: 15 arial; -fx-base: #e79423;");

		zeichenFarbe = cp.getValue();
		
		VBox root = new VBox();

		root.getChildren().addAll(canvas, cp, button);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
    }

    /**
     * Setzt <em>aktuellerPunkt</em> auf den aktuellen x- und y-Wert.
     *
     * @param e	Maus-Klick-Event
     */

    public void setAktuellerPunkt(MouseEvent e, GraphicsContext gc) {
            aktuellerPunkt = new Point2D(e.getX(), e.getY());
            vorherigerPunkt = aktuellerPunkt;
            paintLinie(gc);
    }

    /**
     * Aktualisiert die Punkte und zeichnet eine Linie.
     * Setzt <em>vorherigerPunkt</em> auf <em>aktuellerPunkt</em> und
     * <em>aktuellerPunkt</em> auf den aktuellen x- und y-Wert.
     * Dann werden die beiden mit der
     * <em>{@link #paintLinie(GraphicsContext) paintLinie()-Methode}</em> verbunden.
     *
     * @param e	Maus-Klick-Event
     */

    public void neuerAktuellerPunkt(MouseEvent e, GraphicsContext gc) {
            vorherigerPunkt = aktuellerPunkt;
            aktuellerPunkt = new Point2D(e.getX(), e.getY());
            paintLinie(gc);
	}
	
	/**
	 * Zeichnet eine Linie von <em>vorherigerPunkt</em> zu <em>aktuellerPunkt</em>.
	 * 
	 * @param gc	Zeichenfl&auml;che
	 */

    public void paintLinie(GraphicsContext gc) {
            gc.setFill(zeichenFarbe);
            gc.setStroke(zeichenFarbe);
            gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), aktuellerPunkt.getX(), aktuellerPunkt.getY());
	}
	
	/**
	 * &Auml;ndert die Farbe.
	 * 
	 * @param FarbeNeu	neue Farbe
	 */

    public void setZeichenfarbe(Color FarbeNeu) {
            zeichenFarbe = FarbeNeu;
	}
	
	/**
	 * L&ouml;scht alles.
	 * 
	 * @param canvas	Leinwand
	 * @param gc		Zeichenfl&auml;che
	 */

    public void loeschen(Canvas canvas, GraphicsContext gc) {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
