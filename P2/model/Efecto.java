package P2.model;

import P2.util.Constantes.CARTA;

public class Efecto {
    private String jugador;
    private CARTA carta;

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return carta + " - " + jugador;
    }

    /**
     * @return the jugador
     */
    public String getJugador() {
        return jugador;
    }

    /**
     * @param jugador the jugador to set
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * @return the carta
     */
    public CARTA getCarta() {
        return carta;
    }

    /**
     * @param carta the carta to set
     */
    public void setCarta(CARTA carta) {
        this.carta = carta;
    }

    /**
     * @param jugador
     * @param carta
     */
    public Efecto(String jugador, CARTA carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

}
