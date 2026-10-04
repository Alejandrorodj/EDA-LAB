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
     * 
     * @param accion
     * @param pilaDeEfectos
     * @param mazoDeDescartes
     * @param mazoDeRobo
     * @return
     */
    public static String ejecutarAcciones(Accion accion, Stack<Efecto> pilaDeEfectos, Stack<CARTA> mazoDeDescartes,
            Stack<CARTA> mazoDeRobo) {

        switch (accion.getJugada()) {
            case "JUGAR":

                jugar(accion, pilaDeEfectos);

                return accion.getJugador() + " juega " + accion.getCarta();
            case "ROBAR":
                
                CARTA cartaRobada = robar(mazoDeRobo, mazoDeDescartes);

                if (cartaRobada == null) {
                    return "No hay cartas para robar";
                }

                return accion.getJugador() + " roba: " + cartaRobada;
            case "DESCARTAR":
                descartar(accion, mazoDeDescartes);
                System.out.println(accion);

                return "descartar: " + mazoDeDescartes.peek();
            case "RESOLVER":
                resolver(pilaDeEfectos);
                System.out.println(accion);
                break;

            default:
                System.out.println("Accion no implementada. Revisa el fichero de acciones o implementa la accion"
                        + accion.getJugada());
        }

        return "";
    }

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

    private static void jugar(Accion accion, Stack<Efecto> pilaDeEfectos) {

        Efecto efecto = new Efecto(accion.getJugador(), accion.getCarta());

        pilaDeEfectos.push(efecto);
    }

    /**
     * 
     * @param accion
     * @param mazoDescartes
     */
    private static void descartar(Accion accion, Stack<CARTA> mazoDescartes) {
        mazoDescartes.push(accion.getCarta());
    }

}
