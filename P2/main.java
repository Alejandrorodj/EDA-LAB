package P2;

import java.util.Stack;

public class main {

    private static Stack<String> mazoDeRobo;
    private static Stack<String> mazoDeDescartes;
    private static Stack<String> pilaDeEfectos;

    public static void main(String[] args) {

        mazoDeRobo = new Stack();
        mazoDeDescartes = new Stack();
        pilaDeEfectos = new Stack();

        JuegoDeCartas.inicializar(mazoDeRobo);
        JuegoDeCartas.simulacion();

    }

}
