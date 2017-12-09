import javafx.application.Platform;
import javafx.event.*;

public class RateSpielStrg {
	private Mitspieler mitspieler;
	private RateSpielGUI gui;
	private int zaehler;

	/**
	 * Standard-Konatruktor, der eine GUI verwaltet.
	 * Es wird ein neuer Mitspieler mit einem Zufallswert angelegt, au&szlig;erdem wird ein Action-Handler 
	 * f&uuml;r Button und Menu-Items hinzugef&uuml;gt.
	 * 
	 * @param rateSpielGUI	GUI als BorderPane-Object
	 */
	
	public RateSpielStrg(RateSpielGUI rateSpielGUI) {
		mitspieler = new Mitspieler();
		gui = rateSpielGUI;
		gui.getVersuchKnopf().addEventHandler(ActionEvent.ACTION, e -> versuch());
		gui.getNeuOpt().addEventHandler(ActionEvent.ACTION, e -> neuesSpiel());
		gui.getEndeOpt().addEventHandler(ActionEvent.ACTION, e -> endeSpiel());
		zaehler = 0;
	}

	/**
	 * Methode, die nach einem Button-Click ausgef&uuml;hrt wird und den aktuellen Wert pr&uuml;ft.
	 */
	
	public void versuch() {
		zaehler++;					// + 1 Versuch
		gui.ausgabeNachricht(zaehler + ". Versuch: " + mitspieler.bewertung(gui.holeVersuch()));
		/*
		// Langform (nicht getestet):
		String versuch = gui.holeVersuch();							// Aktuellen Wert des Textfelds versuchTF holen ...
		String bewertung = mitspieler.bewertung(versuch);			// ... vom "Mitspieler" bewerten lassen ...
		gui.ausgabeNachricht(zaehler + ". Versuch: " + bewertung);	// ... und das Ergebnis in das Textfeld nachrichtTF schreiben.
		*/
		if (mitspieler.bewertung(gui.holeVersuch()).startsWith("Erraten")) {	// Wenn die Zahl erraten wurde ...
			gui.setEnabled(false);												// ... deaktiviere Button und Textfeld
		}
	}

	/**
	 * Methode, die ein neues Spiel beginnt.
	 * Wird mit dem "Neues Spiel"-MenuItem ausgel&ouml;st.
	 */
	
	public void neuesSpiel() {
		mitspieler = new Mitspieler();												// neue Zufallszahl
		gui.ausgabeNachricht("Kannst du eine Zahl zwischen 0 und 100 erraten?");	// neue Nachricht setzen
		gui.setEnabled(true);														// Button und Textfeld aktivieren
		zaehler = 0;																// Versuche auf 0 setzen
	}

	/**
	 * Methode zum Beenden des Spiels.
	 * Wird mit dem "Beenden"-MenuItem ausgel&ouml;st.
	 */
	
	public void endeSpiel() {
		Platform.exit();
	}
}
