import java.util.ArrayList;

public class Stapel
{
	//die <> geben an, welchen Datentyp wir speichern wollen, hier die Klasse "Object"
	private ArrayList<Object> stapelobjekte;

	public Stapel()
	{
		//neues Objekt vom Typ "ArrayList<Object>" erstellen
		// die () sind wichtig, damit wird der Konstruktor aufgerufen
		stapelobjekte = new ArrayList<Object>();
	}

	public void push(Object o)
	{
		//.add() fügt ans ende hinzu
		stapelobjekte.add(o);
	}

	public Object pop()
	{
		//falls der Stapel leer ist, sollen wir null wiedergeben, also: 
		if(stapelobjekte.isEmpty())
			return null;

		//ansonsten entfernen wir und geben das object zurück, das entfert wurde
		//zum Glück macht .remove() das für uns, also nur noch return davor schreiben
		return stapelobjekte.remove( stapelobjekte.size()-1 );
	}

	public boolean isEmpty()
	{
		//oh, wie schön, so eine Funktion gibt es schon :)
		return stapelobjekte.isEmpty();
	}

	public String toString()
	{
		String s = "[";

		//durch alle durchzählen
		for(int i = 0; i < stapelobjekte.size(); i++)
		{
			//füge das Objekt als String an.
			s += stapelobjekte.get(i).toString();

			//falls dieses Object NICHT das letzte ist, füge ein Komma an
			if(i+1 < stapelobjekte.size())
				s += ", ";
		}

		s += "]";

		return s;
	}

	public boolean equals(Stapel s)
	{		
		//falls sie die gleichen strings haben, müssen sie gleich sein
		//auf jeden fall .equals() verwenden!
		// == prüft ob es das selbe objekt (im Speicher) ist ; logischerweise ist es das nicht
		return this.toString().equals(s.toString());
	}

}