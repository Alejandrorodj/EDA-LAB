package P2;

/**
 * Clase principal: punto de entrada de la simulación del juego de cartas.
 *
 * @author LP, AR, VT
 * @version 1.0 (04/10/2026)
 */
public class Principal {

    /** Crea una instancia de Principal. */
    public Principal() {
    }

    /**
     * Crea el juego, inicializa las pilas y ejecuta la simulación de las acciones
     * del fichero CSV.
     */
    public static void main(String[] args) {

        JuegoDeCartas jc = new JuegoDeCartas();
        jc.inicializar();
        jc.simulacion();

    }

}
