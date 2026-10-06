/****
*
* Class Name: Accion
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase que representa una acción aplicable dentro del juego. 
*                    Contiene un identificador, el nombre de la acción y el efecto 
*                    asociado a la misma.
*
*/

package P2.model;

import P2.util.Constantes.CARTA;
import P2.util.file.LeerFicheroInt;

public class Accion implements LeerFicheroInt {

    // Nombre o identificador del jugador que realiza la acción
    private String jugador;

    // Tipo de jugada realizada por el jugador
    private String jugada;

    // Carta asociada a la jugada realizada
    private CARTA carta;

    /**
     * Method name: Accion
     *
     * Description of the Method: Constructor por defecto de la clase Accion.
     * Crea una instancia de la clase sin inicializar sus atributos.
     * Calling arguments: Ninguno
     *
     * Return value: Instancia de la clase Accion.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguna
     *************/
    public Accion() {
    }

    /**
     * Method name: Accion
     *
     * Description of the Method: Constructor parametrizado que inicializa los
     * atributos jugador, jugada y carta.
     * Calling arguments:
     * - String jugador: Nombre del jugador que realiza la acción.
     * - String jugada: Descripción o tipo de la jugada realizada.
     * - CARTA carta: Carta utilizada en la jugada.
     *
     * Return value: Instancia de la clase Accion.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/

    public Accion(String jugador, String jugada, CARTA carta) {
        this.jugador = jugador;
        this.jugada = jugada;
        this.carta = carta;
    }

    /**
     * Method name: leerDatos
     *
     * Description of the Method: Lee los datos de un arreglo de cadenas y asigna
     * los valores correspondientes
     * a los atributos jugador, jugada y carta.
     * Calling arguments:
     * - String[] campos: Arreglo de cadenas de caracteres que contiene los valores
     * a asignar a la acción.
     *
     * Return value: void.
     * Required Files: Ninguno
     *
     * List of Checked Exceptions: Ninguno
     *************/
    public void leerDatos(String[] campos) {
        jugador = campos[0].trim();
        jugada = campos[1].trim();

        // Al no tener todos las lineas 3 campos hayq ue comprobar que tiene el 3
        // elemento para que no de error
        if (campos.length == 3) {
            try {
                carta = CARTA.valueOf(campos[2].trim());
            } catch (IllegalArgumentException e) {
                System.err.println("Carta no reconocida en el sistema: " + campos[2].trim());
            }
        }

    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getJugada() {
        return jugada;
    }

    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

    public CARTA getCarta() {
        return carta;
    }

    public void setCarta(CARTA carta) {
        this.carta = carta;
    }

    @Override
    public String toString() {

        String resultado = jugador + "(accion: " + jugada + " - carta: " + carta + ")";

        if (carta == null) {
            resultado = jugador + "(accion: " + jugada + ")";
        }

        return resultado;

    }

}
