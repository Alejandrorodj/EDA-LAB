package P2.model;

import P2.util.Constantes.CARTA;
import P2.util.file.LeerFicheroInt;

/**
 * Clase que representa una accion leida de una linea del fichero CSV: jugador,
 * jugada (ROBAR, JUGAR, DESCARTAR o RESOLVER) y carta, si la lleva.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (04/10/2026)
 */
public class Accion implements LeerFicheroInt {

    private String jugador; // jugador que hace la accion
    private String jugada; // ROBAR, JUGAR, DESCARTAR o RESOLVER
    private CARTA carta; // carta de la jugada

    /**
     * Constructor vacio
     */
    public Accion() {
    }

    /**
     * Crea una accion con todos sus datos
     *
     * @param jugador jugador que hace la accion
     * @param jugada  tipo de jugada
     * @param carta   carta de la jugada, o null si no lleva
     */
    public Accion(String jugador, String jugada, CARTA carta) {
        this.jugador = jugador;
        this.jugada = jugada;
        this.carta = carta;
    }

    /**
     * Lee los datos de una linea del fichero. Si la carta no existe avisa y la
     * deja a null
     *
     * @param campos campos de la linea: jugador, jugada y carta (opcional)
     */
    public void leerDatos(String[] campos) {
        jugador = campos[0].trim();
        jugada = campos[1].trim();

        if (campos.length == 3) {
            try {
                carta = CARTA.valueOf(campos[2].trim());
            } catch (IllegalArgumentException e) {
                System.err.println("Carta no reconocida en el sistema: " + campos[2].trim());
            }
        }

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
     * @param jugador jugador que hace la accion
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * Devuelve la jugada
     *
     * @return jugada
     */
    public String getJugada() {
        return jugada;
    }

    /**
     * Guarda la jugada
     *
     * @param jugada tipo de jugada
     */
    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

    /**
     * Devuelve la carta
     *
     * @return carta, o null si no lleva
     */
    public CARTA getCarta() {
        return carta;
    }

    /**
     * Guarda la carta
     *
     * @param carta carta de la jugada
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

        String resultado = jugador + "(accion: " + jugada + " - carta: " + carta + ")";

        if (carta == null) {
            resultado = jugador + "(accion: " + jugada + ")";
        }

        return resultado;

    }

}
