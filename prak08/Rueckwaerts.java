public class Rueckwaerts {
	
	/**
	 * Gibt die Kommandozeile rueckwaerts aus.
	 * Das Herausfinden des Names der Klasse wird dabei etwas umstaendlich geloest, indem ein neues Objekt der Klasse erzeugt wird.
	 * Der Vorteil dieser Methode ist, dass sie auch noch funktioniert, wenn der Name sich aendert.
	 * 
	 * @param args BeliebigeArgumente
	 */

	public static void main(String[] args) {
		for (int i = args.length - 1; i >= 0; i--) {		// faengt beim letzten Parameter an und geht bis zum ersten
			System.out.print(umdrehen(args[i]) + " ");		// dreht den jeweiligen Parameter um und gibt ihn aus
															//	"print" statt "println" gibt danach keinen Zeilenumbruch aus
		}
		
		String currentClass = new Object() { }.getClass().getEnclosingClass().getName();				// currentClass = Name der Klasse (z. B. java08.Rueckwaerts)
		System.out.print(umdrehen(currentClass.substring(currentClass.lastIndexOf('.') + 1)) + " ");	// nimmt den Teil nach dem letzten Punkt, dreht ihn um und gibt ihn aus 
		System.out.println("avaj");
		
		/* Alternativ: */
		//System.out.println("streawkceuR avaj");

	}
	
	/**
	 * Hilfsmethode zum Umdrehen einer Zeichenkette.
	 * Der uebergebene String wird rueckwaerts zurueckgegeben.
	 * 
	 * @param string eingegebenerString
	 * @return umgedrehterString
	 */
	
	private static String umdrehen(String string) {
		String rueckwaerts = "";
		for (int j = string.length() - 1; j >= 0; j--) {	// j faengt mit dem letzten Zeichen und geht bis zum ersten
			rueckwaerts = rueckwaerts + string.charAt(j);	// fuegt dem Rueckgabestring jeweils das Zeichen an Position j an
		}
		return rueckwaerts;
	}

}
