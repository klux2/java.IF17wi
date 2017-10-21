public class PunktTester
{
	public static void main(String[] args)
	{
		Punkt p1 = new Punkt();
		Punkt p2 = new Punkt(2, 5);
		Punkt p3 = new Punkt(1.7, 2.4);

		/*ZUSATZ*/
		System.out.print( "Punkt 4 koordinaten eingeben: " );
		double x = Keyboard.readdouble();
		double y = Keyboard.readdouble();

		Punkt p4 = new Punkt(x,y);
		/*ZUSATZ ENDE*/

		System.out.println("p1.x = " + p1.getx());
		System.out.println("p1.y = " + p1.gety());

		System.out.println();	//leerzeile einfügen

		System.out.println( p2.toString() );

		p2.versetzen(3,3);
		System.out.println( p2.toString() );

		p2.verschieben(2,4);
		System.out.println( p2.toString() );

		System.out.println();	//leerzeile einfügen

		if( p2.equals(p1) )
		{
			System.out.println( "p2 ist gleich p1" );
		}
		else
		{
			System.out.println( "p2 ist nicht gleich p1" );
		}

		/*ZUSATZ*/
		Display d = new Display(400,500);
		d.show(p1);
		d.show(p2);
		d.show(p3);
		d.show(p4);

		System.out.println("P2: " + p2.toString() );
		System.out.println("P3: " + p3.toString() );
		p2.spiegelnX();
		p3.spiegelnY();
		System.out.println("P2: " + p2.toString() );
		System.out.println("P3: " + p3.toString() );

		System.out.println("P2 Abstand: " + p2.abstandUrsprung() );
		System.out.println("P2 Winkel: " + p2.winkelXAchse() );

		/*ZUSATZ ENDE*/
	}
}
