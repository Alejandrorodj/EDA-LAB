package P2.model;

import P2.util.Constantes.CARTA;
import P2.util.file.LeerFicheroInt;

/**
 * 
 * Accion
 */
public class Accion implements LeerFicheroInt {

    private String jugador;
    private String jugada;
    private CARTA carta;

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
    public Accion(String jugador, String jugada, CARTA carta) {
        this.jugador = jugador;
        this.jugada = jugada;
        this.carta = carta;
    }

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
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return jugador + "(accion: " + jugada + " - carta: " + carta + ")";
    }

}
