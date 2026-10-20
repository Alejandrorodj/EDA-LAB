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
 */
public class ListaElectoral {

    private String partido;
    private String circunscripcion;
    private int votosPartido;
    private List<Candidato> candidatos;

    public ListaElectoral(String partido, String circunscripcion) {
        this.partido = partido;
        this.circunscripcion = circunscripcion;
        this.votosPartido = 0;
        this.candidatos = new ArrayList<>();
    }

    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);

    }

    public String getPartido() {
        return partido;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public int getVotosPartido() {
        return votosPartido;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public int getNumHombres() {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getGenero() == Genero.H) {
                count++;
            }
        }
        return count;
    }

    public int getNumMujeres() {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getGenero() == Genero.M) {
                count++;
            }
        }
        return count;
    }

    public double getPorcentajeHombres() {
        double res = 0;
        if (candidatos.isEmpty()) {
            res = 0;
        } else {
            res = (double) getNumHombres() / candidatos.size() * 100.0;
        }
        return res;
    }

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
     * 
     * @param votosPartido
     */
    public void setVotosPartido(int votosPartido) {
        this.votosPartido = votosPartido;
    }

    /**
     * 
     * @param listCandidatos
     * @return
     */
    public boolean cumpleParidad() {
        boolean result = false;
        int mujeres = 0;
        int total = 0;
        double porcertajeMujeres = 0;

        for (Candidato c : candidatos) {
            if (Genero.M.equals(c.getGenero())) {
                mujeres += 1;
            }
            total++;
        }

        porcertajeMujeres = (mujeres * 100) / total;

        if (porcertajeMujeres >= 40 && porcertajeMujeres <= 60) {
            result = true;
        }

        return result;
    }

    public int calcularEscanos() {
        return votosPartido / Constantes.VOTOS_ESCANO;
    }

    public List<Candidato> getCandidatosElectos() {
        // TO DO: completar implementación
        List<Candidato> lstCandidatos = new ArrayList<>();

        return lstCandidatos;
    }

    public void mostrarListaCandidatos() {
        System.out.println("Lista electoral de " + partido + " en " + circunscripcion + ":");
        for (Candidato c : candidatos) {
            System.out.println("   " + c.getPosicion() + " " + c.getNombre() + " (" + c.getGenero() + ")");
        }
        System.out.println();
    }
}
