package P3.model;

import P3.util.Constantes;

/**
 * Representa a un visitante de la atraccion, incluyendo su identificador,
 * tipo de pase, tiempo de llegada e inicio del recorrido.
 *
 * @author LP, AR, VT
 * @version 1.0 (19/10/2026)
 */
public class Visitante implements Comparable<Visitante> {
    /** Identificador numerico unico del visitante. */
    private int id;

    /** Instante en el que el visitante llega a la atraccion. */
    private int llegada;

    /** Instante en el que el visitante comienza el recorrido. */
    private int inicio;

    /** Tipo de pase del visitante: VIP, Fast Pass o Standard. */
    private String pase;

    /**
     * Crea un visitante con su identificador, instante de llegada y tipo de pase.
     * El instante de inicio queda inicialmente a cero.
     *
     * @param id identificador del visitante
     * @param llegada instante de llegada a la atraccion
     * @param pase tipo de pase del visitante
     */
    public Visitante(int id, int llegada, String pase) {
        this.id = id;
        this.llegada = llegada;
        this.pase = pase;
    }

    /**
     * @return the inicio
     */
    public int getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    /**
     * 
     * @return llegada
     */
    public int getLlegada() {
        return llegada;
    }

    /**
     * 
     * @param llegada
     */
    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return pase
     */
    public String getPase() {
        return pase;
    }

    /**
     * @param pase pase
     */
    public void setPase(String pase) {
        this.pase = pase;
    }

     /**
     * Compara este visitante con otro según la prioridad del pase; si ambos
     * tienen el mismo tipo de pase, compara la llegada y, si coincide, el id.
     *
     * @param v visitante con el que se compara este visitante
     * @return un valor negativo si este visitante va antes, cero si empatan,
     *         o un valor positivo si este visitante va después
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
     * Asigna un valor numerico a cada tipo de pase para establecer su prioridad.
     * VIP tiene prioridad máxima(-1), seguido de Fast Pass(0) y Standard(1).
     *
     * @param pase tipo de pase que se desea evaluar
     * @return valor numerico de prioridad del pase
     * @throws IllegalArgumentException si el pase no se reconoce
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
     * Genera una representación textual con los datos principales del visitante.
     *
     * @return cadena con el id, el pase, la llegada y el inicio del recorrido
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Pase: " + pase + " | Llegada: " + llegada + " | Inicio: " + inicio;
    }

}
