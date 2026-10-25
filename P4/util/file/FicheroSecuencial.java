package P4.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lector secuencial de ficheros de texto: lee línea a línea, separa los campos
 * y se los pasa a un objeto que implemente.
 *
 * @param <T> Objeto generico
 *
 * @author LP, AR, VT -- Grupo C
 * @version 1.0 (24/10/2026)
 */
public class FicheroSecuencial<T extends LeerFicheroInt> {

    private File file; // fichero que se lee
    private Scanner scan; // lector del contenido del fichero
    private String separator; // separador de campos

    /**
     * Abre el fichero para leerlo.
     *
     * @param fileName  ruta del fichero
     * @param separator separador de campos
     * 
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
     * @param t Objeto generico
     */
    public void read(T t) {
        String[] data = scan.nextLine().split(separator);
        t.leerDatos(data);
    }

    /**
     * salta una linea del fichero
     */
    public void skip() {
        scan.nextLine();
    }

    /**
     * Cierra el fichero
     */
    public void close() {
        scan.close();
    }

    /**
     * Indica si ya no quedan líneas por leer.
     *
     * @return true si se ha llegado al final del fichero
     */
    public boolean isEndOfFile() {
        return !scan.hasNextLine();
    }
}
