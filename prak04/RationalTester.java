public class RationalTester
{
	public static void main(String[] args)
	{
		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(2,4);
		Rational r3 = new Rational();

		System.out.println(r1.getZaehler());
		System.out.println("-");
		System.out.println(r1.getNenner());
		System.out.println("=");
		System.out.println(r1.doubleValue());
		System.out.println("<=>");
		System.out.println( r2.toString() );

		if( r1.equals(r2) )
		{
			System.out.println("r1 == r2");
		}
		else
		{
			System.out.println("r1 != r2");
		}

		System.out.println( "r1+r2= " + r1.plus(r2) );
		System.out.println( "r1-r2= " + r1.minus(r2) );
		System.out.println( "r1*r2= " + r1.mal(r2) );
		System.out.println( "r1/r2= " + r1.durch(r2) );

		if( Rational.durch(r1,r2).equals(Rational.EINS) )
		{
			System.out.println("R1/R2 = 1");
		}
		if( Rational.minus(r1,r2).equals(Rational.NULL) )
		{
			System.out.println("R1-R2 = 0");
		}
	}
}