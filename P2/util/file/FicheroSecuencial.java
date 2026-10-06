package P2.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lector secuencial de ficheros de texto: lee línea a línea, separa los campos
 * y se los pasa a un objeto que implemente.
 *
 * @param <T> tipo de objeto que se rellena con cada línea
 *
 * @author LP, AR, VT (código de equipo: TODO)
 * @version 1.0 (04/10/2026)
 */
public class FicheroSecuencial<T extends LeerFicheroInt> {

    /** Fichero que se lee. */
    private File file;

    /** Lector del contenido del fichero. */
    private Scanner scan;

    /** Separador de campos. */
    private String separator;

    /**
     * Abre el fichero para leerlo.
     *
     * @param fileName ruta del fichero
     * @param separator separador de campos
     * @throws FileNotFoundException si el fichero no existe
     */
    public FicheroSecuencial(String fileName, String separator) throws FileNotFoundException {
        this.file = new File(fileName);
        this.scan = new Scanner(file);
        this.separator = separator;
    }

    /**
     * Lee la siguiente línea, la separa en campos y se los pasa al objeto.
     *
     * @param t objeto que se rellena con los campos de la línea
     */
    public void read(T t) {
        String[] data = scan.nextLine().split(separator);
        t.leerDatos(data);
    }

    /** Salta la siguiente línea sin procesarla (por ejemplo, una cabecera). */
    public void skip() {
        scan.nextLine();
    }

    /** Cierra el fichero. */
    public void close() {
        scan.close();
    }

    /**
     * Indica si ya no quedan líneas por leer.
     *
     * @return {@code true} si se ha llegado al final del fichero
     */
    public boolean isEndOfFile() {
        return !scan.hasNextLine();
    }
}
