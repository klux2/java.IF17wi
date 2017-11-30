public class Zufall
{
	long value = 0;

	static long a = 3421; //oder 9301 oder 25214903917L
	static long c = 1; //oder 49297 oder 11
	static long m = 65536; //oder 233280 oder 281474976710655L

	public Zufall(long start)
	{
		value = start;
	}

	public Zufall()
	{
		value = System.currentTimeMillis();
	}

	public double zufallsDouble()
	{
		value = ( value * a + c ) % m;

		//hier nach double casten, weil long/long eine long (lange GANZZAHL) ergibt!
		return (double)value / (double)m;
	}

	public double zufallsDouble(double max)
	{
		return zufallsDouble() * max;
	}

	public int zufallsInt(int max)
	{
		return (int)(zufallsDouble()*max);
	}

	public String toString()
	{
		return "";
	}

}