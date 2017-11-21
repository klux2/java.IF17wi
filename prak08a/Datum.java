public class Datum {
        private int tag, monat, jahr;

        /**
         * Pr&uuml;fender Konstruktor.
         * Weist den Variablen die Argumente zu, testet allerdings vorher auf G&uuml;ltigkeit der Werte.
         *
         * @param tag   Tag
         * @param monat Monat
         * @param jahr  Jahr
         */

        public Datum(int tag, int monat, int jahr) {
                if (istDatumGueltig(tag, monat, jahr)) {                        // prueft, ob das angegebene Datum gueltig ist
                        this.tag = tag;
                        this.monat = monat;
                        this.jahr = jahr;
                } else {
                        System.out.println("[Datum] Fehler: Datum ungueltig!");
                        this.tag = 0;
                        this.monat = 0;
                        this.jahr = 0;
                }
        }

        /**
         * Nimmt das Datum als int-Array entgegen, &uuml;bergibt es an den <em>{@link #Datum(int, int, int) Standard-Konstruktor}</em>.
         * Siehe dazu beispielsweise <em><a href="http://openbook.rheinwerk-verlag.de/javainsel/javainsel_05_005.html#dodtp3231b346-a3b5-483d-bbcd-dd84a6afe699">"Java ist auch eine Insel"</a></em>.
         *
         * @param datumszahlen  Datum als int[]
         */

        public Datum(int[] datumszahlen) {
                this(datumszahlen[0], datumszahlen[1], datumszahlen[2]);
        }

        /**
         * Nimmt das Datum als String entgegen, und &uuml;bergibt es an den <em>{@link #Datum(int[]) int[]-Konstruktor}</em>.
         * Dazu wird der String &uuml;ber die Klassenmethode <em>{@link #zerlegeString(String) zerlegeString()}</em> in ein Array umgewandelt.
         * Achtung! Der String wird nicht auf Fehler &uuml;berpr&uuml;ft. Ein falscher String f&uuml;hrt vermutlich zu einer
         * <a href="https://docs.oracle.com/javase/9/docs/api/java/lang/ArrayIndexOutOfBoundsException.html">ArrayIndexOutOfBoundsException</a> im <em>{@link #Datum(int[]) int[]-Konstruktor}</em>!
         *
         * @param s Datum als String
         */

        public Datum(String s) {
                this(zerlegeString(s));
        }

        /**
         * Getter-Methode f&uuml;r den Tag.
         *
         * @return Tag
         */

        public int getTag() {
                return tag;
        }

        /**
         * Getter-Methode f&uuml;r den Monat.
         *
         * @return  Monat
         */

        public int getMonat() {
                return monat;
        }

        /**
         * Getter-Methode f&uuml;r das Jahr.
         *
         * @return Jahr
         */

        public int getJahr() {
                return jahr;
        }

        /**
         * Gibt das Datum als String im Format "JJJJ-MM-TT" nach ISO 8601 zur&uuml;ck.
         *
         * @return Datum
         */

        public String toString() {
                String tmp_t = String.valueOf(tag), tmp_m = String.valueOf(monat), tmp_j = String.valueOf(jahr);

                while (tmp_t.length() < 2) {                                    // fuellt jeweils mit Nullen auf
                        tmp_t = "0" + tmp_t;
                }
                while (tmp_m.length() < 2) {
                        tmp_m = "0" + tmp_m;
                }
                while (tmp_j.length() < 4) {
                        tmp_j = "0" + tmp_j;
                }

                return (tmp_j + "-" + tmp_m + "-" + tmp_t);
        }

        /**
         * Gibt das Datum als String im Format "TT&#x2e; Monat JJJJ" zur&uuml;ck.
         *
         * @return Datum
         */

        public String toShortString() {
                if (monat == 0) {
                        System.out.println("[toShortString] Fehler: Monat ist 0!");
                        return null;                                            // gibt nichts zurueck, wenn der Monat 0 ist, da das einen Fehler geben wuerde
                }
                String[] monate = {"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};

                String tmp_t = String.valueOf(tag), tmp_j = String.valueOf(jahr);

                while (tmp_t.length() < 2) {                                    // mit Nullen auffuellen
                        tmp_t = "0" + tmp_t;
                }
                while (tmp_j.length() < 4) {
                        tmp_j = "0" + tmp_j;
                }

                return (tmp_t + ". " + monate[monat - 1] + " " + tmp_j);
        }

        /**
         * Gibt das Datum als String im Format "Wochentag, der TT&#x2e; Monat JJJJ" zur&uuml;ck.
         * Daf&uuml;r wird die <em>{@link #wochentagNr() wochentagNr()-Methode}</em> benutzt.
         *
         * @return Datum
         */

        public String toLongString() {
                if (tag == 0 || monat == 0) {
                        System.out.println("[toLongString] Fehler: Tag oder Monat ist 0!");
                        return null;
                }
                String[] wochentage = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};

                return (wochentage[(wochentagNr() + 6) % 7] + ", der " + toShortString());


                // Langform:
                /*
                int wtNr = wochentagNr();                                       // Sonntag ist 0, Montag 1, daher -1
                wtNr = wtNr - 1;                                                // darf nicht kleiner als 0 sein
                if (wtNr < 0) {
                    wtNr = wtNr + 7;
                }
                return (wochentage[wtNr] + ", der " + toShortString());         // An den Wochentag wird die kurze Ausgabe angehaengt
                */
        }

        /**
         * Gibt zur&uuml;ck, ob das Datum dem Vergleichsdatum <em>d</em> entspricht.
         *
         * @param d   Vergleichsdatum
         * @return    Gleichheit der Daten
         */

        public boolean equals(Datum d) {
                if (this.jahr == d.getJahr() && this.monat == d.getMonat() && this.tag == d.getTag()) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * Gibt zur&uuml;ck, ob das Datum vor dem Vergleichsdatum <em>d</em> liegt.
         *
         * @param d   Vergleichsdatum
         * @return    d nach dem Datum
         */

        public boolean vor(Datum d) {
                if (this.jahr < d.getJahr() || (this.jahr == d.getJahr() && this.monat < d.getMonat()) || (this.jahr == d.getJahr() && this.monat == d.getMonat() && this.tag < d.getTag())) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * Klassenmethode, die zur&uuml;ck gibt, ob das Datum <em>d1</em> vor dem Vergleichsdatum <em>d2</em> liegt.
         *
         * @param d1    Datum
         * @param d2    Vergleichsdatum
         * @return      d nach dem Datum
         */

        public static boolean vor(Datum d1, Datum d2) {
                if (d1.getJahr() < d2.getJahr() || (d1.getJahr() == d2.getJahr() && d1.getMonat() < d2.getMonat()) || (d1.getJahr() == d2.getJahr() && d1.getMonat() == d2.getMonat() && d1.getTag() < d2.getTag())) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * Klassenmethode, die pr&uuml;ft, ob es sich bei einem Jahr jahr um ein Schaltjahr handelt.
         *
         * @param jahr  zu &uuml;berpr&uuml;fendes Jahr
         * @return      Schaltjahr
         */

        private static boolean istSchaltjahr(int jahr) {
                if (jahr % 100 == 0) {
                        if (jahr % 400 == 0) {
                                return true;
                        } else {
                                return false;
                        }
                } else {
                        if (jahr % 4 == 0) {
                                return true;
                        } else {
                                return false;
                        }
                }
        }

        /**
         * Klassenmethode, die die Anzahl der Tage im Monat <em>monat</em> im Jahr <em>jahr</em> zur&uuml;ckgibt.
         *
         * @param monat zu &uuml;berpr&uuml;fender Monat
         * @param jahr  zu &uuml;berpr&uuml;fendes Jahr
         * @return      Anzahl der Tag
         */

        private static int anzahlTageImMonat(int monat, int jahr) {
                if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
                        return 31;
                } else {
                        if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
                                return 30;
                        } else {
                                if (monat == 2) {
                                        if (istSchaltjahr(jahr)) {
                                                return 29;
                                        } else {
                                                return 28;
                                        }
                                } else {
                                        System.out.println("[anzahlTageImMonat] Fehler: Monat <1 oder >12!");
                                        return 0;
                                }
                        }
                }
        }

        /**
         * Klassenmethode, die die G&uuml;ltigkeit eines Datums pr&uuml;ft.
         *
         * @param tag   Tag
         * @param monat Monat
         * @param jahr  Jahr
         *
         * @return      G&uuml;ltigkeit
         */

        public static boolean istDatumGueltig(int tag, int monat, int jahr) {
                if (tag > 31 || tag < 1 || monat > 12 || monat < 1 || tag > anzahlTageImMonat(monat, jahr)) {
                        return false;
                } else {
                        return true;
                }
        }

        /**
         * Gibt die Nummer des Tages im Jahr zur&uuml;ck (der wievielte Tag es ist).
         *
         * @return  Tag
         */

        public int tagnummerImJahr() {
                int nr = tag;                                                   // Beginn mit aktuellem Datum (Tag)
                int tmp_m = monat - 1;                                          // der aktuelle Monat ist uninteressant
                while (tmp_m > 0) {                                             // es gibt keinen Monat vor Januar (<1)
                        nr += anzahlTageImMonat(tmp_m, jahr);                   // fuer jeden Monat wird die Anzahl der Tage addiert ...
                        tmp_m--;                                                // ... und der Monat wird runtergezaehlt
                }
                return nr;
        }

        /**
         * Gibt die Differenz in Tagen zwischen diesem Datum und dem Datum <em>d</em> zur&uuml;ck.
         *
         * @param d    End-Datum
         * @return     Zeitspanne in Tagen
         */

        public int anzahlTageBis(Datum d) {
                int dif = d.tagnummerImJahr() - this.tagnummerImJahr();
                int tmp_j = d.getJahr() - this.jahr;
                while (tmp_j > 0) {
                        dif += 365 + (istSchaltjahr(jahr) ? 1 : 0);             // Kurzschreibweise: (Bedingung ? dann : sonst)

                        // Langform:
                        /*
                        dif = dif + 365
                        if (istSchaltjahr(jahr)) {
                            dif = dif + 1;
                        }
                        */

                        tmp_j--;
                }
                while (tmp_j < 0) {
                        dif -= 365 + (istSchaltjahr(jahr) ? 1 : 0);
                        tmp_j++;
                }
                return dif;
        }

        /**
         * Berechnet den Wochentag und gibt ihn zur&uuml;ck, wobei die Z&auml;hlung von 0 (So) bis 6 (Sa) geht.
         * F&uuml;r die Berechnung wird der <em><a href="https://de.wikipedia.org/wiki/Wochentagsberechnung#Formel">Algorithmus</a></em> von Georg Glaeser benutzt.
         *
         * @return Wochentag von Sonntag (0) bis Samstag (6)
         */

        public int wochentagNr() {                                              // siehe https://de.wikipedia.org/wiki/Wochentagsberechnung#Formel fuer Erklaerungen
                int m = (monat + 9) % 12 + 1, y = jahr % 1000, c = (jahr - y) / 100;
                if (monat == 1 || monat == 2) {
                        y = (y + 99) % 100;
                        c = (jahr - y - 1) / 100;
                }
                return(((int) (tag + (2.6 * m - 0.2) + y + (y / 4) + (c / 4)) - 2 * c) % 7);
        }

        /**
         * Klassenmethode, die einen String <em>s</em> im Format "DD&#x2e;MM&#x2e;YYYY" in ein Datum zerlegt.
         * Dieses wird als int-Array zur&uuml;ckgegeben.
         *
         * @param s Datum als String
         * @return  Datum als int[]
         */

        public static int[] zerlegeString(String s) {
                int trenner1 = s.indexOf("."), trenner2 = s.lastIndexOf(".");
                if (trenner1 == trenner2) {                                     // Nur ein Punkt im String
                        return null;                                            // Gib nichts zurueck
                }
                int[] datum = new int[3];                                        // Neues Array mit Groesse Drei anlegen
                try {                                                           // Versuche folgendes ...
                        datum[0] = Integer.parseInt(s.substring(0, trenner1));              // Anfang bis zum ersten Punkt
                        datum[1] = Integer.parseInt(s.substring(trenner1 + 1, trenner2));   // Erster Punkt bis zweiter Punkt
                        datum[2] = Integer.parseInt(s.substring(trenner2 + 1));             // Zweiter Punkt bis Ende
                } catch (NumberFormatException e) {                             // ... und falls dabei ein Fehler auftritt, tue das
                        System.out.println("[zerlegeString] Fehler: keine Zahl eingegeben!");
                        e.printStackTrace();                                    // Gib den Fehler aus
                        return null;                                            // Gib nichts zurueck
                }
                return datum;                                                   // Gib das Array zurueck
        }

        /**
         * Klassenmethode, die ein neues Datum-Objekt erstellt.
         * Der String wird als Parameter an den entprechenden <em>{@link #Datum(int[]) Konstruktor}</em> &uuml;bergeben.
         *
         * @param s Datum als String
         * @return  Datum als Datum-Objekt
         */

        public static Datum parseDatum(String s) {
                return new Datum(s);
        }

        /**
         * Klassenmethode, die eine neues Datum-Objekt erstellt.
         * Es wird so lange ein String eingelesen und der <em>{@link #zerlegeString(String) zerlegeString()-Methode}</em>  &uuml;bergeben, bis diese ein nichtleeres Array zur&uuml;ckgibt.
         *
         * @return  neues Datum-Objekt
         */

        public static Datum readDatum() {
                int[] datum = zerlegeString(Keyboard.readString());
                while (datum == null) {
                        System.out.println("[readDatum] Fehler: falsche Eingabe!");
                        datum = zerlegeString(Keyboard.readString());
                }
                return new Datum(datum);
        }
}
