package P3.model;

import P3.util.Constantes;

/**
 * Clase que representa a un visitante de la atraccion: id, tipo de pase, tiempo
 * de llegada e inicio del recorrido.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (19/10/2026)
 */
public class Visitante implements Comparable<Visitante> {

    private int id; // identificador del visitante
    private int llegada; // tiempo de llegada a la atraccion
    private int inicio; // tiempo en que empieza su recorrido
    private String pase; // VIP, Fast Pass o Standard

    /**
     * Crea un visitante con su id, tiempo de llegada y tipo de pase
     *
     * @param id      identificador del visitante
     * @param llegada tiempo de llegada a la atraccion
     * @param pase    tipo de pase
     */
    public Visitante(int id, int llegada, String pase) {
        this.id = id;
        this.llegada = llegada;
        this.pase = pase;
    }

    /**
     * Devuelve el inicio del recorrido
     *
     * @return inicio
     */
    public int getInicio() {
        return inicio;
    }

    /**
     * Guarda el inicio del recorrido
     *
     * @param inicio tiempo en que empieza el recorrido
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    /**
     * Devuelve la llegada
     *
     * @return llegada
     */
    public int getLlegada() {
        return llegada;
    }

    /**
     * Guarda la llegada
     *
     * @param llegada tiempo de llegada a la atraccion
     */
    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    /**
     * Devuelve el id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Guarda el id
     *
     * @param id identificador del visitante
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el pase
     *
     * @return pase
     */
    public String getPase() {
        return pase;
    }

    /**
     * Guarda el pase
     *
     * @param pase tipo de pase
     */
    public void setPase(String pase) {
        this.pase = pase;
    }

    /**
     * Compara por pase (VIP, Fast Pass, Standard), luego por llegada y luego por
     * id
     *
     * @param v visitante con el que se compara
     * @return negativo si este va antes, 0 si son iguales, positivo si va despues
     */
    @Override
    public int compareTo(Visitante v) {
        int resultado = 0;

        int prioridadEste = prioridadPase(this.pase);
        int prioridadOtro = prioridadPase(v.getPase());

        // 1. Miramos el pase
        if (prioridadEste < prioridadOtro) {
            resultado = -1;
        } else if (prioridadEste > prioridadOtro) {
            resultado = 1;
        } else if (prioridadEste == prioridadOtro) {

            // 2. Mismo pase: va antes el que llegó primero
            if (this.llegada < v.getLlegada()) {
                resultado = -1;
            } else if (this.llegada > v.getLlegada()) {
                resultado = 1;
            } else if (this.llegada == v.getLlegada()) {

                // 3. Han llegado a la vez: va antes el de menor id
                if (this.id < v.getId()) {
                    resultado = -1;
                } else if (this.id > v.getId()) {
                    resultado = 1;
                }
            }
        }

        return resultado;
    }

    /**
     * Pasa el pase a un numero de prioridad: VIP -1, Fast Pass 0 y Standard 1
     *
     * @param pase tipo de pase
     * @return prioridad del pase
     * @throws IllegalArgumentException si el pase no existe
     */
    private int prioridadPase(String pase) {

        int prioridad = -99;

        if (Constantes.STANDARD.equalsIgnoreCase(pase)) {
            prioridad = 1;
        } else if (Constantes.FAST_PASS.equalsIgnoreCase(pase)) {
            prioridad = 0;
        } else if (Constantes.VIP_PASS.equalsIgnoreCase(pase)) {
            prioridad = -1;
        }

        // Si el pase no es ninguno, revision de errores
        if (prioridad == -99) {
            throw new IllegalArgumentException("Pase no reconocido: " + pase);
        }

        return prioridad;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Pase: " + pase + " | Llegada: " + llegada + " | Inicio: " + inicio;
    }

}
