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

    /**
     * n: numero de lotes
     * e: numero de visitantes standar
     * f: numero de fastPAss
     * l: tiempo entre lotes
     */ 
    private int n, e, f, l;

    /** Siguiente identificador que se asignara a un visitante. */
    private int idVisitante;

    /** Cola con prioridad que determina el orden de acceso a la atraccion. */
    private PriorityQueue<Visitante> cola;

    /** Cola inicial que contiene a los visitantes pendientes de llegar a la atraccion. */
    private Queue<Visitante> colaEspera;

    /** Instante actual de la simulacion. */
    private int reloj;

    /** Visitante que ha acumulado la mayor espera durante la simulacion. */
    private Visitante visitanteMasEspera;

    /** Mayor tiempo de espera registrado hasta el momento. */
    private int esperaMaxima;

    /**
     * Inicializa el estado de la simulacion, solicita los parametros de entrada
     * y genera los lotes de visitantes.
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
     * Ejecuta los recorridos hasta que no quedan visitantes pendientes ni en la
     * cola de acceso. Al finalizar, muestra el visitante que mas ha esperado.
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
     * Pasa a la cola prioritaria a los visitantes cuya llegada ya se ha producido
     * en el instante actual de la simulacion.
     */
    private void pasarALaCola() {
        while (!colaEspera.isEmpty() && colaEspera.peek().getLlegada() <= reloj) {
            cola.add(colaEspera.poll());
        }
    }

    /**
     * Realiza un recorrido con hasta el numero maximo de visitantes permitido,
     * registra su instante de inicio y actualiza el mayor tiempo de espera.
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
     * Genera los lotes de visitantes a partir de los parametros introducidos.
     * Cada lote posterior llega despues del intervalo indicado por {@code l}.
     */
    public void generarLote() {
        int tiempoLlegada = 0;
        for (int i = 0; i < n; i++) {

            generarVisitantes(tiempoLlegada);

            tiempoLlegada += l;
        }

    }

    /**
     * Lee por teclado el numero de lotes, los visitantes de cada tipo y el tiempo
     * entre lotes, y solicita de nuevo los datos si alguno queda fuera de rango.
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
     * Genera los visitantes de un lote y los añade a la cola inicial en el orden
     * Standard, Fast Pass y VIP, asignando un identificador a cada visitante.
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
