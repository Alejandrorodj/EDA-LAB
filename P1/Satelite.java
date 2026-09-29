package P1;

/**
 * 
 * Satelite
 */
public class Satelite implements LeerFicheroInt {
    private String nombre;
    private String designadorInternacional;
    private String epoca;
    private double inclinacion;
    private double raan;
    private double excentricidad;
    private double argumentoPerigeo;
    private double numOrbitas; // meanMotion

    /**
     * @param nombre
     * @param designadorInternacional
     * @param epoca
     * @param inclinacion
     * @param raan
     * @param excentricidad
     * @param argumentoPerigeo
     * @param revolucionesPorDia
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
     * constructor vacio
     */
    public Satelite() {
    }

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the designadorInternacional
     */
    public String getDesignadorInternacional() {
        return designadorInternacional;
    }

    /**
     * @param designadorInternacional the designadorInternacional to set
     */
    public void setDesignadorInternacional(String designadorInternacional) {
        this.designadorInternacional = designadorInternacional;
    }

    /**
     * @return the epoca
     */
    public String getEpoca() {
        return epoca;
    }

    /**
     * @param epoca the epoca to set
     */
    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    /**
     * @return the inclinacion
     */
    public double getInclinacion() {
        return inclinacion;
    }

    /**
     * @param inclinacion the inclinacion to set
     */
    public void setInclinacion(double inclinacion) {
        this.inclinacion = inclinacion;
    }

    /**
     * @return the raan
     */
    public double getRaan() {
        return raan;
    }

    /**
     * @param raan the raan to set
     */
    public void setRaan(double raan) {
        this.raan = raan;
    }

    /**
     * @return the excentricidad
     */
    public double getExcentricidad() {
        return excentricidad;
    }

    /**
     * @param excentricidad the excentricidad to set
     */
    public void setExcentricidad(double excentricidad) {
        this.excentricidad = excentricidad;
    }

    /**
     * @return the argumentoPerigeo
     */
    public double getArgumentoPerigeo() {
        return argumentoPerigeo;
    }

    /**
     * @param argumentoPerigeo the argumentoPerigeo to set
     */
    public void setArgumentoPerigeo(double argumentoPerigeo) {
        this.argumentoPerigeo = argumentoPerigeo;
    }

    /**
     * @return numero de orbitas
     */
    public double getNumOrbitas() {
        return numOrbitas;
    }

    /**
     * @param numero de orbitas
     */
    public void setNumOrbitas(double numOrbitas) {
        this.numOrbitas = numOrbitas;
    }

    public String toString() {
        return String.format("Satélite: %-25s | Órbitas/día: %.2f | Inclinación: %.2f°",
                nombre, numOrbitas, inclinacion);
    }

}
