package P3.model;

import P3.Constantes;

public class Visitante implements Comparable<Visitante> {
    private int id;
    private int llegada;
    private String pase;

    /**
     * @return the llegada
     */
    public int getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(int llegada) {
        this.llegada = llegada;
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

    @Override
    public int compareTo(Visitante o) {
        // Si el actual es de tipo VIP
        if (this.pase.equalsIgnoreCase(Constantes.VIP_PASS)) {
            return -1;
        } else if (this.pase.equalsIgnoreCase(Constantes.FAST_PASS)) {
            return 0;
        }

        // Si el visitante actual es de tipo standard
        if (o.getPase().equalsIgnoreCase(Constantes.VIP_PASS) && this.pase.equalsIgnoreCase(Constantes.VIP_PASS)) {
            return -1;
        } else if (o.getPase().equalsIgnoreCase(Constantes.FAST_PASS)
                && this.pase.equalsIgnoreCase(Constantes.VIP_PASS)) {
            return 0;
        } else if (o.getPase().equalsIgnoreCase(Constantes.STANDARD)
                && this.pase.equalsIgnoreCase(Constantes.VIP_PASS)) {
            return 0;
        } else if (o.getPase().equalsIgnoreCase(Constantes.VIP_PASS)
                && this.pase.equalsIgnoreCase(Constantes.FAST_PASS)) {
            return 0;
        } else if (o.getPase().equalsIgnoreCase(Constantes.FAST_PASS)
                && this.pase.equalsIgnoreCase(Constantes.FAST_PASS)) {
            return 0;
        } else if (o.getPase().equalsIgnoreCase(Constantes.FAST_PASS)
                && this.pase.equalsIgnoreCase(Constantes.STANDARD)) {
            return 0;
        } else if (o.getPase().equalsIgnoreCase(Constantes.STANDARD)
                && this.pase.equalsIgnoreCase(Constantes.FAST_PASS)) {
            return 0;
        }

        return 1;
    }

}
