public class Rechteck
{
	private Punkt startpunkt;
	private double hoehe;
	private double breite;

	public Rechteck(Punkt start, double h, double b)
	{
		startpunkt = start;
		hoehe = h;
		breite = b;
	}

	public Rechteck(double x, double y, double h, double b)
	{
		//not sure if this works - compiler will tell us
		startpunkt = new Punkt(x,y);
		hoehe = h;
		breite = b;
	}

	public Punkt getStartpunkt(){ return startpunkt; }
	public double getHoehe(){ return hoehe; }
	public double getBreite(){ return breite; }

	public double berechneFlaeche()
	{
		return hoehe * breite;
	}

	public double berechneUmfang()
	{
		return 2*(hoehe + breite);
	}

	public void versetzen(double xnew, double ynew)
	{
		startpunkt.versetzen(xnew, ynew);
	}

	public void verschieben(double dx, double dy)
	{
		startpunkt.verschieben(dx, dy);
	}

	public String toString()
	{
		return "Start: " + startpunkt.toString() + " Hoehe: " + hoehe + " Breite: " + breite;
	}

	public boolean equals(Rechteck r)
	{
		return (startpunkt.equals(r.getStartpunkt())) && (hoehe == r.getHoehe()) && (breite == r.getBreite());
	}

	/* ZUSATZ */
	public String eckpunkte()
	{
		double x = startpunkt.getx();
		double y = startpunkt.gety();
		Punkt p2 = new Punkt( x+breite, y );
		Punkt p3 = new Punkt( x, y+hoehe );
		Punkt p4 = new Punkt( x+breite, y+hoehe );

		return "P1: " + startpunkt.toString() + " P2: " + p2.toString()
				+ "\nP3: " + p3.toString() + " P4: " + p4.toString();
	}

	public void spiegelnX()
	{
		startpunkt.spiegelnX();
		//Display1 mag keine negative breite/höhe
		startpunkt.versetzen( startpunkt.getx()-breite, startpunkt.gety() );
	}
	public void spiegelnY()
	{
		startpunkt.spiegelnY();
		//Display1 mag keine negative breite/höhe
		startpunkt.versetzen( startpunkt.getx(), startpunkt.gety()-hoehe );
	}

	//das ist hier jetzt nicht hübsch, oder besonders effizient,
	//aber es macht was es soll, und es ist übersichtlicher
	public boolean gemeinsamePunkte(Rechteck r)
	{
		double x = startpunkt.getx();
		double y = startpunkt.gety();
		double xr = r.getStartpunkt().getx();
		double yr = r.getStartpunkt().gety();

		//die anderen Eckpunkte berechnen
		Punkt p2 = new Punkt( x+breite, y );
		Punkt p3 = new Punkt( x, y+hoehe );
		Punkt p4 = new Punkt( x+breite, y+hoehe );

		Punkt pr2 = new Punkt( xr+r.getBreite(), yr );
		Punkt pr3 = new Punkt( xr, yr+r.getHoehe() );
		Punkt pr4 = new Punkt( xr+r.getBreite(), yr+r.getHoehe() );

		//gucken ob eckpunkte übereinstimmen
		boolean b1 = startpunkt.equals( r.getStartpunkt() );
		boolean b2 = p2.equals(pr2);
		boolean b3 = p3.equals(pr3);
		boolean b4 = p4.equals(pr4);

		// || ist das logische "oder"
		return b1 || b2 || b3 || b4;

	}
	/* ZUSATZ ENDE */
}
