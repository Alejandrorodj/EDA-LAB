# Buzón de avisos – VT

Avisos de revisión de la P3 para **VT**. Cuando arregles uno, márcalo con `[x]` y apunta el commit.
Lo más nuevo, arriba. Estado del repositorio revisado: `origin/P3` = `887a748` (14-oct-2026).

## 14-oct-2026

### Cola de prioridad (`ParqueDeAtracciones.java`)
- [ ] `PriorityQueue cola = new PriorityQueue<Visitante>();` (l. 16) es un **tipo crudo**: falta `<Visitante>` a la izquierda. `javac -Xlint` avisa `[rawtypes]` y el enunciado lo prohíbe (sin casts ni `Object`). Debe ser `PriorityQueue<Visitante>` a los dos lados.
- [ ] `cola` se crea y no se usa.

### Documentación
- [ ] Sin comentario Javadoc de clase en `Constantes`, `ParqueDeAtracciones` y `Visitante`. Va **justo encima de `public class`**, no antes de `package`.
- [ ] `@author` solo con **iniciales + código de grupo** (nada de nombres: en P2 se pusieron los nombres completos).
- [ ] Los métodos solo tienen los comentarios automáticos de Eclipse (`@return the id`…), sin descripción; `getInicio`/`setInicio` (añadidos en `b47e6eb`) tienen el bloque vacío. Faltan los de `leerPorPantalla`, `generarVisitantes`, `compareTo` y `main`.
- [ ] Constantes y atributos sin `/** … */`.
- [ ] Al terminar, ejecutar `generar_javadoc.bat` y revisar errores y avisos (en P2 empezamos con 10 errores y 70 avisos). Los genéricos dentro de comentarios van como `{@code Queue<Visitante>}`.

### `Visitante` (constructor añadido en `b47e6eb`)
- [ ] El constructor recibe `inicio`, pero la hora de inicio no se sabe cuando el visitante llega (se conoce al montar). Mejor `Visitante(int id, int llegada, String pase)` y dar el inicio con `setInicio` al montar.

### Commits
- [ ] "jdad": mejor un mensaje que diga qué cambia.
