/*Ich benutze ab hier englische Namen, da Wuerfel echt scheiße zu schreiben ist... */

class DiceTest
{
	public static void main(String[] args)
	{
		int numberOfThrows = 500;
		int[] results = new int[ numberOfThrows ];
		int[] frequency = new int[6];
		int sum = 0;
		double avg = 0.0;
		double variance = 0.0;
		double deviation = 0.0;

		for( int i = 0; i < numberOfThrows; i++ )
		{
			results[i] = (int)(Math.random()*6+1);

			frequency[ results[i]-1 ]++;	//die Häufigkeit der gewürfelten Zahl hochzählen.

			sum += results[i];	//Summe.

			//System.out.print( " " + results[i] + " " ); //liste ist viel zu lang bei 30000 Würfen!
		}
		System.out.println();
		
		//nach double casten um sicherzustellen, dass er nicht Ganzzahlige Division macht
		avg = (double)sum/(double)numberOfThrows;

		System.out.println("Summe: " + sum);
		System.out.println("Durchschnitt: " + avg);
		
		System.out.println();
		for( int i = 0; i < 6; i++ )
		{
			System.out.println("Häufigkeit von " + (i+1) + ": " + frequency[i] );
			System.out.println("rel. Häufigkeit: " + ((double)frequency[i]/(double)numberOfThrows) );
		}
		System.out.println();

		long varsum = 0;
		for(int i = 0; i < numberOfThrows; i++)
		{
			varsum += Math.pow(results[i] - avg, 2);	//pow(x,y) == x^y
		}

		variance = 1.0/(double)(numberOfThrows-1)*varsum;
		deviation = Math.sqrt( variance );

		System.out.println("Varianz: " + variance);
		System.out.println("Standardabweichung: " + deviation);

	}

	//Wissenschaftliche Ergebnisse:
	//Durchschnitt wird sich bei ~3.5 einpendeln
	//rel. Häufigkeit bei etwa 1/6

}