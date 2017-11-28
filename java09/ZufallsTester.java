public class ZufallsTester {
    public static void main(String[] args) {
        ZufallszahlenGenerator zg = new ZufallszahlenGenerator(2017128142214L);
        ZufallszahlenGenerator zgr = new ZufallszahlenGenerator();

        for (int i = 0; i < 5; i++) {
            System.out.println("zg.zufallsDouble(): " + zg.zufallsDouble());
            System.out.println("zg.zufallsDouble(" + i + "): " + zg.zufallsDouble((double) i));
            System.out.println("zg.zufallsInt(" + i + "): " + zg.zufallsInt(i));
            System.out.println("zgr.zufallsDouble(): " + zgr.zufallsDouble());
            System.out.println("zgr.zufallsDouble(" + i + "): " + zgr.zufallsDouble((double) i));
            System.out.println("zgr.zufallsInt(" + i + "): " + zgr.zufallsInt(i));
        }
    }
}
