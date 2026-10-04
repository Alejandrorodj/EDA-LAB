package P2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import P2.model.Accion;
import P2.model.Efecto;
import P2.util.Constantes;
import P2.util.Constantes.CARTA;
import P2.util.file.FicheroSecuencial;

public class JuegoDeCartas {

    private Stack<CARTA> mazoDeRobo;
    private Stack<CARTA> mazoDeDescartes;
    private Stack<Efecto> pilaDeEfectos;

    public void inicializar() {
        System.out.println("*************************************************************");
        System.out.println("INICIALIZANDO DATOS:\n");
        // Inicializamos las pilas
        mazoDeRobo = new Stack<CARTA>();
        mazoDeDescartes = new Stack<CARTA>();
        pilaDeEfectos = new Stack<Efecto>();
        // Rellenamos el mazo de robo
        rellenarMazoRobo(mazoDeRobo);
        System.out.println("*************************************************************");

    }

    /**
     * 
     * @param mazo
     */
    public void rellenarMazoRobo(Stack<CARTA> mazo) {
        for (CARTA carta : Constantes.CARTA.values()) {
            System.out.println(carta);
            mazo.push(carta);
        }
    }

    /**
     * 
     * @param pilaDeEfectos
     * @param mazoDeDescartes
     * @param mazoDeRobo
     */
    public void simulacion() {

        List<Accion> lstAccciones = JuegoDeCartas.leerFicheroAcciones();

        for (Accion accion : lstAccciones) {
            String resultadoAccion = Acciones.ejecutarAcciones(accion, pilaDeEfectos, mazoDeDescartes, mazoDeRobo);
            System.out.println(resultadoAccion);
            System.out.println("");
        }
    }

    /**
     * 
     * @return
     */
    private static List<Accion> leerFicheroAcciones() {
        System.out.println("*************************************************************");
        System.out.println("LEYENDO FIHCERO ACCIONES:\n");
        List<Accion> lstAcciones = new ArrayList<>();

        try {
            FicheroSecuencial<Accion> sf = new FicheroSecuencial<Accion>(Constantes.RUTA_FICHERO_ACCIONES,
                    Constantes.SEPARADOR_CSV);
            while (!sf.isEndOfFile()) {
                Accion a = new Accion();
                sf.read(a);

                // Revisamos que las cartas jugadas existan
                if (a.getCarta() != null
                        || (a.getJugada().equalsIgnoreCase("ROBAR") || a.getJugada().equalsIgnoreCase("DESCARTAR"))) {
                    System.out.println(a);
                    lstAcciones.add(a);
                }

            }
            sf.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuntra el fichero, revisa la ruta");
        }
        System.out.println("*************************************************************");
        return lstAcciones;
    }
}
