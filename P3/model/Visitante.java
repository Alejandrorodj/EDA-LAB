package P3.model;

import P3.util.Constantes;

public class Visitante implements Comparable<Visitante> {
    private int id;
    private int llegada;
    private int inicio;

    private String pase;

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
     * Compara este visitante con otro según la prioridad del pase,
     * el tiempo de llegada y el identificador.
     *
     * @param v visitante con el que se compara
     * @return un valor negativo, cero o positivo según el orden
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
     * Traduce el pase en un numero segun su prioridad
     * VIP = -1
     * FAST_PASS = 0
     * STANDARD = 1
     * 
     * @param pase
     * @return prioridad del pase
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
     * Devuelve una representación textual de este visitante.
     *
     * @return cadena con la información del visitante
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Pase: " + pase + " | Llegada: " + llegada + " | Inicio: " + inicio;
    }

}
