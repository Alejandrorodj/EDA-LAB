/****
*
* Class Name: LeerFicheroInt
* Author/s name: Luis Perez, Alejandro Rodriguez, Victor Tapiador
* Release/Creation date: 04/10/2026
* Class version: 1.0
* Class description: Interfaz que define el contrato para las clases que procesan
*                    e inicializan sus atributos a partir de un arreglo de datos
*                    leídos de un fichero de texto.
*
*/

package P2.util.file;

public interface LeerFicheroInt {

    /**
    * Method name: leerDatos
    *
    * Description of the Method: Asigna los valores del arreglo de datos pasado como argumento
    *                            a los atributos correspondientes de la clase que implemente la interfaz.
    * Calling arguments: 
    *   - String[] data: Arreglo de cadenas de caracteres que contiene los campos extraídos del fichero.
    *
    * Return value: void.
    * Required Files: Ninguno
    *
    * List of Checked Exceptions: Ninguno
    *************/
    void leerDatos(String[] data);
}
