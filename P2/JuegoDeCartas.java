package P2;

import java.io.FileNotFoundException;
import java.util.Stack;

import P2.Constantes.CARTA;
import P2.file.FicheroSecuencial;

public class JuegoDeCartas {

    public static void inicializar(Stack<String> mazoDeRobo) {

        rellenarMazoRobo(mazoDeRobo);

        try {
            FicheroSecuencial<Accion> sf = new FicheroSecuencial<Accion>(".\\P2\\acciones.csv", ",");
            sf.skip();
            while (!sf.isEndOfFile()) {
                Accion sat = new Accion();
                sf.read(sat);
                System.out.println(sat);
            }
            sf.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

    }

    /**
     * 
     * @param mazo
     */
    public static void rellenarMazoRobo(Stack<String> mazo) {

        for (CARTA carta : Constantes.CARTA.values()) {
            mazo.push(carta.name());
        }
    }

    public static void simulacion() {

    }
}
