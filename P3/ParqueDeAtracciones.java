package P3;

/**
 * Contiene el punto de entrada del programa y permite iniciar
 * la simulacion de la atraccion.
 *
 * @author LP, AR, VT
 * @version 1.0 (19/10/2026)
 */
public class ParqueDeAtracciones {

     /**
     * Crea la simulacion e inicia su ejecucion.
     *
     * @param args argumentos recibidos desde la linea de comandos
     */
    public static void main(String[] args) {

        Simulacion s = new Simulacion();
        s.iniciarSimulacion();

    }

}