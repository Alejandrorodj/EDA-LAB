package P3;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import P3.model.Visitante;
import P3.util.Constantes;

public class Simulacion {

    // n: numero de lotes
    // e: numero de visitantes standar
    // f: numero de fastPAss
    // l: tiempo entre lotes
    private int n, e, f, l;

    private int idVisitante; // Id de los visitantes de la sumulacion

    private PriorityQueue<Visitante> cola; // Cola con prioridad de la atraccion
    private Queue<Visitante> colaEspera; // Cola de espera

    private int reloj; // Simula el reloj de la sumulacion
    private Visitante visitanteMasEspera; // el visitante que más ha esperado hasta ahora
    private int esperaMaxima; // Teimpo de espera maxima

    /**
     * Constructor vacio, pide datos y geenra visitantes
     */
    public Simulacion() {
        idVisitante = 1;
        reloj = 0;
        esperaMaxima = -1;
        cola = new PriorityQueue<Visitante>();
        colaEspera = new ArrayDeque<>();
        leerPorPantalla();
        generarLote();
    }

    /**
     * 
     */
    public void iniciarSimulacion() {
        while (!colaEspera.isEmpty() || !cola.isEmpty()) {

            pasarALaCola();

            simularAtraccion();
            reloj += Constantes.DURACION_ATRACCION;
        }

        System.out.println("El visitante que mas a esperado es: " + visitanteMasEspera.getId() + " | Pase: "
                + visitanteMasEspera.getPase() + " | Espera: " + esperaMaxima);
    }

    /**
     * Pasa de la cola de espera a la cola de la atracion cuando la unidad de tiempo
     * llega a x valor que es la entrada del visitante
     */
    private void pasarALaCola() {
        while (!colaEspera.isEmpty() && colaEspera.peek().getLlegada() <= reloj) {
            cola.add(colaEspera.poll());
        }
    }

    /**
     * Simula la atracion
     */
    private void simularAtraccion() {
        System.out.println("Recorrido en el tiempo: " + reloj);
        int cont = 0;

        while (cont < Constantes.PERSONAS_POR_ATRACCION && !cola.isEmpty()) {

            Visitante v = cola.poll();
            v.setInicio(reloj);
            System.out.println("ID: " + v.getId() + " | Pase: " + v.getPase() + " | Llegada: " + v.getLlegada());

            int espera = reloj - v.getLlegada();

            if (espera > esperaMaxima) {
                visitanteMasEspera = v;
                esperaMaxima = espera;
            }

            cont++;
        }
    }

    /**
     * Generamos el lote de visitantes en funcion de los parametros de entrada
     * 
     */
    public void generarLote() {
        int tiempoLlegada = 0;
        for (int i = 0; i < n; i++) {

            generarVisitantes(tiempoLlegada);

            tiempoLlegada += l;
        }

    }

    /**
     * Leer por teclado los datos
     */
    public void leerPorPantalla() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce los número de lotes de visitantes: ");
        n = sc.nextInt();
        System.out.println("Has introducido " + n);

        System.out.print("Introduce los visitantes Standard: ");
        e = sc.nextInt();
        System.out.println("Has introducido " + e);

        System.out.print("Introduce los visitantes Fast Pass: ");
        f = sc.nextInt();
        System.out.println("Has introducido " + f);

        System.out.print("Introduce el tiempo entre lotes: ");
        l = sc.nextInt();
        System.out.println("Has introducido " + l);

        while (n <= 0 || e < 0 || f < 0 || l < 0) {

            System.out.print("Introduzca de nuevo el número de lotes de visitantes: ");
            n = sc.nextInt();
            System.out.println("Has introducido " + n);

            System.out.print("Introduzca de nuevo los visitantes Standard: ");
            e = sc.nextInt();
            System.out.println("Has introducido " + e);

            System.out.print("Introduzca de nuevo los visitantes Fast Pass: ");
            f = sc.nextInt();
            System.out.println("Has introducido " + f);

            System.out.print("Introduzca de nuevo el tiempo entre lotes: ");
            l = sc.nextInt();
            System.out.println("Has introducido " + l);
        }

        sc.close();
    }

    /**
     * Generar visitantes
     * 
     * @param tiempo
     * @return cola de visitantes ordenados standard-fastPass-VIP
     */
    private void generarVisitantes(int llegada) {

        int contadorVisitantes = 0;

        while (contadorVisitantes < e) {
            Visitante visitante = new Visitante(idVisitante, llegada, Constantes.STANDARD);
            colaEspera.add(visitante);
            contadorVisitantes++;
            idVisitante++;
        }

        contadorVisitantes = 0;
        while (contadorVisitantes < f) {
            Visitante visitante = new Visitante(idVisitante, llegada, Constantes.FAST_PASS);
            colaEspera.add(visitante);
            idVisitante++;
            contadorVisitantes++;
        }

        Visitante visitante = new Visitante(idVisitante, llegada, Constantes.VIP_PASS);
        colaEspera.add(visitante);
        idVisitante++;

    }

}
