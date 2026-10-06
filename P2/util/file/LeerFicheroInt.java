package P2.util.file;

/**
 * Interfaz para las clases que se rellenan con los campos de una línea de un
 * fichero de texto.
 *
 * @author LP, AR, VT (código de equipo: TODO)
 * @version 1.0 (04/10/2026)
 */
public interface LeerFicheroInt {

    /**
     * Rellena el objeto con los campos de una línea.
     *
     * @param data campos de la línea
     */
    void leerDatos(String[] data);
}
