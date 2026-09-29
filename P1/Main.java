package P1;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            FicheroSecuencial<Satelite> sf = new FicheroSecuencial<Satelite>(".\\P1\\weather.csv", ",");
            sf.skip();
            while (!sf.isEndOfFile()) {
                Satelite sat = new Satelite();
                sf.read(sat);
                if (sat.getNumOrbitas() > 10) {
                    System.out.println(sat);
                }
            }
            sf.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }
}
