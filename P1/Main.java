package P1;

import java.io.FileNotFoundException;

/**
 * Programa principal: lee los satelites del fichero y muestra los que dan mas
 * de 10 orbitas al dia.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (22/09/2026)
 */
public class Main {

    /**
     * Lee el fichero de satelites, salta la cabecera y muestra los que tienen mas
     * de 10 orbitas
     *
     * @param args argumentos (no se usan)
     */
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
