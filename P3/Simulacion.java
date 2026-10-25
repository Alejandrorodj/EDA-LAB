package P3;

import java.util.InputMismatchException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import P3.model.Visitante;
import P3.util.Constantes;

/**
 * Clase que gestiona los parametros, las colas de visitantes y los recorridos
 * de la atraccion.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (19/10/2026)
 */
public class Simulacion {

    private int n, e, f, l; // lotes, standard por lote, fast pass por lote y tiempo entre lotes
    private int idVisitante; // id que se le da al siguiente visitante
    private PriorityQueue<Visitante> cola; // cola de acceso a la atraccion (por pase, llegada e id)
    private Queue<Visitante> colaEspera; // todos los visitantes en orden de llegada
    private int reloj; // tiempo actual de la simulacion
    private Visitante visitanteMasEspera; // visitante que mas ha esperado
    private int esperaMaxima; // mayor espera hasta ahora

    /**
     * Inicia la simulacion: pide los parametros y genera los lotes de visitantes
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
     * Hace recorridos hasta que las dos colas estan vacias y al final muestra el
     * visitante que mas ha esperado
     */
    public void iniciarSimulacion() {
        while (!colaEspera.isEmpty() || !cola.isEmpty()) {

            pasarALaCola();

            simularAtraccion();
            reloj += Constantes.DURACION_ATRACCION;
        }

        System.out.println(
                "El visitante con el ID que mas ha esperado es: ID = " + visitanteMasEspera.getId() + " | Pase: "
                        + visitanteMasEspera.getPase() + " | Llegada: " + visitanteMasEspera.getLlegada()
                        + " | Espera: " + esperaMaxima);
    }

    /**
     * Pasa a la cola de acceso los visitantes que ya han llegado
     */
    private void pasarALaCola() {
        while (!colaEspera.isEmpty() && colaEspera.peek().getLlegada() <= reloj) {
            cola.add(colaEspera.poll());
        }
    }

    /**
     * Hace un recorrido con hasta 5 visitantes, guarda su hora de inicio y
     * actualiza el que mas ha esperado
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
     * Genera los n lotes de visitantes, cada uno l unidades de tiempo despues
     * del anterior
     */
    public void generarLote() {
        int tiempoLlegada = 0;
        for (int i = 0; i < n; i++) {

            generarVisitantes(tiempoLlegada);

            tiempoLlegada += l;
        }

    }

    /**
     * Pide por teclado n, e, f y l, y vuelve a pedir el dato si no es valido
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
     * Genera un lote (e Standard, f Fast Pass y 1 VIP, en ese orden) y lo mete en
     * la cola de espera con ids seguidos
     *
     * @param llegada tiempo de llegada del lote
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
