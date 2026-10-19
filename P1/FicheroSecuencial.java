/****
*
* Class Name: FicheroSecuencial
* Author/s name: Luis Pérez, Alejandro Rodríguez, Victor Tapiador
* Release/Creation date: 22/09/2026
* Class version: 1.0
* Class description: Gestor de acceso secuencial para la lectura y procesamiento de archivos de datos meteorológicos.
*
*/

package P1;

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
    // Fichero a leer en el sistema de archivos
    private Scanner scan;
    // Objeto Scanner para la lectura secuencial del fichero
    private String separator;
    // Cadena que actúa como separador o delimitador de campos

    /**
     * @param file
     * @param scan
     * @param separator
     * @throws FileNotFoundException
     */

    /**
    Method name: FicheroSecuencial
    *
    * Description of the Method: Constructor de la clase FicheroSecuencial. Inicializa el fichero, el scanner de lectura y el separador.
    * Calling arguments:
    *   - fileName (String): Nombre o ruta del fichero a abrir.
    *   - separator (String): Cadena utilizada como delimitador de campos.
    * Return value: Ninguno (Constructor).
    * Required Files: Requiere que el fichero especificado exista en el disco.
    * List of Checked Exceptions:
    *   - FileNotFoundException: Lanzada si el fichero especificado en fileName no es encontrado.
    *************/
    public FicheroSecuencial(String fileName, String separator) throws FileNotFoundException {
        this.file = new File(fileName);
        this.scan = new Scanner(file);
        this.separator = separator;
    }

    /**
    Method name: read
    *
    * Description of the Method: Lee la siguiente línea del fichero, la divide según el separador y pasa los datos al objeto genérico.
    * Calling arguments:
    *   - t (T): Objeto de un tipo que implemente LeerFicheroInt encargado de procesar los datos leídos.
    * Return value: void.
    * Required Files: Requiere que el fichero asociado esté abierto y tenga una línea disponible.
    * List of Checked Exceptions: Ninguna.
    *************/
    public void read(T t) {
        String[] data = scan.nextLine().split(separator);
        t.leerDatos(data);
    }

    /**
    Method name: skip
    *
    * Description of the Method: Omite o salta la línea actual del fichero de lectura.
    * Calling arguments: Ninguno.
    * Return value: void.
    * Required Files: Requiere que el fichero esté abierto para lectura.
    * List of Checked Exceptions: Ninguna.
    *************/
    public void skip() {
        scan.nextLine();
    }

    /**
    Method name: close
    *
    * Name of the original author: Estudiante
    * Description of the Method: Cierra el flujo de lectura del Scanner liberando el recurso.
    * Calling arguments: Ninguno.
    * Return value: void.
    * Required Files: Ninguno.
    * List of Checked Exceptions: Ninguna.
    *************/
    public void close() {
        scan.close();
    }

    /**
    Method name: isEndOfFile
    *
    * Description of the Method: Comprueba si se ha alcanzado el final del fichero.
    * Calling arguments: Ninguno.
    * Return value: boolean - Devuelve true si no existen más líneas por leer, false en caso contrario.
    * Required Files: Ninguno.
    * List of Checked Exceptions: Ninguna.
    *************/
    public boolean isEndOfFile() {
        return !scan.hasNextLine();
    }
}
