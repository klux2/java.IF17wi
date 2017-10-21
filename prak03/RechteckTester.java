public class RechteckTester
{
	public static void main(String[] args)
	{
		Punkt p1 = new Punkt(2,1);
		Rechteck r1 = new Rechteck(p1, 5, 3);
		Rechteck r2 = new Rechteck(1,1,3,5);

		System.out.println("Rechteck r1: " + r1.toString());
		System.out.println("Rechteck r2: " + r2.toString());

		System.out.println("r1 Fläche: " + r1.berechneFlaeche());
		System.out.println("r1 Umfang: " + r1.berechneUmfang());
		System.out.println("r2 Fläche: " + r2.berechneFlaeche());
		System.out.println("r2 Umfang: " + r2.berechneUmfang());

		if( r1.equals(r2) )
		{
			System.out.println("R1 ist gleich R2");
		}
		else
		{
			System.out.println("R1 ist nicht gleich R2");
		}

	}
}
