# Buzón de avisos – VT

Avisos de la P3 para **VT**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (`origin/P3` = `2a8229f`).

## Diseño orientado a objetos (`ParqueDeAtracciones.java`)
- [x] *(18-oct: hecho con la clase `Simulacion`; `main` solo crea el objeto)* **Todo es `static`**: los atributos `N, E, F, L` (l. 13) y los métodos `leerPorPantalla` y `generarVisitantes`. Nunca se crea un objeto: son funciones sueltas que comparten variables globales. El enunciado penaliza alejarse de la orientación a objetos (en P2 pasó lo mismo con `Acciones`).
  - Problemas: solo puede haber una simulación; cualquier método toca `N, E, F, L` sin control; `generarVisitantes` usa `E` y `F` sin recibirlos (si se llama antes de leerlos, valen 0).
- [x] *(18-oct)* Pasar a una clase con **atributos de instancia** (sin `static`): `n, e, f, l` en minúscula, la cola de llegada (`Queue<Visitante>`), la cola de espera (`PriorityQueue<Visitante>`) y el reloj. Sus métodos (leer parámetros, generar visitantes, simular, mostrar) también sin `static`.
- [x] *(18-oct)* `main` es lo único `static`: solo crea el objeto y llama a sus métodos (como `JuegoDeCartas` al final de P2). Por ejemplo:
  ```java
  public static void main(String[] args) {
      Simulador simulador = new Simulador();
      simulador.leerParametros();
      simulador.ejecutar();
  }
  ```
- Coordinar con **AR**: cambia la forma de `leerPorPantalla` y `generarVisitantes`. Mejor hacerlo **antes** de escribir la simulación.

## Cola de prioridad (`ParqueDeAtracciones.java`)
- [x] *(18-oct: en `Simulacion` ya es `PriorityQueue<Visitante>`)* `PriorityQueue cola = new PriorityQueue<Visitante>();` (l. 17) es un **tipo crudo**: falta `<Visitante>` a la izquierda. `javac -Xlint` avisa `[rawtypes]` y el enunciado lo prohíbe (sin casts ni `Object`). Debe ser `PriorityQueue<Visitante>` a los dos lados.
- [x] *(18-oct, noche: ya se usa en la simulación)* `cola` se crea y no se usa (sigue así en `Simulacion`: se usará en `iniciarSimulacion`).

## Documentación
*(19-oct: hecha en `2a8229f` "Documentacion puesta.Todo correcto": javadoc de clase en las 4 clases, atributos, constantes y casi todos los métodos. Bien.)*
- [x] Javadoc de clase en las 4 clases, encima de `public class`.
- [x] Constantes y atributos con `/** */` (salvo lo de abajo).
- [x] `compareTo`, `prioridadPase` y `toString` con descripción, `@param`, `@return` y `@throws`. Ya no hay "(non-Javadoc)" ni `java.lang.Object`.
- [ ] **`generar_javadoc.bat` da 12 avisos** (no es "todo correcto"):
  - `Visitante`: los 8 getters/setters siguen con el comentario de Eclipse (`@return the inicio`, `@param inicio the inicio to set`, `@return id`…): falta la descripción y dos `@param` (`setLlegada`, `setId`) no dicen nada. Ponerlos en español con descripción.
  - `Constantes` y `ParqueDeAtracciones`: "use of default constructor, which does not provide a comment". Se quita con un constructor `private` vacío con su javadoc (además nadie debería hacer `new Constantes()`).
- [ ] `Simulacion`, l. 21-27: un solo javadoc para `n, e, f, l` con las erratas "standar" y "fastPAss"; en el HTML sale todo en una línea y repetido en los cuatro. Mejor un atributo por línea con su `/** */`.
- [ ] `@author LP, AR, VT`: falta el **código de grupo** (el enunciado pide iniciales **y** código de grupo).
- [ ] Tildes: unas clases las llevan ("más", "según") y otras no ("parametros", "simulacion", "atraccion", "numerico"). Unificar.

## Commits
- [ ] "jdad", "no message", "limpio", "falta doc": mejor un mensaje que diga qué cambia (por ejemplo "Javadoc de Visitante y Constantes").

## Hecho / pasado a otro buzón
- El aviso sobre el constructor de `Visitante` que recibe `inicio` (añadido en `b47e6eb`) pasa a **AR**, que se encarga de `Visitante` desde el 17-oct.
