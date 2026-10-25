package P4.model;

import P4.util.file.LeerFicheroInt;

/**
 * Clase que representa a un candidato individual de una lista electoral.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (24/10/2026)
 */
public class Candidato implements Comparable<Candidato>, LeerFicheroInt {

    private String partido; // partido
    private String circunscripcion; // circunscripcion
    private int posicion; // posicion
    private String nombre; // nombre
    private Genero genero; // genero

    /**
     * Constructor vacio
     */
    public Candidato() {

    }

    /**
     * Crea un candidato con todos sus datos
     *
     * @param partido         partido del candidato
     * @param circunscripcion circunscripcion del candidato
     * @param posicion        posicion en la lista
     * @param nombre          nombre del candidato
     * @param genero          genero del candidato
     */
    public Candidato(String partido, String circunscripcion, int posicion, String nombre, Genero genero) {
        this.partido = partido;
        this.circunscripcion = circunscripcion;
        this.posicion = posicion;
        this.nombre = nombre;
        this.genero = genero;
    }

    /**
     * Devuelve el partido
     *
     * @return partido
     */
    public String getPartido() {
        return partido;
    }

    /**
     * Devuelve la circunscripcion
     *
     * @return circunscripcion
     */
    public String getCircunscripcion() {
        return circunscripcion;
    }

    /**
     * Devuelve la posicion
     *
     * @return posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Devuelve el nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el genero
     *
     * @return genero
     */
    public Genero getGenero() {
        return genero;
    }

    @Override
    public int compareTo(Candidato otro) {
        return Integer.compare(this.posicion, otro.posicion);
    }

    @Override
    public String toString() {
        return "Candidato [partido=" + partido + ", circunscripcion=" + circunscripcion + ", posicion=" + posicion
                + ", nombre=" + nombre + ", genero=" + genero + "]";
    }

    /**
     * Lee los datos del ficheros
     * 
     * @param data campos de la linea del fichero
     */
    @Override
    public void leerDatos(String[] data) {
        this.partido = data[0];
        this.circunscripcion = data[1];
        this.posicion = Integer.parseInt(data[2]);
        this.nombre = data[3];
        this.genero = Genero.valueOf(data[4]);

    }
}
