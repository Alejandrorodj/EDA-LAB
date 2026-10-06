/****
*
* Class Name: Main
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase principal que contiene el punto de entrada de la aplicación.
*                    Instancia el juego de cartas, inicializa sus componentes y ejecuta
*                    la simulación.
*
*/

package P2;

public class Principal {

    /**
     * Method name: main
     *
     * Description of the Method: Método principal que inicia la ejecución de la
     * aplicación.
     * Crea una instancia de JuegoDeCartas, inicializa los elementos
     * necesarios y comienza el proceso de simulación del juego.
     * Calling arguments:
     * - String[] args: Arreglo de argumentos pasados por la línea de comandos.
     *
     * Return value: void.
     * Required Files: Fichero CSV de acciones accesible para la correcta
     * simulación.
     *
     * List of Checked Exceptions: Ninguno
     *************/
    public static void main(String[] args) {

        JuegoDeCartas jc = new JuegoDeCartas();

        // Inicializamos las pilas
        jc.inicializar();
        // Arrancamos la simulación
        jc.simulacion();

    }

}
