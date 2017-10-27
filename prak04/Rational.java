public class Rational
{
	/**
	 * Zähler der rationalen Zahl
	 */
	private int zaehler;

	/**
	 * Nenner der rationalen Zahl
	 */
	private int nenner;

	//Klassenkonstanten (ZUSATZ)
	public static final Rational NULL = new Rational(0,1);
	public static final Rational EINS = new Rational(1,1);

	/**
	 * Konstruktor für eine rationale Zahl
	 * 
	 * @param	z	der Zähler
	 * @param	n	der Nenner
	 */
	public Rational(int z, int n)
	{
		zaehler = z;
		nenner = n;
	}

	/**
	 * Konstruktor für eine rationale Zahl ohne Parameter
	 */
	public Rational()
	{
		zaehler = 0;
		nenner = 1;
	}

	/** Rückgabemethode für den Zähler
	 * @return	der Zähler
	 */
	public int getZaehler() { return zaehler; }

	/** Rückgabemethode für den Nenner
	 * @return	der Nenner
	 */
	public int getNenner() { return nenner; }
	
	/**
	 * Methode um eine rationale Zahl in X/Y schreibweise auszugeben
	 * 
	 * @return String Zähler/Nenner
	 */
	public String toString()
	{
		return zaehler + "/" + nenner;
	}

	/**
	 * Objektmethode zum vergleichen rationaler Zahlen
	 * 
	 * @param	r	zweite rationale Zahl
	 * @return		true, wenn gleich
	 */
	public boolean equals(Rational r)
	{
		return (zaehler * r.getNenner() == nenner * r.getZaehler());
	}

	/**
	 * Objektmethode um rationale Zahl als Dezimalzahl auszugeben
	 * 
	 * @return	"Zähler/Nenner" als Kommazahl
	 */
	public double doubleValue()
	{
		return (double)zaehler/(double)nenner;
	}

	//etwas ausführlicher als verlangt
	//meiner Meinung nach aber übersichtlicher

	/**
	 * Objektmethode für die Addition rationaler Zahlen
	 * 
	 * @param 	r 	der zweite Summand
	 * @return 		die Summe
	 */
	public Rational plus(Rational r)
	{
		int newZaehler = zaehler * r.getNenner() + r.getZaehler() * nenner;
		int newNenner = nenner * r.getNenner();
		return new Rational( newZaehler, newNenner );
	}

	/**
	 * Objektmethode für die Subtraktion rationaler Zahlen
	 * 
	 * @param	r	der Subtrahend
	 * @return		die Differenz
	 */
	public Rational minus(Rational r)	
	{
		int newZaehler = zaehler * r.getNenner() - r.getZaehler() * nenner;
		int newNenner = nenner * r.getNenner();
		return new Rational( newZaehler, newNenner );
	}

	/**
	 * Objektmethode für die Multiplikation rationaler Zahlen
	 * 
	 * @param	r	der zweite Faktor
	 * @return		das Produkt
	 */
	public Rational mal(Rational r)
	{
		int newZaehler = zaehler * r.getZaehler();
		int newNenner = nenner * r.getNenner();
		return new Rational( newZaehler, newNenner );
	}

	/**
	 * Objektmethode für die Division rationaler Zahlen
	 * 
	 * @param	r	der Divisor
	 * @return		der Quotient
	 */
	public Rational durch(Rational r)	
	{
		//durch == mal mit Reziproke
		int newZaehler = zaehler * r.getNenner();
		int newNenner = nenner * r.getZaehler();
		return new Rational( newZaehler, newNenner );
	}


	/* AB HIER ZUSATZ ; dafür keine Dokumentation, ich bin faul :P */
	public Rational gekuerzterBruch()
	{
		int teiler = ggt( nenner, zaehler );
		return new Rational( zaehler/teiler, nenner/teiler );
	}

	private int ggt(int a, int b)
	{
		int r;
		while( b != 0 )
		{
			r = a%b;	//a mod b == divisionsrest
			a = b;
			b = r;
		}
		return a;
	}

	public boolean groesserAls(Rational r)
	{
		//das ist wahrscheinlich cheaten... aber egal
		return doubleValue() > r.doubleValue();
	}

	public static Rational plus(Rational r1, Rational r2)
	{
		int newZaehler = r1.getZaehler() * r2.getNenner() + r2.getZaehler() * r1.getNenner();
		int newNenner = r1.getNenner() * r2.getNenner();
		return new Rational( newZaehler, newNenner );
	}
	public static Rational minus(Rational r1, Rational r2)
	{
		int newZaehler = r1.getZaehler() * r2.getNenner() - r2.getZaehler() * r1.getNenner();
		int newNenner = r1.getNenner() * r2.getNenner();
		return new Rational( newZaehler, newNenner );
	}
	public static Rational mal(Rational r1, Rational r2)
	{
		int newZaehler = r1.getZaehler() * r2.getZaehler();
		int newNenner = r1.getNenner() * r2.getNenner();
		return new Rational( newZaehler, newNenner );
	}
	public static Rational durch(Rational r1, Rational r2)
	{
		int newZaehler = r1.getZaehler() * r2.getNenner();
		int newNenner = r1.getNenner() * r2.getZaehler();
		return new Rational( newZaehler, newNenner );
	}

}