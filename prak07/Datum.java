class Datum
{
	//Standardwerte sind 0
	private int tag = 0, monat = 0, jahr = 0;

	public Datum(int tag, int monat, int jahr)
	{
		//also brauchen wir nicht auf 0 setzen falls ungültig
		//sondern nur gucken OB gültig, und dann setzen
		if( istDatumGueltig(tag, monat, jahr) )
		{
			this.tag = tag;
			this.monat = monat;
			this.jahr = jahr;
		}
	}

	public int getTag(){ return tag; }
	public int getMonat(){ return monat; }
	public int getJahr(){ return jahr; }

	public String toString()
	{
		return tag + "." + monat + "." + jahr;
	}

	public boolean equals(Datum d)
	{
		return ( this.tag == d.tag ) && ( this.monat == d.monat ) && ( this.jahr == d.jahr );
	}

	public boolean vor( Datum d )
	{
		if( this.jahr < d.jahr )
		{
			return true;
		}
		else if( this.jahr == d.jahr )
		{
			if( this.monat < d.monat )
			{
				return true;
			}
			else if( this.monat == d.monat )
			{
				if(this.tag < d.tag)
				{
					return true;
				}
			}
		}

		//falls keines der if ausgelöst wurde, muss es ja Falsch sein
		return false;
	}

	public static boolean vor( Datum d1, Datum d2 )
	{
		if( d1.jahr < d2.jahr )
		{
			return true;
		}
		else if( d1.jahr == d2.jahr )
		{
			if( d1.monat < d2.monat )
			{
				return true;
			}
			else if( d1.monat == d2.monat )
			{
				if(d1.tag < d2.tag)
				{
					return true;
				}
			}
		}

		//falls keines der if ausgelöst wurde, muss es ja Falsch sein
		return false;
	}

	public static boolean istDatumGueltig(int tag, int monat, int jahr)
	{
		if( jahr < 0 ) return false;	//keine negativen Jahre, I guess?
		if( monat < 1 || monat > 12 ) return false; //gibts auch nicht
		if( tag < 1 || tag > tageImMonat(monat, jahr) ) return false;	//mehr tage als der Monat hat??

		return true;

	}

	//dies ist NICHT die implementierung des Struktogramms online!
	//ich habs public gemacht, damit ichs testen kann
	public static int tageImMonat(int monat, int jahr)
	{
		if(monat < 1 || monat > 12 )
		{
			return 0;	//negative und monate größer 12 gibt es nicht
		}
		else if( monat == 2 )
		{
			if(istSchaltjahr(jahr))
			{
				return 29;	//Februar im Schaltjahr
			}
			return 28;	//Februar normalerweise
		}
		else if( monat < 8 )
		{
			if(monat % 2 == 0)
			{
				return 30;	//April, Juni
			}
			return 31;	//Januar, März, Mai, Juli
		}
		else
		{
			if(monat % 2 == 0)
			{
				return 31;	//August, Oktober, Dezember
			}
			return 30;	//September, November
		}
	}

	//ich habs public gemacht, damit ichs testen kann
	public static boolean istSchaltjahr(int jahr)
	{
		if( jahr % 100 == 0 )
		{
			if( jahr % 400 == 0 )
			{
				return true;
			}
		}
		else if( jahr % 4 == 0 )
		{
			return true;
		}
		
		return false;
	}


	/* ZUSATZAUFGABE FOLGT HIER */
	
	public int tagnummerImJahr()
	{
		int result = 0;

		return 0;
	}

	public int anzahlTageBis(Datum d)
	{
		int result = 0;

		return result;
	}

}
