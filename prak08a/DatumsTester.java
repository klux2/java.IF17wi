public class DatumsTester
{

	public static void main(String[] args)
	{
		int[] datum = {1, 8, 1914};
		Datum d1 = new Datum( datum ); 
		Datum d2 = new Datum( "22.06.1941" );

		Datum d3 = Datum.parseDatum( "02.05.1945" );

		System.out.println("Datum eingeben: ");
		Datum d4 = Datum.readDatum();

		System.out.println( d1.toString3() );
		System.out.println( d2.toString3() );
		System.out.println( d3.toString3() );
		System.out.println( d4.toString3() );

		System.out.println( d1.tagnummerImJahr() );
		System.out.println( d2.anzahlTageBis(d3) );

	}

}