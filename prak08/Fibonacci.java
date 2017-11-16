class Fibonacci
{

	//static nötig, weil wir nur statische methoden haben
	static long[] fib = new long[100];

	public static void main(String[] args)
	{
		for( int i = 0; i < 100; i++ )
		{
			fib[i] = fibonacci(i);
			System.out.println( fib[i] );
		}

	}

	private static long fibonacci(int n)
	{
		if( n == 1 || n == 2 ) return 1L;
		else if( n >= 3 )
		{
			//return fibonacci(n-1) + fibonacci(n-2);
			//wie geht es effizienter? nunja, hier könnten wir einfach auf die gespeicherten Werte in fib[] zugreifen
			//anstatt jedesmal ALLES BIS ZU N neu zu berechnen!
			return fib[n-1] + fib[n-2];
		}
		return 0L;	//sollte nie passieren
	}

	//bei n > 90 bekommen wir negative Zahlen zurückgegeben
	//dieses Problem nennt sich "Integer Overflow"
	//ein int (oder bei uns eben long) wird ja als binäre Zahl gespeichert
	// 0000 0101 = 5 ; dabei wird das allererste Bit als VORZEICHEN verwendet
	// 1000 0101 = -5 ; (<- das ist nicht ganz richtig, reicht aber zur Erklärung (-5 ist eigentlich 1111 1011 ))
	//wenn jetzt 2 Integer addiert werden, ist es möglich das das Vorzeichen verändert wird, da der PC nicht weiß,
	//dass es ein Vorzeichen ist, das wird lediglich so interpretiert
	//0111 1111 + 0000 0011 = 1000 0010 = -2 anstatt 130

}