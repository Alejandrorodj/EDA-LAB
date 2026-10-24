package P4;

import java.util.ArrayList;
import java.util.List;

import P4.model.Candidato;
import P4.model.Genero;
import P4.util.Constantes;

/**
 * Clase que representa la lista electoral de un partido en una circunscripcion
 * determinada.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (24/10/2026)
 */
public class ListaElectoral {

    private String partido; // partido de la lista
    private String circunscripcion; // circunscripcion de la lista
    private int votosPartido; // votos que ha sacado el partido
    private List<Candidato> candidatos; // candidatos de la lista

    /**
     * Crea una lista vacia de un partido en una circunscripcion
     *
     * @param partido partido de la lista
     * @param circunscripcion circunscripcion de la lista
     */
    public ListaElectoral(String partido, String circunscripcion) {
        this.partido = partido;
        this.circunscripcion = circunscripcion;
        this.votosPartido = 0;
        this.candidatos = new ArrayList<>();
    }

    /**
     * Añade candidatos a la lista
     * 
     * @param candidato candidato que se añade a la lista
     */
    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);

    }

    /**
     * Devuelve el partido de la lista
     *
     * @return partido
     */
    public String getPartido() {
        return partido;
    }

    /**
     * Devuelve la circunscripcion de la lista
     *
     * @return circunscripcion
     */
    public String getCircunscripcion() {
        return circunscripcion;
    }

    /**
     * Devuelve los votos del partido
     *
     * @return votos del partido
     */
    public int getVotosPartido() {
        return votosPartido;
    }

    /**
     * Devuelve la lista de candidatos
     *
     * @return lista de candidatos
     */
    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    /**
     * Cuenta los hombres de la lista
     *
     * @return numero de hombres
     */
    public int getNumHombres() {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getGenero() == Genero.H) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta las mujeres de la lista
     *
     * @return numero de mujeres
     */
    public int getNumMujeres() {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getGenero() == Genero.M) {
                count++;
            }
        }
        return count;
    }

    /**
     * Porcentaje de hombres de la lista
     *
     * @return porcentaje de hombres
     */
    public double getPorcentajeHombres() {
        double res = 0;
        if (candidatos.isEmpty()) {
            res = 0;
        } else {
            res = (double) getNumHombres() / candidatos.size() * 100.0;
        }
        return res;
    }

    /**
     * Porcentaje de mujeres de la lista
     *
     * @return porcentaje de mujeres
     */
    public double getPorcentajeMujeres() {
        double res = 0;
        if (candidatos.isEmpty()) {
            res = 0;
        } else {
            res = (double) getNumMujeres() / candidatos.size() * 100.0;
        }
        return res;
    }

    /**
     * Guarda los votos del partido
     *
     * @param votosPartido votos del partido
     */
    public void setVotosPartido(int votosPartido) {
        this.votosPartido = votosPartido;
    }

    /**
     * Comprueba la paridad de la lista: cada genero tiene que estar entre el
     * 40% y el 60%. Como solo hay dos generos, basta mirar el de las mujeres.
     * 
     * @return true si cumple la paridad, false si no
     */
    public boolean cumpleParidad() {
        boolean result = false;
        double porcertajeMujeres = getPorcentajeMujeres();

        if (porcertajeMujeres >= 40 && porcertajeMujeres <= 60) {
            result = true;
        }

        return result;
    }

    /**
     * Calcula los escaños: uno por cada VOTOS_ESCANO votos completos.
     * 
     * @return numero de escaños
     */
    public int calcularEscanos() {
        return votosPartido / Constantes.VOTOS_ESCANO;
    }

    /**
     * Devuelve los candidatos electos: los primeros de la lista, tantos como
     * escaños tenga el partido.
     * 
     * @return lista con los candidatos electos
     */
    public List<Candidato> getCandidatosElectos() {
        List<Candidato> lstCandidatos = new ArrayList<>();

        int numEscanosConseguidos = calcularEscanos();

        if (numEscanosConseguidos > candidatos.size()) {
            // Si hay mas escaños que candidatos, se devuelven todos
            lstCandidatos = candidatos;
        } else {
            for (int i = 0; i < numEscanosConseguidos; i++) {
                lstCandidatos.add(candidatos.get(i));
            }
        }

        return lstCandidatos;
    }

    /** Muestra la lista de candidatos */
    public void mostrarListaCandidatos() {
        System.out.println("Lista electoral de " + partido + " en " + circunscripcion + ":");
        for (Candidato c : candidatos) {
            System.out.println("   " + c.getPosicion() + " " + c.getNombre() + " (" + c.getGenero() + ")");
        }
        System.out.println();
    }
}
