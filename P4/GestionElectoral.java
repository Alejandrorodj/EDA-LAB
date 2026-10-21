package P4;

import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import P4.model.Candidato;
import P4.util.Constantes;
import P4.util.file.FicheroSecuencial;

/**
 * Programa principal para la gestion, verificacion y asignacion de candidaturas
 * electorales.
 * 
 */
public class GestionElectoral {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Candidato> todosCandidatos = new ArrayList<>();
        ListaElectoral BBMadrid = new ListaElectoral("BB", "Madrid");
        ListaElectoral BBBarcelona = new ListaElectoral("BB", "Barcelona");
        ListaElectoral BSOEMadrid = new ListaElectoral("BSOE", "Madrid");
        ListaElectoral BSOEBarcelona = new ListaElectoral("BSOE", "Barcelona");

        // Lectura del fichero CSV
        System.out.println("==========================================================");
        System.out.println("  SISTEMA DE GESTION ELECTORAL - CURSO 2026/27 (S04)");
        System.out.println("==========================================================");
        System.out.println("Cargando candidaturas desde: " + Constantes.RUTA_FICHERO + "...\n");
        procesarArchivoCSV(Constantes.RUTA_FICHERO, Constantes.SEPARADOR, todosCandidatos);
        System.out.println("Se han cargado correctamente " + todosCandidatos.size() + " registros de candidatos.\n");
        // generar listas electorales
        generarListasElectorales(todosCandidatos, BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // mostrar listas electorales
        mostrarListasElectorales(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // comprobar paridad en listas electorales y mostrar alertas
        verificarParidad(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // obtener votos de cada candidatura
        obtenerVotos(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // obtener escaños de cada partido en cada circunscripción
        obtenerEscanos(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // mostrar candidatos electos
        mostrarCandidatosElectos(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
    }

    /**
     * Proceso el archivo csv
     * @param rutaFichero
     * @param separador
     * @param todosCandidatos
     */
    private static void procesarArchivoCSV(String rutaFichero, String separador, List<Candidato> todosCandidatos) {
        try {
            FicheroSecuencial<Candidato> sf = new FicheroSecuencial<Candidato>(rutaFichero, separador);
            while (!sf.isEndOfFile()) {
                Candidato candidato = new Candidato();
                sf.read(candidato);
                todosCandidatos.add(candidato);
            }
            sf.close();
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mete los candidatos en el partido que es y circunscripcion de donde es
     * @param todosCandidatos
     * @param bBMadrid
     * @param bBBarcelona
     * @param bSOEMadrid
     * @param bSOEBarcelona
     */
    private static void generarListasElectorales(List<Candidato> todosCandidatos, ListaElectoral bBMadrid,
            ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona) {

        for(Candidato c : todosCandidatos) {
            if(c.getPartido().equals("BB")) {
                if(c.getCircunscripcion().equals("Madrid")) {
                    bBMadrid.agregarCandidato(c);
                } else {
                    bBBarcelona.agregarCandidato(c);
                }
            } else if(c.getPartido().equals("BSOE")) {
                if(c.getCircunscripcion().equals("Madrid")) {
                    bSOEMadrid.agregarCandidato(c);
                } else {
                    bSOEBarcelona.agregarCandidato(c);
                }
            }
        }

        Collections.sort(bBMadrid.getCandidatos());
        Collections.sort(bBBarcelona.getCandidatos());
        Collections.sort(bSOEMadrid.getCandidatos());
        Collections.sort(bSOEBarcelona.getCandidatos());
                
    }

    /**
     * Muestra las lista de cada partido en cada ciudad
     * @param bBMadrid
     * @param bBBarcelona
     * @param bSOEMadrid
     * @param bSOEBarcelona
     */
    private static void mostrarListasElectorales(ListaElectoral bBMadrid, ListaElectoral bBBarcelona,
            ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("1. LISTADOS DE CANDIDATURAS");
        System.out.println("----------------------------------------------------------");
        bBMadrid.mostrarListaCandidatos();
        bSOEMadrid.mostrarListaCandidatos();
        bBBarcelona.mostrarListaCandidatos();
        bSOEBarcelona.mostrarListaCandidatos();
    }

    private static void verificarParidad(ListaElectoral BBMadrid, ListaElectoral BBBarcelona,
            ListaElectoral BSOEMadrid, ListaElectoral BSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("2. ALERTAS DE PARIDAD EN CANDIDATURAS");
        System.out.println("----------------------------------------------------------");

        List<ListaElectoral> listasAlertasIncorrecta = new ArrayList<>();
        List<ListaElectoral> listasAlertasCorrecta = new ArrayList<>();
        if(!BBMadrid.cumpleParidad()){
            listasAlertasIncorrecta.add(BBMadrid);
        } else{
            listasAlertasCorrecta.add(BBMadrid);
        }

        if(!BBBarcelona.cumpleParidad()){
            listasAlertasIncorrecta.add(BBBarcelona);
        } else{
            listasAlertasCorrecta.add(BBBarcelona);
        }

        if(!BSOEMadrid.cumpleParidad()){
            listasAlertasIncorrecta.add(BSOEMadrid);
        } else{
            listasAlertasCorrecta.add(BSOEMadrid);
        }

        if(!BSOEBarcelona.cumpleParidad()){
            listasAlertasIncorrecta.add(BSOEBarcelona);
        } else{
            listasAlertasCorrecta.add(BSOEBarcelona);
        }

        mostrarAlertasParidad(listasAlertasIncorrecta);
        mostrarAlertasParidadCorrecta(listasAlertasCorrecta);
    }

    private static void mostrarAlertasParidad(List<ListaElectoral> listasAlertas) {
        for (int i = 0; i < listasAlertas.size(); i++) {
            ListaElectoral lista = listasAlertas.get(i);

            System.out.printf(
                "\n[ALERTA] El partido %s (%s) no cumple la paridad adecuada. "
                + "Representan un %.2f%% hombres y un %.2f%% mujeres.%n",
                lista.getPartido(),
                lista.getCircunscripcion(),
                lista.getPorcentajeHombres(),
                lista.getPorcentajeMujeres()
            );
        }
    }

    private static void mostrarAlertasParidadCorrecta(List<ListaElectoral> listasAlertasCorrectas) {
        for (int i = 0; i < listasAlertasCorrectas.size(); i++) {
            ListaElectoral lista = listasAlertasCorrectas.get(i);

            System.out.printf(
                "\nEl partido %s (%s) cumple la paridad correcta. "
                + "Representan un %.2f%% hombres y un %.2f%% mujeres.%n",
                lista.getPartido(),
                lista.getCircunscripcion(),
                lista.getPorcentajeHombres(),
                lista.getPorcentajeMujeres()
            );
        }
    }


    /**
     * Lee los votos que tiene cada partido en cada ciudad
     * @param bBMadrid
     * @param bBBarcelona
     * @param bSOEMadrid
     * @param bSOEBarcelona
     */

private static void obtenerVotos(ListaElectoral bBMadrid, ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid,
            ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("3. RECUENTO DE VOTACIONES");
        System.out.println("----------------------------------------------------------");
        bBMadrid.setVotosPartido(leerNumeroVotos("BB", "Madrid"));
        bSOEMadrid.setVotosPartido(leerNumeroVotos("BSOE", "Madrid"));
        bBBarcelona.setVotosPartido(leerNumeroVotos("BB", "Barcelona"));
        bSOEBarcelona.setVotosPartido(leerNumeroVotos("BSOE", "Barcelona"));
    }

    /**
     * Lee los escaños de cada partido en cada ciudad
     * @param bBMadrid
     * @param bBBarcelona
     * @param bSOEMadrid
     * @param bSOEBarcelona
     */
    private static void obtenerEscanos(ListaElectoral bBMadrid, ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid,
            ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("4. RECUENTO DE ESCAÑOS");
        System.out.println("----------------------------------------------------------");
        System.out.println("BB en Madrid obtiene " + bBMadrid.calcularEscanos() + " escaños");
        System.out.println("BSOE en Madrid obtiene " + bSOEMadrid.calcularEscanos() + " escaños");
        System.out.println("BB en Barcelona obtiene " + bBBarcelona.calcularEscanos() + " escaños");
        System.out.println("BSOE en Barcelona obtiene " + bSOEBarcelona.calcularEscanos() + " escaños");
    }

    /**
     * Muestra los candidatos electos
     * @param bBMadrid
     * @param bBBarcelona
     * @param bSOEMadrid
     * @param bSOEBarcelona
     */
    private static void mostrarCandidatosElectos(ListaElectoral bBMadrid, ListaElectoral bBBarcelona,
            ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("5. CANDIDATOS ELECTOS POR PARTIDO Y CIRCUNSCRIPCIÓN");
        System.out.println("----------------------------------------------------------");
        mostrarListaElectos("BB", "Madrid", bBMadrid.getCandidatosElectos());
        mostrarListaElectos("BSOE", "Madrid", bSOEMadrid.getCandidatosElectos());
        mostrarListaElectos("BB", "Barcelona", bBBarcelona.getCandidatosElectos());
        mostrarListaElectos("BSOE", "Barcelona", bSOEBarcelona.getCandidatosElectos());
    }

    /**
     * Muestra la lista de los electos
     * @param partido
     * @param circunscripcion
     * @param electos
     */
    private static void mostrarListaElectos(String partido, String circunscripcion, List<Candidato> electos) {
        System.out.println("Candidatos electos de " + partido + " en " + circunscripcion + ":");
        if (electos.isEmpty()){
            System.out.println("No ha obtenido ningun escaño");
        } else{
            for(Candidato c: electos){
                System.out.println(c.getPosicion() + " " + c.getNombre());
            }
        }

        System.out.println();
    }

    /**
     * Va leyendo el numero de votos de cada partido en cada ciudad
     * @param partido
     * @param circunscripcion
     * @return
     */
    private static int leerNumeroVotos(String partido, String circunscripcion) {
        int numero = -1;
        boolean valido = false;
        do {
            System.out.print("Introduce los votos de " + partido + " en " + circunscripcion + "(>=0): ");
            try {
                numero = Integer.parseInt(sc.nextLine().trim());

                if (numero >= 0) {
                    valido = true;
                } else {
                    System.out.println("Error: el número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un entero válido dentro del rango de int.");
            }
        } while (!valido);
        return numero;
    }
}
