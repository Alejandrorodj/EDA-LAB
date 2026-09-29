package P2;

import java.util.Stack;

public class main {

    private static Stack<String> mazoDeRobo = new Stack();
    private Stack<String> mazoDeDescartes = new Stack();
    private Stack<String> pilaDeEfectos = new Stack();

    public static void main(String[] args) {

        JuegoDeCartas.inicializar(mazoDeRobo);
        JuegoDeCartas.simulacion();

    }

}
