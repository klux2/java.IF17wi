public class HelloKeyboard
{
	/*
		Dieses Programm gitb einen vom Nutzer eingegebenen Text aus
		Beim Aufrufen des Programms bitte Klassenname beachten!!!
	*/
	public static void main(String[] args)
	{
		System.out.print("Eingabe: ");	//print ohne Zeilenumbruch
		String s = Keyboard.readString();
		System.out.println( s ); //println mit Zeilenumbruch
	}
}
