package P3.util;

/**
 * Define las constantes utilizadas en la simulacion de la atraccion,
 * como los tipos de pase, la duracion y la capacidad de los recorridos.
 *
 * @author LP, AR, VT
 * @version 1.0 (19/10/2026)
 */
public class Constantes {
    /** Nombre del pase VIP, que tiene la prioridad más alta. */
    public static final String VIP_PASS = "Vip Pass";

    /** Nombre del pase Fast Pass, que tiene prioridad intermedia. */
    public static final String FAST_PASS = "Fast Pass";

    /** Nombre del pase Standard, que tiene la prioridad más baja. */
    public static final String STANDARD = "Standard";

    /** Duracion de cada recorrido de la atraccion, en unidades de tiempo. */
    public static final int DURACION_ATRACCION = 300;

    /** Numero maximo de visitantes que pueden realizar cada recorrido. */
    public static final int PERSONAS_POR_ATRACCION = 5;

    /** Numero de visitantes VIP que se genera en cada lote. */
    public static final int VISITANTE_VIP_PASS = 1;
}

