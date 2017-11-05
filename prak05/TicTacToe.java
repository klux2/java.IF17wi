class TicTacToe
{

	/*
		Schonmal vorneweg, die Aufgabenstellung des Praktikums enthält ein paar 
		Unlogischkeiten, womit das Spiel nicht richtig funktionieren würde
		bzw. sind manche Dinge nur unzureichend erklärt
	*/

    int spielzuege = 0;         //zu Beginn sind 0 Züge geschehen
    char[] feld = new char[9];  //dieses Array darf höchstens 9 Elemente haben
    final char LEER = '-';      //final => unveränderlich

    public TicTacToe()
    {
        //Arrays beginnen bei 0, deshalb 0-8 anstatt 1-9
        for(int i = 0; i < 9; i++)
        {
            feld[i] = LEER; //feld wird an der Stelle i auf LEER ('-') gesetzt
        }
    }

    public char getFeld(int nummer)
    {
        return feld[nummer];
    }

    public void setFeld(int nummer, char zeichen)
    {
        feld[nummer] = zeichen;
    }

    public boolean istFrei(int nummer)
    {
		//wir müssen testen OB feld == LEER ist
		//zu testen ob es NICHT leer ist ist blödsinn, weil sonst die Abfrage
		//do{}while(!istFrei(eingabe)) keinen Sinn macht!
        return feld[nummer] == LEER;
    }

    public void ausgeben()
    {
		System.out.println( "[" + feld[0] + "] [" + feld[1] + "] [" + feld[2] + "]" );
		System.out.println( "[" + feld[3] + "] [" + feld[4] + "] [" + feld[5] + "]" );
		System.out.println( "[" + feld[6] + "] [" + feld[7] + "] [" + feld[8] + "]" );
    }

    public void initialisiereSpielfeld()
    {
		spielzuege = 0;
		for(int i = 0; i < 9; i++)
        {
            feld[i] = LEER;
        }
    }

    public boolean istGameOver()
    {
		//überprüfe Reihe 1
		if(feld[0]!=LEER && feld[0]==feld[1] && feld[1]==feld[2]) return true;

		//überprüfe Reihe 2
		if(feld[3]!=LEER && feld[3]==feld[4] && feld[4]==feld[5]) return true;

		//überprüfe Reihe 3
		if(feld[6]!=LEER && feld[6]==feld[7] && feld[7]==feld[8]) return true;

		// überprüfe Spalte 1
		if(feld[0]!=LEER && feld[0]==feld[3] && feld[3]==feld[6]) return true;

		// überprüfe Spalte 1
		if(feld[1]!=LEER && feld[1]==feld[4] && feld[4]==feld[7]) return true;

		// überprüfe Spalte 1
		if(feld[2]!=LEER && feld[2]==feld[5] && feld[5]==feld[8]) return true;

		//überprüfe Diagonale 1
		if(feld[0]!=LEER && feld[0]==feld[4] && feld[4]==feld[8]) return true;

		//überprüfe Diagonale 2
		if(feld[2]!=LEER && feld[2]==feld[4] && feld[4]==feld[6]) return true;

		//ansonsten
		return false;

    }

    public void zugSpieler()
    {
		int eingabe = -1;
		spielzuege++;

		//während das Feld der Eingabe des Spielers nicht frei ist, erneut Fragen
		do{
			System.out.print("Wähle ein Feld (1-9): ");
			eingabe = Keyboard.readInt();
		}
		while( !istFrei(eingabe-1) );

		setFeld(eingabe-1, 'X');
		ausgeben();

		//man beachte die weitergabe von "eingabe-1" anstatt "eingabe"
		//das liegt daran, das Arrays mit 0 beginnen, wir den User
		//aber nicht verwirren möchten, unser Feld1 ist PCs Feld0 ;)
    }

    public void zugComputer()
    {
		int eingabe = -1;
		spielzuege++;

		do {
			//zufallszahl zwischen 0-8 (weil arrays bei 0 beginnen)
			eingabe = (int)(Math.random() * 9);
		} 
		while ( !istFrei(eingabe) );

		System.out.println("Computer wählte Feld " + eingabe );

		setFeld(eingabe, 'O');
		ausgeben();
    }

}
