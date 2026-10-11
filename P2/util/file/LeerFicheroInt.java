package P2.util.file;

/**
 * Interfaz para las clases que se rellenan con los campos de una línea de un
 * fichero de texto.
 *
 * @author LP, AR, VT
 * @version 1.0 (04/10/2026)
 */
public interface LeerFicheroInt {
    /**
     * Rellena el objeto con los datos de una línea del fichero.
     * <p>
     * {@link FicheroSecuencial#read(LeerFicheroInt)} lee cada línea, la separa
     * en campos con el separador indicado y llama a este método para que el
     * objeto guarde esos valores. Cada clase que implemente la interfaz decide
     * cómo interpretar los campos.
     *
     * @param data campos de la línea, ya separados y sin interpretar (texto tal
     *             cual aparece en el fichero)
     */
    void leerDatos(String[] data);
}
