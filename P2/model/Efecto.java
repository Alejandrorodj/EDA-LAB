/****
*
* Class Name: Efecto
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase que representa el efecto aplicado a un jugador en el juego.
*                    Almacena la información del jugador afectado y la carta involucrada.
*
*/

package P2.model;

import P2.util.Constantes.CARTA;

public class Efecto {
    // Nombre del jugador sobre el que recae el efecto
    private String jugador;

    // Carta asociada al efecto generado
    private CARTA carta;

    @Override
    public String toString() {
        return carta + " - " + jugador;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public CARTA getCarta() {
        return carta;
    }

    public void setCarta(CARTA carta) {
        this.carta = carta;
    }

    /**
    * Method name: Efecto
    *
    * Description of the Method: Constructor parametrizado que inicializa los atributos jugador y carta.
    * Calling arguments: 
    *   - String jugador: Nombre del jugador afectado por el efecto.
    *   - CARTA carta: Carta vinculada al efecto.
    *
    * Return value: Instancia de la clase Efecto.
    * Required Files: Ninguno
    *
    * List of Checked Exceptions: Ninguno
    *************/

    public Efecto(String jugador, CARTA carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

}
