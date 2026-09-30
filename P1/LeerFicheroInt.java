/****
*
* Class Name: LeerFicheroInt
* Author/s name: Luis Pérez, Alejandro Rodríguez, Victor Tapiador
* Release/Creation date: 22/09/2026
* Class version: 1.0
* Class description: Interfaz que define el contrato para procesar los datos extraídos en la lectura de un fichero.
*
*/

package P1;

/**
 * 
 * LeerFicheroInt
 */
public interface LeerFicheroInt {

    /**
    Method name: leerDatos
    *
    * Description of the Method: Método abstracto que debe implementar la clase concreta para procesar o asignar los datos leídos del fichero.
    * Calling arguments:
    *   - data (String[]): Array de cadenas de texto con los valores/campos extraídos de una línea del fichero.
    * Return value: void.
    * Required Files: Ninguno.
    * List of Checked Exceptions: Ninguna.
    *************/
    void leerDatos(String[] data);
}
