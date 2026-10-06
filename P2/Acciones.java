/****
*
* Class Name: Acciones
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase que contiene los métodos estáticos para gestionar y ejecutar
*                    las distintas acciones del juego (jugar, robar, descartar y resolver efectos).
*
*/

package P2;

import java.util.Stack;

import P2.model.Accion;
import P2.model.Efecto;
import P2.util.Constantes.CARTA;

/**
 * 
 * Acciones
 */
public class Acciones {

    /**
     * Method name: ejecutarAcciones
     *
     * Description of the Method: Evalúa la jugada contenida en el objeto Accion y
     * ejecuta la lógica
     * correspondiente sobre los mazos o la pila de efectos.
     * Calling arguments:
     * - Accion accion: Objeto de tipo Accion con la jugada a procesar.
     * - Stack<Efecto> pilaDeEfectos: Pila donde se apilan los efectos generados al
     * jugar cartas.
     * - Stack<CARTA> mazoDeDescartes: Pila que representa el mazo de descartes.
     * - Stack<CARTA> mazoDeRobo: Pila que representa el mazo principal para robar
     * cartas.
     *
     * Return value: String - Mensaje descriptivo del resultado de la acción
     * ejecutada.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/

    /**
     * 
     * @param accion
     * @param pilaDeEfectos
     * @param mazoDeDescartes
     * @param mazoDeRobo
     * @return
     */
    public static String ejecutarAcciones(Accion accion, Stack<Efecto> pilaDeEfectos, Stack<CARTA> mazoDeDescartes,
            Stack<CARTA> mazoDeRobo) {
        String result = "";
        switch (accion.getJugada()) {
            case "JUGAR":

                jugar(accion, pilaDeEfectos);

                result = accion.getJugador() + " juega " + accion.getCarta();
                break;
            case "ROBAR":

                CARTA cartaRobada = robar(mazoDeRobo, mazoDeDescartes);

                if (cartaRobada == null) {
                    result = "No hay cartas para robar";
                }

                result = accion.getJugador() + " roba: " + cartaRobada;
                break;
            case "DESCARTAR":
                descartar(accion, mazoDeDescartes);
                System.out.println(accion);

                result = "descartar: " + mazoDeDescartes.peek();
                break;
            case "RESOLVER":
                resolver(pilaDeEfectos);
                System.out.println(accion);
                break;

            default:
                System.out.println("Accion no implementada. Revisa el fichero de acciones o implementa la accion"
                        + accion.getJugada());
        }

        return result;
    }

    /**
     * Method name: resolver
     *
     * Description of the Method: Vacía la pila de efectos desapilándolos de uno en
     * uno
     * e imprimiendo su contenido por la consola.
     * Calling arguments:
     * - Stack<Efecto> pilaDeEfectos: Pila que contiene los efectos pendientes de
     * resolver.
     *
     * Return value: void.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/

    /**
     * 
     * @param pilaDeEfectos
     * @return
     */
    private static void resolver(Stack<Efecto> pilaDeEfectos) {

        while (pilaDeEfectos.size() != 0) {
            System.out.println(pilaDeEfectos.pop());
        }

    }

    /**
     * Method name: robar
     *
     * Description of the Method: Extrae la carta superior del mazo de robo. Si el
     * mazo está vacío,
     * pasa todas las cartas del mazo de descartes al de robo antes de extraerla.
     * Calling arguments:
     * - Stack<CARTA> mazoDeRobo: Pila con las cartas disponibles para robar.
     * - Stack<CARTA> mazoDeDescartes: Pila con las cartas descartadas previamente.
     *
     * Return value: CARTA - La carta extraída o null si no hay cartas disponibles
     * en ningún mazo.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/
    private static CARTA robar(Stack<CARTA> mazoDeRobo, Stack<CARTA> mazoDeDescartes) {

        if (mazoDeRobo.empty()) {
            while (!mazoDeDescartes.empty()) {
                mazoDeRobo.push(mazoDeDescartes.pop());
            }
        }

        if (mazoDeRobo.empty()) {
            return null;
        }

        return mazoDeRobo.pop();
    }

    /**
     * Method name: jugar
     *
     * Description of the Method: Genera un nuevo objeto Efecto a partir de la
     * acción indicada
     * y lo apila en la pila de efectos.
     * Calling arguments:
     * - Accion accion: La acción jugada que genera el efecto.
     * - Stack<Efecto> pilaDeEfectos: Pila donde se almacena el nuevo efecto.
     *
     * Return value: void.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/
    private static void jugar(Accion accion, Stack<Efecto> pilaDeEfectos) {

        Efecto efecto = new Efecto(accion.getJugador(), accion.getCarta());

        pilaDeEfectos.push(efecto);
    }

    /**
     * Method name: descartar
     *
     * Description of the Method: Agrega la carta de la acción indicada al mazo de
     * descartes.
     * Calling arguments:
     * - Accion accion: La acción que contiene la carta a descartar.
     * - Stack<CARTA> mazoDescartes: Pila donde se apilará la carta descartada.
     *
     * Return value: void.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/

    /**
     * 
     * @param accion
     * @param mazoDescartes
     */
    private static void descartar(Accion accion, Stack<CARTA> mazoDescartes) {
        mazoDescartes.push(accion.getCarta());
    }

}
