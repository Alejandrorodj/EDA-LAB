package P3;

import java.util.InputMismatchException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import P3.model.Visitante;
import P3.util.Constantes;

/**
 * Gestiona los parametros, las colas de visitantes y la simulacion
 * de los recorridos de la atraccion.
 *
 * @author LP, AR, VT
 * @version 1.0 (19/10/2026)
 */
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

        System.out.println("El visitante con el ID que mas ha esperado es: ID = " + visitanteMasEspera.getId() + " | Pase: "
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

            if (espera > esperaMaxima
                    || (espera == esperaMaxima
                        && v.getLlegada() < visitanteMasEspera.getLlegada())
                    || (espera == esperaMaxima
                        && v.getLlegada() == visitanteMasEspera.getLlegada()
                        && v.getId() < visitanteMasEspera.getId())) {

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

        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introduce el número de lotes de visitantes: ");
                n = sc.nextInt();

                if (n > 0) {
                    correcto = true;
                } else {
                    System.out.println("El número debe ser mayor que 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero.");
                sc.next();
            }
        }
        System.out.println("Has introducido " + n);

        correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introduce los visitantes Standard: ");
                e = sc.nextInt();

                if (e >= 0) {
                    correcto = true;
                } else {
                    System.out.println("El número debe ser igual o mayor que 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero.");
                sc.next();
            }
        }
        System.out.println("Has introducido " + e);

        correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introduce los visitantes Fast Pass: ");
                f = sc.nextInt();

                if (f >= 0) {
                    correcto = true;
                } else {
                    System.out.println("El número debe ser igual o mayor que 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero.");
                sc.next();
            }
        }
        System.out.println("Has introducido " + f);

        correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introduce el tiempo entre lotes: ");
                l = sc.nextInt();

                if (l >= 0) {
                    correcto = true;
                } else {
                    System.out.println("El número debe ser igual o mayor que 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero.");
                sc.next();
            }
        }
        System.out.println("Has introducido " + l);

        sc.close();
    }

    /**
     * Genera los visitantes de un lote y los añade a la cola inicial.
     *
     * @param llegada instante de llegada de los visitantes del lote
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
