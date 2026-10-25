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

/**
 * Controla el juego de cartas: guarda las tres pilas (mazo de robo, mazo de
 * descartes y pila de efectos), lee las acciones del fichero CSV y las ejecuta
 * en orden.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (04/10/2026)
 */
public class JuegoDeCartas {

    /**
     * Constructor vacio
     */
    public JuegoDeCartas() {
    }

    private Stack<CARTA> mazoDeRobo; // cartas que se pueden robar
    private Stack<CARTA> mazoDeDescartes; // cartas usadas o descartadas
    private Stack<Efecto> pilaDeEfectos; // efectos pendientes de resolver (carta y jugador)

    /**
     * Crea las tres pilas vacias y llena el mazo de robo con una carta de cada
     * tipo
     */
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
     * Mete en el mazo una carta de cada tipo, en el orden del enumerado CARTA
     *
     * @param mazo mazo de robo que se llena
     */
    public void rellenarMazoRobo(Stack<CARTA> mazo) {
        for (CARTA carta : Constantes.CARTA.values()) {
            System.out.println(carta);
            mazo.push(carta);
        }
    }

    /**
     * Lee las acciones del fichero y las ejecuta una a una, mostrando el
     * resultado de cada una
     */
    public void simulacion() {

        List<Accion> lstAccciones = JuegoDeCartas.leerFicheroAcciones();

        for (Accion accion : lstAccciones) {
            String resultadoAccion = Acciones.ejecutarAcciones(accion, pilaDeEfectos, mazoDeDescartes, mazoDeRobo);
            System.out.println(resultadoAccion);
        }

        System.out.println("FIN DE SIMULACIÓN");
        System.out.println("*************************************************************");
    }

    /**
     * Lee el fichero de acciones. Se salta las de JUGAR o DESCARTAR con una carta
     * que no existe
     *
     * @return lista de acciones validas, vacia si no se encuentra el fichero
     */
    private static List<Accion> leerFicheroAcciones() {
        System.out.println("*************************************************************");
        System.out.println("LEYENDO FICHERO ACCIONES:\n");
        List<Accion> lstAcciones = new ArrayList<>();

        try {
            FicheroSecuencial<Accion> sf = new FicheroSecuencial<Accion>(Constantes.RUTA_FICHERO_ACCIONES,
                    Constantes.SEPARADOR_CSV);
            while (!sf.isEndOfFile()) {
                Accion a = new Accion();
                sf.read(a);

                // Revisamos que las cartas jugadas existan
                if (a.getCarta() != null
                        || (a.getJugada().equalsIgnoreCase("ROBAR") || a.getJugada().equalsIgnoreCase("RESOLVER"))) {
                    System.out.println(a.toString());
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