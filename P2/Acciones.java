package P2;

import java.util.Stack;

import P2.model.Accion;
import P2.model.Efecto;
import P2.util.Constantes.CARTA;

/**
 * Acciones del juego de cartas: jugar, robar, descartar y resolver.
 * Contiene métodos estáticos que modifican las pilas que reciben como parámetro.
 *
 * @author LP, AR, VT (código de equipo: TODO)
 * @version 1.0 (04/10/2026)
 */
public class Acciones {

    /**
     * Ejecuta una acción leída del fichero sobre los mazos o la pila de efectos y
     * muestra después el estado de las tres pilas.
     *
     * @param accion acción a ejecutar (jugador, jugada y carta)
     * @param pilaDeEfectos pila de efectos pendientes de resolver
     * @param mazoDeDescartes mazo de descartes
     * @param mazoDeRobo mazo de robo
     * @return mensaje que describe el resultado de la acción, o cadena vacía
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
     * Resuelve todos los efectos de la pila, del último jugado al primero: muestra
     * la carta y el jugador de cada uno y mueve la carta al mazo de descartes.
     *
     * @param pilaDeEfectos pila de efectos pendientes de resolver
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
     * Extrae la carta superior del mazo de robo. Si el mazo de robo está vacío,
     * pasa antes todas las cartas del mazo de descartes al de robo, una a una, y
     * muestra las cartas recicladas.
     *
     * @param mazoDeRobo mazo del que se roba
     * @param mazoDeDescartes mazo de descartes que se recicla si el de robo está vacío
     * @return la carta robada, o {@code null} si los dos mazos están vacíos
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
     * Crea un {@link Efecto} con la carta y el jugador de la acción y lo apila en la
     * pila de efectos.
     *
     * @param accion acción {@code JUGAR} con el jugador y la carta
     * @param pilaDeEfectos pila donde se apila el efecto
     */
    private static void jugar(Accion accion, Stack<Efecto> pilaDeEfectos) {

        Efecto efecto = new Efecto(accion.getJugador(), accion.getCarta());

        pilaDeEfectos.push(efecto);
    }

    /**
     * Añade la carta de la acción al mazo de descartes.
     *
     * @param accion acción {@code DESCARTAR} con la carta que se descarta
     * @param mazoDescartes mazo de descartes
     */
    private static void descartar(Accion accion, Stack<CARTA> mazoDescartes) {
        mazoDescartes.push(accion.getCarta());
    }
}
