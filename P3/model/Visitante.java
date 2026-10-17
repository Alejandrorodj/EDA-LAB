package P3.model;

import P3.util.Constantes;

public class Visitante implements Comparable<Visitante> {
    private int id;
    private int salida;
    private int llegada;
    private String pase;

    public Visitante(int id, int llegada, int salida, String pase) {
        this.id = id;
        this.llegada = llegada;
        this.salida = salida;
        this.pase = pase;
    }

    /**
     * 
     * @return the inicio
     */
    public int getLlegada() {
        return llegada;
    }

    /**
     * 
     * @param inicio
     */
    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    /**
     * @return the llegada
     */
    public int getSalida() {
        return salida;
    }

    /**
     * @param salida the llegada to set
     */
    public void setSalida(int salida) {
        this.salida = salida;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pase
     */
    public String getPase() {
        return pase;
    }

    /**
     * @param pase the pase to set
     */
    public void setPase(String pase) {
        this.pase = pase;
    }

    /**
     * @param id
     * @param pase
     */
    public Visitante(int id, String pase) {
        this.id = id;
        this.pase = pase;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
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
            if (this.salida < v.getSalida()) {
                resultado = -1;
            } else if (this.salida > v.getSalida()) {
                resultado = 1;
            } else if (this.salida == v.getSalida()) {

                // 3. Han llegado a la vez: va antes el de menor id
                if (this.id < v.getId()) {
                    resultado = -1;
                }
                if (this.id > v.getId()) {
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

}
