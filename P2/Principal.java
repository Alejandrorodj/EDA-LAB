package P2;

/**
 * Programa principal de la simulacion del juego de cartas.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (04/10/2026)
 */
public class Principal {

    /**
     * Constructor vacio
     */
    public Principal() {
    }

    /**
     * Programa principal: crea el juego, inicializa las pilas y ejecuta las
     * acciones del fichero CSV
     *
     * @param args argumentos (no se usan)
     */
    public static void main(String[] args) {

        JuegoDeCartas jc = new JuegoDeCartas();
        jc.inicializar();
        jc.simulacion();

    }

}