package P2;

import P2.file.LeerFicheroInt;

/**
 * 
 * Accion
 */
public class Accion implements LeerFicheroInt {

    private String jugador;
    private String jugada;
    private String carta;

    /**
     * 
     */
    public Accion() {
    }

    /**
     * @param jugador
     * @param jugada
     * @param carta
     */
    public Accion(String jugador, String jugada, String carta) {
        this.jugador = jugador;
        this.jugada = jugada;
        this.carta = carta;
    }

    public void leerDatos(String[] campos) {
        jugador = campos[0].trim();
        jugada = campos[1].trim();
        try {
            carta = campos[2].trim();
        } catch (Exception e) {

        }
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
     * @return the jugada
     */
    public String getJugada() {
        return jugada;
    }

    /**
     * @param jugada the jugada to set
     */
    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

    /**
     * @return the carta
     */
    public String getCarta() {
        return carta;
    }

    /**
     * @param carta the carta to set
     */
    public void setCarta(String carta) {
        this.carta = carta;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Accion [jugador=" + jugador + ", jugada=" + jugada + ", carta=" + carta + "]";
    }

}
