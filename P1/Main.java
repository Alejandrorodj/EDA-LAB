/****
*
* Class Name: Main
* Author/s name: Luis Pérez, Alejandro Rodríguez, Victor Tapiador
* Release/Creation date: 22/09/2026
* Class version: 1.0
* Class description: Clase principal que contiene el punto de entrada de la aplicación para procesar los datos de satélite desde un fichero secuencial.
*
*/

package P1;

import java.io.FileNotFoundException;

public class Main {

    /**
    Method name: main
    *
    * Description of the Method: Punto de entrada principal del programa. Instancia un FicheroSecuencial, lee objetos Satelite, omite el encabezado y filtra aquellos con un número de órbitas mayor a 10.
    * Calling arguments:
    *   - args (String[]): Argumentos introducidos por la línea de comandos.
    * Return value: void.
    * Required Files: Requiere el fichero ".\\P1\\weather.csv" en la ruta especificada para su lectura.
    * List of Checked Exceptions: Ninguna
    *************/
    public static void main(String[] args) {
        try {
            FicheroSecuencial<Satelite> sf = new FicheroSecuencial<Satelite>(".\\P1\\weather.csv", ",");
            sf.skip();
            while (!sf.isEndOfFile()) {
                Satelite sat = new Satelite();
                sf.read(sat);
                if (sat.getNumOrbitas() > 10) {
                    System.out.println(sat);
                }
            }
            sf.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }
}
