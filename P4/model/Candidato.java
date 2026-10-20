package P4.model;

import P4.util.file.LeerFicheroInt;

/**
 * Clase que representa a un candidato individual de una lista electoral.
 * 
 */
public class Candidato implements Comparable<Candidato>, LeerFicheroInt {
    private String partido;
    private String circunscripcion;
    private int posicion;
    private String nombre;
    private Genero genero;

    public Candidato() {

    }

    public Candidato(String partido, String circunscripcion, int posicion, String nombre, Genero genero) {
        this.partido = partido;
        this.circunscripcion = circunscripcion;
        this.posicion = posicion;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getPartido() {
        return partido;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

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
     * @param data
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
