package P4;

import java.util.ArrayList;
import java.util.List;

import P4.model.Candidato;
import P4.model.Genero;

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
        // TO DO: completar implementación
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

    public void setVotosPartido(int votosPartido) {
        this.votosPartido = votosPartido;
    }

    public boolean cumpleParidad() {
        // TO DO: completar implementación
        boolean result = false;

        return result;
    }

    public int calcularEscanos() {
        // TO DO: completar implementación
        int result = 0;

        return result;
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
