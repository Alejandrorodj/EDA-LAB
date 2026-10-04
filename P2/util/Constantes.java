/****
*
* Class Name: Constantes
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase que centraliza las constantes del sistema, incluyendo la ruta
*                    de los ficheros de datos, el separador utilizado en los archivos CSV
*                    y el tipo enumerado CARTA para definir los tipos de cartas disponibles.
*
*/

package P2.util;

public class Constantes {

    // Ruta fichero acciones
    public static final String RUTA_FICHERO_ACCIONES = ".\\P2\\archivos\\acciones.csv";

    // Separador
    public static final String SEPARADOR_CSV = ",";

    // carta
    public static enum CARTA {
        GOLPE_CRITICO, RAYO_CONGELANTE, BARRERA_DE_HIELO, POCION_DE_VIDA,
        CONTRAHECHIZO, ESCUDO_MAGICO, BOLA_DE_FUEGO
    }
}
