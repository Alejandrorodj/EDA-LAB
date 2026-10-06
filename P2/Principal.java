package P2;

/**
 * Clase principal: punto de entrada de la simulación del juego de cartas.
 *
 * @author LP, AR, VT (código de equipo: TODO)
 * @version 1.0 (04/10/2026)
 */
public class Principal {

    /**
     * Crea el juego, inicializa las pilas y ejecuta la simulación de las acciones
     * del fichero CSV.
     *
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        JuegoDeCartas jc = new JuegoDeCartas();

        // Inicializamos las pilas
        jc.inicializar();
        // Arrancamos la simulación
        jc.simulacion();

    }

}
