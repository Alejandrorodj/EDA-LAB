package P2;

import java.util.Stack;

import P2.model.Accion;

public class Acciones {

    public static String robar(Accion accion, Stack<String> mazoDeRobo, Stack<String> mazoDeDescartes) {
        if (mazoDeRobo.empty()) {
            while (!mazoDeDescartes.empty()) {
                mazoDeRobo.push(mazoDeDescartes.pop());
            }
        }

        if (mazoDeRobo.empty()) {
            System.out.println("Está vacío");
        } else {
            Carta carta = mazoDeRobo.pop();
            System.out.println(accion.getJugador() + " roba " + carta);
        }
    }

    public static String jugar(Accion accion, Stack<Accion> pilaEfectos) {
        pilaEfectos.push(accion);
    }

    public static String descartar() {
        return "";
    }

    public static String resolver() {
        return "";
    }
}
