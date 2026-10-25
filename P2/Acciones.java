package P2;

import java.util.Stack;

import P2.model.Accion;
import P2.model.Efecto;
import P2.util.Constantes.CARTA;

/**
 * Acciones del juego de cartas: jugar, robar, descartar y resolver. Sus metodos
 * modifican las pilas que reciben como parametro.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (04/10/2026)
 */
public class Acciones {

    /**
     * Constructor vacio
     */
    public Acciones() {
    }

    /**
     * Ejecuta una accion del fichero sobre los mazos o la pila de efectos y
     * muestra despues el estado de las tres pilas
     *
     * @param accion          accion a ejecutar (jugador, jugada y carta)
     * @param pilaDeEfectos   pila de efectos pendientes de resolver
     * @param mazoDeDescartes mazo de descartes
     * @param mazoDeRobo      mazo de robo
     * @return mensaje con el resultado de la accion, o cadena vacia
     */
    public static String ejecutarAcciones(Accion accion, Stack<Efecto> pilaDeEfectos, Stack<CARTA> mazoDeDescartes,
            Stack<CARTA> mazoDeRobo) {

        String result = "";

        switch (accion.getJugada()) {
            case "JUGAR":
                jugar(accion, pilaDeEfectos);
                result = accion.getJugador() + " juega: " + accion.getCarta();
                break;

            case "ROBAR":

                CARTA cartaRobada = robar(mazoDeRobo, mazoDeDescartes);

                if (cartaRobada == null) {
                    result = "No hay cartas para robar";
                } else {
                    result = accion.getJugador() + " roba: " + cartaRobada;
                }
                break;
            case "DESCARTAR":
                descartar(accion, mazoDeDescartes);
                System.out.println(accion);

                result = "descartar: " + mazoDeDescartes.peek();
                break;
            case "RESOLVER":
                resolver(pilaDeEfectos, mazoDeDescartes);
                System.out.println(accion);
                break;

            default:
                System.out.println("Accion no implementada. Revisa el fichero de acciones o implementa la accion"
                        + accion.getJugada());
        }

        System.out.println();
        System.out.println("MAZO DE DESCARTES: " + mazoDeDescartes.toString());
        System.out.println("MAZO DE ROBO: " + mazoDeRobo.toString());
        System.out.println("PILA DE EFECTOS: " + pilaDeEfectos.toString());
        System.out.println();
        return result;
    }

    /**
     * Resuelve todos los efectos de la pila, del ultimo jugado al primero:
     * muestra cada uno y pasa su carta al mazo de descartes
     *
     * @param pilaDeEfectos   pila de efectos pendientes de resolver
     * @param mazoDeDescartes mazo donde se dejan las cartas resueltas
     */
    private static void resolver(Stack<Efecto> pilaDeEfectos, Stack<CARTA> mazoDeDescartes) {

        while (pilaDeEfectos.size() != 0) {
            Efecto efecto = pilaDeEfectos.pop();
            System.out.println(efecto);
            mazoDeDescartes.push(efecto.getCarta());
        }

    }

    /**
     * Saca la carta de arriba del mazo de robo. Si esta vacio, antes pasa una a
     * una las cartas del mazo de descartes al de robo
     *
     * @param mazoDeRobo      mazo del que se roba
     * @param mazoDeDescartes mazo que se recicla si el de robo esta vacio
     * @return carta robada, o null si los dos mazos estan vacios
     */
    private static CARTA robar(Stack<CARTA> mazoDeRobo, Stack<CARTA> mazoDeDescartes) {

        // Reciclaje: si el mazo de robo esta vacio, pasamos el descarte al robo
        if (mazoDeRobo.empty() && !mazoDeDescartes.empty()) {
            System.out.print("\nReciclaje: mazo de robo sin cartas, se pasan las cartas del descarte al robo:");
            while (!mazoDeDescartes.empty()) {
                CARTA carta = mazoDeDescartes.pop();
                mazoDeRobo.push(carta);
                System.out.print(" " + carta);
            }
            System.out.println("\n");
        }

        if (mazoDeRobo.empty()) {
            return null;
        }

        return mazoDeRobo.pop();
    }

    /**
     * Crea un efecto con la carta y el jugador de la accion y lo mete en la pila
     * de efectos
     *
     * @param accion        accion JUGAR con el jugador y la carta
     * @param pilaDeEfectos pila donde se mete el efecto
     */
    private static void jugar(Accion accion, Stack<Efecto> pilaDeEfectos) {

        Efecto efecto = new Efecto(accion.getJugador(), accion.getCarta());

        pilaDeEfectos.push(efecto);
    }

    /**
     * Mete la carta de la accion en el mazo de descartes
     *
     * @param accion        accion DESCARTAR con la carta que se descarta
     * @param mazoDescartes mazo de descartes
     */
    private static void descartar(Accion accion, Stack<CARTA> mazoDescartes) {
        mazoDescartes.push(accion.getCarta());
    }
}