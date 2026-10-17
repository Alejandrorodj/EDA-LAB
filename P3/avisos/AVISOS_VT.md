# Buzón de avisos – VT

Avisos de la P3 para **VT**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 17-oct-2026 (`origin/P3` = `566f07b` más los cambios sin subir).

## Diseño orientado a objetos (`ParqueDeAtracciones.java`)
- [ ] **Todo es `static`**: los atributos `N, E, F, L` (l. 23) y los métodos `leerPorPantalla` y `generarVisitantes`. Nunca se crea un objeto: son funciones sueltas que comparten variables globales. El enunciado penaliza alejarse de la orientación a objetos (en P2 pasó lo mismo con `Acciones`).
  - Problemas: solo puede haber una simulación; cualquier método toca `N, E, F, L` sin control; `generarVisitantes` usa `E` y `F` sin recibirlos (si se llama antes de leerlos, valen 0).
- [ ] Pasar a una clase con **atributos de instancia** (sin `static`): `n, e, f, l` en minúscula, la cola de llegada (`Queue<Visitante>`), la cola de espera (`PriorityQueue<Visitante>`) y el reloj. Sus métodos (leer parámetros, generar visitantes, simular, mostrar) también sin `static`.
- [ ] `main` es lo único `static`: solo crea el objeto y llama a sus métodos (como `JuegoDeCartas` al final de P2). Por ejemplo:
  ```java
  public static void main(String[] args) {
      Simulador simulador = new Simulador();
      simulador.leerParametros();
      simulador.ejecutar();
  }
  ```
- Coordinar con **AR**: cambia la forma de `leerPorPantalla` y `generarVisitantes`. Mejor hacerlo **antes** de escribir la simulación.

## Cola de prioridad (`ParqueDeAtracciones.java`)
- [ ] `PriorityQueue cola = new PriorityQueue<Visitante>();` (l. 27) es un **tipo crudo**: falta `<Visitante>` a la izquierda. `javac -Xlint` avisa `[rawtypes]` y el enunciado lo prohíbe (sin casts ni `Object`). Debe ser `PriorityQueue<Visitante>` a los dos lados.
- [ ] `cola` se crea y no se usa.

## Documentación
- [ ] Sin comentario Javadoc de clase en `Constantes`, `ParqueDeAtracciones` y `Visitante`. Va **justo encima de `public class`**, no antes de `package`.
- [ ] `@author` solo con **iniciales + código de grupo** (nada de nombres: en P2 se pusieron los nombres completos).
- [ ] Los métodos solo tienen los comentarios automáticos de Eclipse (`@return the id`…), sin descripción; `getInicio`/`setInicio` tienen el bloque vacío y `compareTo` el "(non-Javadoc)". Faltan los de `leerPorPantalla`, `generarVisitantes` y `main`.
- [ ] Constantes y atributos sin `/** … */`.
- [ ] Al terminar, ejecutar `generar_javadoc.bat` y revisar errores y avisos (en P2 empezamos con 10 errores y 70 avisos). Los genéricos dentro de comentarios van como `{@code Queue<Visitante>}`.

## Commits
- [ ] "jdad": mejor un mensaje que diga qué cambia.

## Hecho / pasado a otro buzón
- El aviso sobre el constructor de `Visitante` que recibe `inicio` (añadido en `b47e6eb`) pasa a **AR**, que se encarga de `Visitante` desde el 17-oct.
