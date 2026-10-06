package P2.model;

import P2.util.Constantes.CARTA;

/**
 * Efecto de la pila de efectos: la carta jugada y el jugador que la lanzó.
 *
 * @author LP, AR, VT (código de equipo: TODO)
 * @version 1.0 (04/10/2026)
 */
public class Efecto {

    /** Jugador que lanzó la carta. */
    private String jugador;

    /** Carta jugada. */
    private CARTA carta;

    @Override
    /**
     * Devuelve el efecto como texto: carta y jugador.
     *
     * @return el efecto en formato legible
     */
    public String toString() {
        return carta + " - " + jugador;
    }

    /**
     * Devuelve el jugador que lanzó la carta.
     *
     * @return el jugador
     */
    public String getJugador() {
        return jugador;
    }

    /**
     * Cambia el jugador que lanzó la carta.
     *
     * @param jugador el nuevo jugador
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * Devuelve la carta del efecto.
     *
     * @return la carta
     */
    public CARTA getCarta() {
        return carta;
    }

    /**
     * Cambia la carta del efecto.
     *
     * @param carta la nueva carta
     */
    public void setCarta(CARTA carta) {
        this.carta = carta;
    }

    /**
     * Crea un efecto con la carta jugada y el jugador que la lanzó.
     *
     * @param jugador jugador que lanzó la carta
     * @param carta carta jugada
     */
    public Efecto(String jugador, CARTA carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

}
