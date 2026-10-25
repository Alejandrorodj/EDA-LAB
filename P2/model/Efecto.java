package P2.model;

import P2.util.Constantes.CARTA;

/**
 * Clase que representa un efecto de la pila de efectos: la carta jugada y el
 * jugador que la lanzo.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (04/10/2026)
 */
public class Efecto {

    private String jugador; // jugador que lanzo la carta
    private CARTA carta; // carta jugada

    @Override
    public String toString() {
        return carta + " - " + jugador;
    }

    /**
     * Devuelve el jugador
     *
     * @return jugador
     */
    public String getJugador() {
        return jugador;
    }

    /**
     * Guarda el jugador
     *
     * @param jugador jugador que lanzo la carta
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * Devuelve la carta
     *
     * @return carta
     */
    public CARTA getCarta() {
        return carta;
    }

    /**
     * Guarda la carta
     *
     * @param carta carta jugada
     */
    public void setCarta(CARTA carta) {
        this.carta = carta;
    }

    /**
     * Crea un efecto con la carta jugada y el jugador que la lanzo
     *
     * @param jugador jugador que lanzo la carta
     * @param carta   carta jugada
     */
    public Efecto(String jugador, CARTA carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

}
