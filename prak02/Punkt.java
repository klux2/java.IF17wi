public class Punkt
{
	//Attribute definieren
	private double x;
	private double y;

	//Konstruktoren definieren
	public Punkt()
	{
		x = 0;
		y = 0;
	}

	public Punkt(double newx, double newy)
	{
		x = newx;
		y = newy;
	}

	//Methoden (Funktionen) definieren
	public double getx() { return x; };	//java ist es egal, wie wir formatieren.
	public double gety() { return y; };	//man könnte das auch über viele Zeilen schreiben

	public void versetzen(double newx, double newy)
	{
		x = newx;
		y = newy;
	}

	public void verschieben(double dx, double dy)
	{
		x += dx;
		y += dy;
	}

	public String toString()
	{
		//gib "(x|y)" zurück
		return "( " + x + "|" + y + " )";
	}

	public boolean equals( Punkt p )	//boolean ist ein Wahrheitswert
	{
		// == bedeutet "gleich" im Mathematischen Sinne, also vergleichen
		// && bedeutet "UND" ; wie in der Aussagenlogik
		//es gibt keine klare Rangordnung zwischen den Symbolen, anders als bei +-*/ !!
		//deshalb sind Klammern sehr wichtig! Lieber eine zu viel als zu wenig!

		//Hier die elegante schreibweise
		return ( (x == p.getx()) && (y == p.gety()) );

		/*Hier die ausführliche schreibweise
		if( (x == p.getx()) && (y == p.gety()) )	//falls X gleich und Y gleich,
		{
			return true;							//dann gib Wahr zurück
		}
		else										//Ansonsten
		{
			return false;							//gib Falsch zurück
		}*/
	}

	/* ZUSATZ */
	public void spiegelnX()
	{
		x = -x;
	}
	public void spiegelnY()
	{
		y = -y;
	}
	public double abstandUrsprung()
	{
		return Math.sqrt( x*x + y*y );
	}
	public double winkelXAchse()
	{
		//cos(a) = (u·v)/(|u|*|v|)
		//u = (1|0) - x Achse
		//v = (x|y) - Punkt
		double dist = abstandUrsprung();
		double cos = x/dist;	//(x*1+y*0)/(dist*1)
		double acos = Math.acos( cos );	//gibt in Radians zurück
		return Math.toDegrees( acos ); // in Grad umwandeln
	}
	/* ZUSATZ ENDE */

}
