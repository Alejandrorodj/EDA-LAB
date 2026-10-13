package P3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import P3.model.Visitante;

public class ParqueDeAtracciones {
    
    private static int N, E, F, L;

    public static void main(String[] args) {

        PriorityQueue cola= new PriorityQueue<Visitante>();
        
    

        leerPorPantalla();
    }

    public static void leerPorPantalla() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número de visitantes: ");
        N = sc.nextInt();

        System.out.println("Has introducido" + N );

        do {
            System.out.println("Introduce E:");
            E = sc.nextInt();
        
            System.out.println("Introduce F:");
            F = sc.nextInt();
        
            if (E + F + 1 != N) {
                System.out.println("Error: E + F + 1 debe ser igual a N");
            }
        
        } while (E + F + 1 != N);
    }

    public static List generarVisitantes() {
        int id = 1;
        int tiempo;
        List<Visitante> LoteVisitantes = new ArrayList<Visitante>();

        while(id < E) {
            Visitante visitante = new visitante(id,Constantes.STANDARD);
            LoteVisitantes.add(visitante);
            id++;
        }

        while(id<F) {
            Visitante visitante = new visitante(id,Constantes.FAST_PASS);
            LoteVisitantes.add(visitante);
            id++;
        }

        Visitante visitante = new visitante(id,Constantes.VIP_PASS);
        LoteVisitantes.add(visitante);


        return LoteVisitantes;
    }
}
