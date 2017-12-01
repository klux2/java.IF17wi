class Datum
{

	/* PRAKTIKUM 8a STARTET ERST UNTEN!! */

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
		if( monat < 0 || monat > 12 ) return false; //gibts auch nicht
		if( tag < 0 || tag > tageImMonat(monat, jahr) ) return false;	//mehr tage als der Monat hat??

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
	/* danke an klux2 auf Github */

	public int tagnummerImJahr()
	{
		int result = tag; //starte mit aktuellem tag.
		int temp_monat = monat - 1; //der wievielte Tag im jetzigen Monat das ist, wissen wir schon! ^oben

		while(temp_monat > 0) //temp monat <= 0 heißt wir sind im Dez. letzten Jahres, also nicht mehr zählen
		{
			result += tageImMonat(temp_monat, jahr);	//addiere Anzahl Tage im Monat
			temp_monat--;	//-- heißt minus 1
		}

		return result;
	}

	public int anzahlTageBis(Datum d)
	{
		int result = d.tagnummerImJahr() - this.tagnummerImJahr(); //wie viele tage zwischen den Daten liegen, wären sie im selben Jahr
		int jahre = d.jahr - this.jahr; //wie viele jahre liegen dazwischen?

		while(jahre > 0) //d liegt in der Zukunft
		{
			result += 365;

			//wenn das Jahr, das wir gerade zählen ein schaltjahr ist, brauchen wir einen extra tag
			if( istSchaltjahr( d.jahr - jahre ) ) 
			{
				result += 1;
			}

			jahre--;
		}

		while(jahre < 0) //d liegt in der Vergangenheit
		{
			result -= 365;

			if( istSchaltjahr( d.jahr + jahre ) )
			{
				result -= 1;
			}

			jahre++;
		}

		return result;
	}

	/* AB HIER FOLGT PRAKTIKUM 8a!!!! */

	public Datum( int[] datumszahlen )
	{
		this.tag = datumszahlen[0];
		this.monat = datumszahlen[1];
		this.jahr = datumszahlen[2];
	}

	public Datum( String s )
	{
		this( zerlegeString(s) );
	}

	public static int[] zerlegeString(String s)
	{
		// würde ich nehmen, aber ich denke, dass ist nicht im Sinn der Aufgabe :)
		// schnellste Variante
		String[] tokens = s.split("\\."); //split will einen RegEx string! (siehe Linux praktika für RegEx)

		// die zweite, explizitere, aber immer noch kurze Variante
		/*
		String[] tokens = new String[3]; //wir brauchen nur 3 Strings "tt", "mm", "jjjj"
		tokens[0] = s.substring( 0, s.indexOf(".") ); //vom ersten zeichen bis zum ersten punkt (exklusive punkt)
		tokens[1] = s.substring( s.indexOf(".")+1, s.lastIndexOf(".")  ); //vom ersten bis letzten Punkt
		tokens[2] = s.substring( s.lastIndexOf(".")+1 ); //vom letzten Punkt bis ende
		*/

		// und einmal komplett manuell :)
		/*
		int i = 0, j = 0;
		String[] tokens = {"", "", ""}; //Array mit 3 leeren Strings
		while(true)	//while true => endlosschleife
		{
			if( s.charAt(j) == '.' )
			{
				i++;	//wenn Punkt, dann ist der token i fertig, also i++ nächster Token
			}
			else
			{
				tokens[i] += s.charAt(j); //Zeichen an dieser stelle dem Token hinzufügen :)
			}

			j++;

			if( j >= s.length() )	//wir haben das ende des Strings erreicht
			{
				break;	//also beenden wir den Loop
			}
		}
		*/

		int[] datum = new int[3];
		datum[0] = Integer.parseInt(tokens[0]);
		datum[1] = Integer.parseInt(tokens[1]);
		datum[2] = Integer.parseInt(tokens[2]);

		return datum;
	}

	public static Datum parseDatum(String s)
	{
		int[] datum = zerlegeString(s);
		return new Datum(datum);
	}

	public static Datum readDatum()
	{
		String s = Keyboard.readString();
		return parseDatum(s);
	}

	//VARIABLE!
	static final String[] monatsnamen = {
		 "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
		 "August", "September", "Oktober", "November", "Dezember" 
	};

	public String toString2()
	{
		//this.monat-1 weil wir ja von 0-11 anstatt 1-12 zählen
		return this.tag + ". " + monatsnamen[this.monat-1] + " " + this.jahr;
	}

	/* AB HIER PRAKTIKUM 8a ZUSATZ! */

	//Die Formel wahrscheinlich von Amis entwickelt, bei denen geht die Woche Sonntags los...
	static final String[] wochentagsnamen = {
		"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"
	};

	//Danke an klux2 
	public int wochentagNr() // siehe https://de.wikipedia.org/wiki/Wochentagsberechnung#Formel fuer Erklaerungen
	{ 
		int m = (monat + 9) % 12 + 1;
		int y = jahr % 1000;
		int c = (jahr - y) / 100;

		if (monat == 1 || monat == 2) 
		{
			y = (y + 99) % 100;
		    c = (jahr - y - 1) / 100;
		}

		//Zahl von 0-6
		return(((int) (tag + (2.6 * m - 0.2) + y + (y / 4) + (c / 4)) - 2 * c) % 7);
	}

	public String toString3()
	{
		//wir zählen, 0-6 nicht 1-7, also -1!
		return wochentagsnamen[wochentagNr()] + ", der " + tag + ". " + monatsnamen[monat-1] + " " + jahr;
	}

}
