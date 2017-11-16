class SummeVon
{
	public static void main(String[] args)
	{
		int summe = 0;

		for(int i = 0; i < args.length; i++)
		{
			summe += Integer.parseInt( args[i] );
		}

		System.out.println( summe );

	}
}