public class RechteckTester1
{
	public static void main(String[] args)
	{
		Rechteck r1 = new Rechteck(2,2,5,3);

		Rechteck r2 = new Rechteck(1,1,6,4);

		Display1 d = new Display1(400,500);
		d.show(r1);
		d.show(r2);

		/* ZUSATZ */
		System.out.println( "R1: " + r1.eckpunkte() );
		System.out.println( "R2: " + r2.eckpunkte() );

		r1.spiegelnX();
		System.out.println( r1.toString() );

		r1.spiegelnY();
		System.out.println( r1.toString() );

		if( r1.gemeinsamePunkte(r2) )
		{
			System.out.println("r1 und r2 haben gemeinsame Punkte");
		}
		else
		{
			System.out.println("keine gemeinsamen Punkte");
		}

	}
}
