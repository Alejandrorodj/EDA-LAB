package P1;

/**
 * Interfaz para las clases que se rellenan con los campos de una linea de un
 * fichero de texto.
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (22/09/2026)
 */
public interface LeerFicheroInt {

    /**
     * Rellena el objeto con los campos de una linea del fichero
     *
     * @param data campos de la linea
     */
    void leerDatos(String[] data);
}
