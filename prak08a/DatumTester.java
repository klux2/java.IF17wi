public class DatumTester {
        public static void main(String[] args) {
                Datum d1 = new Datum(21, 11, 2017);
                Datum d2 = new Datum(12, 1, 2006);
                Datum d3 = new Datum(1, 1, 2000);
                System.out.print("Bitte Datum eingeben: ");
                Datum d4 = Datum.readDatum();
                Datum d5 = Datum.parseDatum("21.11.2017");

                System.out.println("d1:\t\t\t\t" + d1.toLongString());
                System.out.println("d2:\t\t\t\t" + d2.toLongString());
                System.out.println("d3:\t\t\t\t" + d3.toLongString());
                System.out.println("d4:\t\t\t\t" + d4.toLongString());
                System.out.println("d5:\t\t\t\t" + d5.toLongString());
                System.out.println("d1.equals(d5):\t\t\t" + d1.equals(d5));
                System.out.println("d2.tagnummerImJahr():\t\t" + d2.tagnummerImJahr());
                System.out.println("d1.anzahlTageBis(d4):\t\t" + d1.anzahlTageBis(d4));
                System.out.println("d1.vor(d4):\t\t\t" + d1.vor(d4));
                System.out.println("Datum.vor(d3, d2):\t\t" + Datum.vor(d3, d2));
        }
}
