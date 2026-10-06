package P2.model;

import P2.util.Constantes.CARTA;
import P2.util.file.LeerFicheroInt;

/**
 * Acción leída de una línea del fichero CSV: jugador, jugada ({@code ROBAR},
 * {@code JUGAR}, {@code DESCARTAR} o {@code RESOLVER}) y carta, si la lleva.
 *
 * @author LP, AR, VT (código de equipo: TODO)
 * @version 1.0 (04/10/2026)
 */
public class Accion implements LeerFicheroInt {

    /** Jugador que realiza la acción. */
    private String jugador;

    /** Tipo de jugada: ROBAR, JUGAR, DESCARTAR o RESOLVER. */
    private String jugada;

    /** Carta de la jugada; {@code null} en ROBAR y RESOLVER o si no existe. */
    private CARTA carta;

    /** Crea una acción vacía, que se rellena después con {@link #leerDatos(String[])}. */
    public Accion() {
    }

    /**
     * Crea una acción con todos sus datos.
     *
     * @param jugador jugador que realiza la acción
     * @param jugada tipo de jugada
     * @param carta carta de la jugada, o {@code null} si no lleva
     */
    public Accion(String jugador, String jugada, CARTA carta) {
        this.jugador = jugador;
        this.jugada = jugada;
        this.carta = carta;
    }

    /**
     * Rellena la acción con los campos de una línea del CSV. Si la carta no existe
     * en {@link CARTA}, avisa por la salida de error y la deja a {@code null}.
     *
     * @param campos campos de la línea: jugador, jugada y, opcionalmente, carta
     */
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
     * Devuelve el jugador que realiza la acción.
     *
     * @return el jugador
     */
    public String getJugador() {
        return jugador;
    }

    /**
     * Cambia el jugador que realiza la acción.
     *
     * @param jugador el nuevo jugador
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * Devuelve el tipo de jugada.
     *
     * @return la jugada
     */
    public String getJugada() {
        return jugada;
    }

    /**
     * Cambia el tipo de jugada.
     *
     * @param jugada la nueva jugada
     */
    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

    /**
     * Devuelve la carta de la jugada.
     *
     * @return la carta, o {@code null} si no lleva
     */
    public CARTA getCarta() {
        return carta;
    }

    /**
     * Cambia la carta de la jugada.
     *
     * @param carta la nueva carta
     */
    public void setCarta(CARTA carta) {
        this.carta = carta;
    }

    @Override
    /**
     * Devuelve la acción como texto; sin la carta si no lleva.
     *
     * @return la acción en formato legible
     */
    public String toString() {

        String resultado = jugador + "(accion: " + jugada + " - carta: " + carta + ")";

        if (carta == null) {
            resultado = jugador + "(accion: " + jugada + ")";
        }

        return resultado;

    }

}
