package P2.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/****
*
* Class Name: FicheroSecuencial
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Clase genérica para la lectura secuencial de ficheros de texto.
*                    Permite procesar el contenido de un archivo línea a línea utilizando
*                    un delimitador especificado para inicializar objetos que implementen
*                    la interfaz LeerFicheroInt.
*
* @param <T> Tipo genérico que debe implementar la interfaz LeerFicheroInt.
*
*/
public class FicheroSecuencial<T extends LeerFicheroInt> {

    // Objeto File que representa el archivo físico a leer
    private File file;

    // Escáner utilizado para la lectura del flujo de datos del fichero
    private Scanner scan;

    // Cadena de texto utilizada como delimitador o separador de campos
    private String separator;

    /**
     * @param file
     * @param scan
     * @param separator
     * @throws FileNotFoundException
     */

    /**
    * Method name: FicheroSecuencial
    *
    * Description of the Method: Constructor que inicializa el fichero a partir de su ruta,
    *                            abre el escáner de lectura y establece el separador de campos.
    * Calling arguments: 
    *   - String fileName: Ruta o nombre del archivo que se va a abrir.
    *   - String separator: Carácter o cadena utilizado como delimitador de campos.
    *
    * Return value: Instancia de la clase FicheroSecuencial.
    * Required Files: El fichero especificado en fileName debe existir en el sistema.
    *
    * List of Checked Exceptions: 
    *   - FileNotFoundException: Se lanza si no se encuentra el archivo en la ruta especificada.
    *************/
    public FicheroSecuencial(String fileName, String separator) throws FileNotFoundException {
        this.file = new File(fileName);
        this.scan = new Scanner(file);
        this.separator = separator;
    }

    /**
    * Method name: read
    *
    * Description of the Method: Lee la siguiente línea del fichero, la divide en campos según
    *                            el separador y pasa dichos datos al objeto suministrado.
    * Calling arguments: 
    *   - T t: Objeto genérico que implementa LeerFicheroInt donde se cargarán los datos leídos.
    *
    * Return value: void.
    * Required Files: El fichero debe estar previamente abierto por el constructor.
    *
    * List of Checked Exceptions: Ninguno
    *************/
    public void read(T t) {
        String[] data = scan.nextLine().split(separator);
        t.leerDatos(data);
    }

    /**
    * Method name: skip
    *
    * Description of the Method: Omite o salta la línea actual del fichero sin procesar sus datos.
    * Calling arguments: Ninguno
    *
    * Return value: void.
    * Required Files: El fichero debe estar abierto y contener líneas pendientes de lectura.
    *
    * List of Checked Exceptions: Ninguno
    *************/
    public void skip() {
        scan.nextLine();
    }

    /**
    * Method name: close
    *
    * Description of the Method: Cierra el objeto Scanner liberando los recursos asociados al fichero.
    * Calling arguments: Ninguno
    *
    * Return value: void.
    * Required Files: Ninguno
    *
    * List of Checked Exceptions: Ninguno
    *************/
    public void close() {
        scan.close();
    }

    /**
    * Method name: isEndOfFile
    *
    * Description of the Method: Comprueba si se ha alcanzado el final del fichero analizando
    *                            si quedan más líneas por leer.
    * Calling arguments: Ninguno
    *
    * Return value: boolean - true si no quedan más líneas por leer; false en caso contrario.
    * Required Files: Ninguno
    *
    * List of Checked Exceptions: Ninguno
    *************/
    public boolean isEndOfFile() {
        return !scan.hasNextLine();
    }
}
