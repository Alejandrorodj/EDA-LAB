package P2.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * FicheroSecuencial
 * 
 * @param <T>
 */
public class FicheroSecuencial<T extends LeerFicheroInt> {

    private File file;
    private Scanner scan;
    private String separator;

    /**
     * @param file
     * @param scan
     * @param separator
     * @throws FileNotFoundException
     */
    public FicheroSecuencial(String fileName, String separator) throws FileNotFoundException {
        this.file = new File(fileName);
        this.scan = new Scanner(file);
        this.separator = separator;
    }

    public void read(T t) {
        String[] data = scan.nextLine().split(separator);
        t.leerDatos(data);
    }

    public void skip() {
        scan.nextLine();
    }

    public void close() {
        scan.close();
    }

    public boolean isEndOfFile() {
        return !scan.hasNextLine();
    }
}
