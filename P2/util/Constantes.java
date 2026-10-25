package P2.util;

/**
 * Constantes del programa: ruta y separador del fichero de acciones y
 * enumerado con los tipos de carta.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (04/10/2026)
 */
public class Constantes {

    public static final String RUTA_FICHERO_ACCIONES = ".\\P2\\archivos\\acciones.csv"; // ruta del fichero de acciones
    public static final String SEPARADOR_CSV = ","; // separador de campos del fichero

    /**
     * Tipos de carta del juego, en el orden en que se meten en el mazo de robo
     */
    public static enum CARTA {
        GOLPE_CRITICO,
        RAYO_CONGELANTE,
        BARRERA_DE_HIELO,
        POCION_DE_VIDA,
        CONTRAHECHIZO,
        ESCUDO_MAGICO,
        BOLA_DE_FUEGO
    }
}
