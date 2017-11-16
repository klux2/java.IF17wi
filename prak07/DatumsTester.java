//Diese Datei ist mal nicht vorgegeben, sondern selbst geschrieben :)

class DatumsTester
{

	public static void main(String[] args)
	{
		Datum d2 = new Datum(25, 10, 1917);
		Datum d1 = new Datum(11, 9, 1973);

		System.out.println("D1 Tag: " + d1.getTag());
		System.out.println("D1 Monat: " + d1.getMonat());
		System.out.println("D1 Jahr: " + d1.getJahr());

		System.out.println("D2: " + d2.toString());

		if( d1.equals(d2) )
		{
			System.out.println("D1 ist gleich D2!");
		}
		else
		{
			System.out.println("Unterschiedliche Daten!");
		}

		if(d2.vor(d1))
			System.out.println("D2 war vor D1!");

		if(Datum.vor(d2,d1))
			System.out.println("D2 war immer noch vor D1!");

		if( !Datum.istDatumGueltig(42, 13, -1892) )
			System.out.println("Jo, das sollte falsch sein...");

		if( Datum.istSchaltjahr(d1.getJahr()) )
			System.out.println("d1 ist schaltjahr!");
		else
			System.out.println("d1 ist kein schaltjahr :(");

		System.out.println("Februar hatte 2012: " + Datum.tageImMonat(2, 2012) + " Tage");

	}

}