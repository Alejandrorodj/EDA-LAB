package P1;

/**
 * Clase que representa un satelite con sus datos orbitales, leidos de una linea
 * del fichero.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (22/09/2026)
 */
public class Satelite implements LeerFicheroInt {
    private String nombre; // nombre del satelite
    private String designadorInternacional; // designador internacional
    private String epoca; // epoca de los datos
    private double inclinacion; // inclinacion de la orbita
    private double raan; // ascension recta del nodo ascendente
    private double excentricidad; // excentricidad de la orbita
    private double argumentoPerigeo; // argumento del perigeo
    private double numOrbitas; // orbitas al dia (meanMotion)

    /**
     * Crea un satelite con todos sus datos
     *
     * @param nombre                  nombre del satelite
     * @param designadorInternacional designador internacional
     * @param epoca                   epoca de los datos
     * @param inclinacion             inclinacion de la orbita
     * @param raan                    ascension recta del nodo ascendente
     * @param excentricidad           excentricidad de la orbita
     * @param argumentoPerigeo        argumento del perigeo
     * @param numOrbitas              orbitas al dia
     */
    public Satelite(String nombre, String designadorInternacional, String epoca, double inclinacion, double raan,
            double excentricidad, double argumentoPerigeo, double numOrbitas) {
        this.nombre = nombre;
        this.designadorInternacional = designadorInternacional;
        this.epoca = epoca;
        this.inclinacion = inclinacion;
        this.raan = raan;
        this.excentricidad = excentricidad;
        this.argumentoPerigeo = argumentoPerigeo;
        this.numOrbitas = numOrbitas;
    }

    /**
     * Constructor vacio
     */
    public Satelite() {
    }

    /**
     * Lee los datos de una linea del fichero
     *
     * @param campos campos de la linea del fichero
     */
    public void leerDatos(String[] campos) {
        nombre = campos[0].trim();
        designadorInternacional = campos[1].trim();
        epoca = campos[2].trim();
        try {
            inclinacion = Double.parseDouble(campos[5].trim());
            raan = Double.parseDouble(campos[6].trim());
            excentricidad = Double.parseDouble(campos[4].trim());
            argumentoPerigeo = Double.parseDouble(campos[7].trim());
            numOrbitas = Double.parseDouble(campos[3].trim());
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
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
     * Guarda el nombre
     *
     * @param nombre nombre del satelite
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el designador internacional
     *
     * @return designador internacional
     */
    public String getDesignadorInternacional() {
        return designadorInternacional;
    }

    /**
     * Guarda el designador internacional
     *
     * @param designadorInternacional designador internacional
     */
    public void setDesignadorInternacional(String designadorInternacional) {
        this.designadorInternacional = designadorInternacional;
    }

    /**
     * Devuelve la epoca
     *
     * @return epoca
     */
    public String getEpoca() {
        return epoca;
    }

    /**
     * Guarda la epoca
     *
     * @param epoca epoca de los datos
     */
    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    /**
     * Devuelve la inclinacion
     *
     * @return inclinacion
     */
    public double getInclinacion() {
        return inclinacion;
    }

    /**
     * Guarda la inclinacion
     *
     * @param inclinacion inclinacion de la orbita
     */
    public void setInclinacion(double inclinacion) {
        this.inclinacion = inclinacion;
    }

    /**
     * Devuelve la ascension recta del nodo ascendente
     *
     * @return raan
     */
    public double getRaan() {
        return raan;
    }

    /**
     * Guarda la ascension recta del nodo ascendente
     *
     * @param raan ascension recta del nodo ascendente
     */
    public void setRaan(double raan) {
        this.raan = raan;
    }

    /**
     * Devuelve la excentricidad
     *
     * @return excentricidad
     */
    public double getExcentricidad() {
        return excentricidad;
    }

    /**
     * Guarda la excentricidad
     *
     * @param excentricidad excentricidad de la orbita
     */
    public void setExcentricidad(double excentricidad) {
        this.excentricidad = excentricidad;
    }

    /**
     * Devuelve el argumento del perigeo
     *
     * @return argumento del perigeo
     */
    public double getArgumentoPerigeo() {
        return argumentoPerigeo;
    }

    /**
     * Guarda el argumento del perigeo
     *
     * @param argumentoPerigeo argumento del perigeo
     */
    public void setArgumentoPerigeo(double argumentoPerigeo) {
        this.argumentoPerigeo = argumentoPerigeo;
    }

    /**
     * Devuelve las orbitas al dia
     *
     * @return numero de orbitas
     */
    public double getNumOrbitas() {
        return numOrbitas;
    }

    /**
     * Guarda las orbitas al dia
     *
     * @param numOrbitas numero de orbitas
     */
    public void setNumOrbitas(double numOrbitas) {
        this.numOrbitas = numOrbitas;
    }

    /**
     * Devuelve el satelite como texto: nombre, orbitas e inclinacion
     *
     * @return satelite en formato legible
     */
    public String toString() {
        return String.format("Satélite: %-25s | Órbitas/día: %.2f | Inclinación: %.2f°",
                nombre, numOrbitas, inclinacion);
    }

}
