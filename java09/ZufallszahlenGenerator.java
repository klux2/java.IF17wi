public class ZufallszahlenGenerator {
    private long aktuellerWert;

    // Rechenberg
    /*
    private static final long a = 3421 ;
    private static final long c = 1 ;
    private static final long m = 65536 ;
    */
    
    // Knuth    
    private static final long a = 9301 ;
    private static final long c = 49297 ;
    private static final long m = 233280 ;
    
    
    // Sun (java.util.Random)
    /*
    private static final long a = 25214903917L ;
    private static final long c = 11 ;
    private static final long m = 281474976710655L ;
    */

    /**
     * Standardkonstruktor, der den aktuellen Wert f&uuml;r x_n auf <em>startWert</em> setzt.
     * 
     * @param startWert Startwert
     */

    public ZufallszahlenGenerator(long startWert) {
        aktuellerWert = startWert;
    }

    /**
     * Konstruktor, der den Standardkonstruktor mit der Systemzeit aufruft.
     */

    public ZufallszahlenGenerator() {
        this(System.currentTimeMillis());
    }

    /**
     * Aktualisiert den aktuellen Wert &uuml;ber den vorgegebenen Algorithmus.
     * x_n+1 = (x_n * a + c) % m
     */

    private void aktualisieren() {
        aktuellerWert = (aktuellerWert * a + c) % m;
    }

    /**
     * Gibt eine Zufallszahl zwischen 0 (inklusive) und 1 (exklusive) zur&uuml;ck.
     * Dabei wird zun&auml;chst die (private) <em>{@link #aktualisieren() aktualisieren()-Methode}</em> benutzt.
     * 
     * @return Zufallswert 0 &lt;= z &lt; 1
     */

    public double zufallsDouble() {
        aktualisieren();
        return (double) aktuellerWert / (double) m;
    }

    /**
     * Gibt eine Zufallszahl zwischen 0 (inklusive) und <em>max</em> (exklusive) zur&uuml;ck.
     * Daf&uuml;r wird ein Zufallswert der <em>{@link #zufallsDouble() zufallsDouble()-Methode}</em> benutzt.
     * 
     * @param max   exklusiver Maximalwert
     * @return  Zufallswert 0 &lt;= z &lt; <em>max</em>
     */

    public double zufallsDouble(double max) {
        return zufallsDouble() * max;
    }

    /**
     * Gibt eine Zufallszahl zwischen 0 (inklusive) und <em>max</em> (exklusive) zur&uuml;ck.
     * Daf&uuml;r wird ein Zufallswert der <em>{@link #zufallsDouble(double) 2. zufallsDouble()-Methode}</em> benutzt.
     * 
     * @param max   exklusiver Maximalwert
     * @return  Zufallswert 0 &lt;= z &lt; <em>max</em>
     */

    public int zufallsInt(int max) {
        return (int) Math.floor(zufallsDouble(max));
    }
}
