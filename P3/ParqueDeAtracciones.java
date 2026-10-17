package P3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import P3.model.Visitante;
import P3.util.Constantes;

public class ParqueDeAtracciones {

    private static int N, E, F, L;

    public static void main(String[] args) {

        PriorityQueue cola = new PriorityQueue<Visitante>();

        leerPorPantalla();

        List<Visitante> visitantes = generarVisitantes(0);

        for (Visitante v : visitantes) {
            System.out.println("ID: " + v.getId() + " | Pase: " + v.getPase()   + " | Llegada: " + v.getLlegada());
        }
    }

    public static void leerPorPantalla() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los número de lotes de visitantes: ");
        N = sc.nextInt();
        System.out.println("Has introducido " + N);

        System.out.println("Introduce los visitantes Standard: ");
        E = sc.nextInt();
        System.out.println("Has introducido " + E);

        System.out.println("Introduce los visitantes Fast Pass: ");
        F = sc.nextInt();
        System.out.println("Has introducido " + F);

        System.out.println("Introduce el tiempo entre lotes: ");
        L = sc.nextInt();
        System.out.println("Has introducido " + L);

        while (N <= 0 || E < 0 || F < 0 || L < 0) {

            System.out.println("Introduzca de nuevo el número de lotes de visitantes: ");
            N = sc.nextInt();
            System.out.println("Has introducido " + N);

            System.out.println("Introduzca de nuevo los visitantes Standard: ");
            E = sc.nextInt();
            System.out.println("Has introducido " + E);

            System.out.println("Introduzca de nuevo los visitantes Fast Pass: ");
            F = sc.nextInt();
            System.out.println("Has introducido " + F);

            System.out.println("Introduzca de nuevo el tiempo entre lotes: ");
            L = sc.nextInt();
            System.out.println("Has introducido " + L);
        }

        sc.close();
    }

    public static List<Visitante> generarVisitantes(int tiempo) {
        int id = 1;
        List<Visitante> loteVisitantes = new ArrayList<Visitante>();

        for (int i = 0; i < N; i++) {

            int contadorVisitantes = 0;
            tiempo = i * L;

            while (contadorVisitantes < E) {
                Visitante visitante = new Visitante(id, tiempo, Constantes.STANDARD);
                loteVisitantes.add(visitante);
                contadorVisitantes++;
                id++;
            }

            contadorVisitantes = 0;
            while (contadorVisitantes < F) {
                Visitante visitante = new Visitante(id, tiempo, Constantes.FAST_PASS);
                loteVisitantes.add(visitante);
                id++;
                contadorVisitantes++;
            }

            Visitante visitante = new Visitante(id, tiempo, Constantes.VIP_PASS);
            loteVisitantes.add(visitante);
            id++;

        }

        return loteVisitantes;
    }
}