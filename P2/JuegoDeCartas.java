/****
*
* Class Name: JuegoDeCartas
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase principal que controla la lógica y flujo del juego de cartas.
*                    Se encarga de la inicialización de las pilas, la lectura de las
*                    acciones desde el fichero y la simulación del juego.
*
*/

package P2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import P2.model.Accion;
import P2.model.Efecto;
import P2.util.Constantes;
import P2.util.Constantes.CARTA;
import P2.util.file.FicheroSecuencial;

public class JuegoDeCartas {

    // Pila que representa el mazo de robo principal del juego
    private Stack<CARTA> mazoDeRobo;

    // Pila que almacena las cartas que han sido descartadas
    private Stack<CARTA> mazoDeDescartes;

    // Pila que gestiona los efectos pendientes de resolución en la part
    private Stack<Efecto> pilaDeEfectos;

    /**
    * Method name: inicializar
    *
    * Description of the Method: Prepara las estructuras de datos iniciales del juego,
    *                            instanciando las pilas e introduciendo todas las cartas
    *                            disponibles en el mazo de robo.
    * Calling arguments: Ninguno
    *
    * Return value: void.
    * Required Files: Ninguno
    *
    * List of Checked Exceptions: Ninguno
    *************/
    public void inicializar() {
        System.out.println("*************************************************************");
        System.out.println("INICIALIZANDO DATOS:\n");
        // Inicializamos las pilas
        mazoDeRobo = new Stack<CARTA>();
        mazoDeDescartes = new Stack<CARTA>();
        pilaDeEfectos = new Stack<Efecto>();
        // Rellenamos el mazo de robo
        rellenarMazoRobo(mazoDeRobo);
        System.out.println("*************************************************************");

    }

    /**
    * Method name: rellenarMazoRobo
    *
    * Description of the Method: Recorre todas las cartas del enumerado CARTA y las apila
    *                            en el mazo de robo suministrado.
    * Calling arguments: 
    *   - Stack<CARTA> mazo: Pila correspondiente al mazo de robo que se va a rellenar.
    *
    * Return value: void.
    * Required Files: Nignuno
    *
    * List of Checked Exceptions: Ninguno
    *************/
    public void rellenarMazoRobo(Stack<CARTA> mazo) {
        for (CARTA carta : Constantes.CARTA.values()) {
            System.out.println(carta);
            mazo.push(carta);
        }
    }

    /**
    * Method name: simulacion
    *
    * Description of the Method: Carga la lista de acciones desde el fichero y las ejecuta de forma
    *                            secuencial sobre el estado actual del juego, imprimiendo el resultado.
    * Calling arguments: Nignuno
    *
    * Return value: void.
    * Required Files: Fichero de acciones accesible en la ruta especificada en Constantes.
    *
    * List of Checked Exceptions: Ninguno
    *************/

    public void simulacion() {

        List<Accion> lstAccciones = JuegoDeCartas.leerFicheroAcciones();

        for (Accion accion : lstAccciones) {
            String resultadoAccion = Acciones.ejecutarAcciones(accion, pilaDeEfectos, mazoDeDescartes, mazoDeRobo);
            System.out.println(resultadoAccion);
            System.out.println("");
        }
    }

    /**
    * Method name: leerFicheroAcciones
    *
    * Description of the Method: Lee y procesa las acciones registradas en el archivo CSV especificado
    *                            en las constantes, validando las jugadas y retornando la lista cargada.
    * Calling arguments: Ninguno
    *
    * Return value: List<Accion> - Lista de acciones leídas y validadas desde el fichero.
    * Required Files: Fichero CSV configurado en Constantes.RUTA_FICHERO_ACCIONES.
    *
    * List of Checked Exceptions: Ninguno
    *************/

    private static List<Accion> leerFicheroAcciones() {
        System.out.println("*************************************************************");
        System.out.println("LEYENDO FIHCERO ACCIONES:\n");
        List<Accion> lstAcciones = new ArrayList<>();

        try {
            FicheroSecuencial<Accion> sf = new FicheroSecuencial<Accion>(Constantes.RUTA_FICHERO_ACCIONES,
                    Constantes.SEPARADOR_CSV);
            while (!sf.isEndOfFile()) {
                Accion a = new Accion();
                sf.read(a);

                // Revisamos que las cartas jugadas existan
                if (a.getCarta() != null
                        || (a.getJugada().equalsIgnoreCase("ROBAR") || a.getJugada().equalsIgnoreCase("DESCARTAR"))) {
                    System.out.println(a);
                    lstAcciones.add(a);
                }

            }
            sf.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuntra el fichero, revisa la ruta");
        }
        System.out.println("*************************************************************");
        return lstAcciones;
    }
}
