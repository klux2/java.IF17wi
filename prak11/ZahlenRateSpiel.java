import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.*;

public class ZahlenRateSpiel extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("Zahlenraten");					// Titel setzen
		RateSpielGUI gui = new RateSpielGUI();			// neue GUI erstellen
		RateSpielStrg strg = new RateSpielStrg(gui);	// neue Steuerung mit dieser GUI als Attribut
		Scene scene = new Scene(gui, 500, 100);			// neue Scene, die 500x100 (BxH) groß ist
		stage.setScene(scene);							// Scene auf die Stage
		stage.show();									// Stage anzeigen
	}
}
