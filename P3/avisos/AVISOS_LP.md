# Buzón de avisos – LP

Avisos de la P3 para **LP**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (`origin/P3` = `2a8229f`).

## Pendiente
- [x] *(19-oct: subido en `48fd766`)* Hacer commit del arreglo del `compareTo` (`Visitante.java`).
- [x] *(18-oct: arreglado en local, falta commit; probado `v.compareTo(v) == 0` y orden correcto)* **AR tocó tu `compareTo`** (`c34d14b`): cambió el segundo `if` del id por `else`, y ahora `v.compareTo(v) == 1`. Está en el buzón de AR para que lo deshaga; revísalo cuando lo haga. El orden de la cola sigue bien.
- [x] Commit de `compareTo` y `Constantes` en `util/` (`06e984c`).
- [ ] Mensajes de commit que digan qué cambia ("aaa", "tarea" no lo dicen). Por ejemplo: "compareTo: prioridad por pase, llegada e id".
- Opcional: en `compareTo`, el último `else if (this.llegada == v.getLlegada())` puede ser un `else`.

## Hecho
### Criterio de prioridad (`Visitante.compareTo` y `prioridadPase`)
- [x] El `compareTo` antiguo no cumplía el contrato (VIP contra VIP daba `-1` en los dos sentidos, Fast daba `0` contra todos…) y no desempataba por llegada ni id. Rehecho con `if` y `prioridadPase`.
- [x] `resultado` empezaba en 99 (y después lanzaba "Pase no reconocido" al comparar un visitante consigo mismo). Ahora empieza en 0.
- [x] `prioridadPase` devolvía `-99` con un pase desconocido (iba delante de los VIP) y luego no compilaba (`return IllegalArgumentException`). Ahora lanza `throw new IllegalArgumentException("Pase no reconocido: " + pase)`.
- [x] **Probado (17-oct):** simétrico en todas las parejas, `v.compareTo(v) == 0`, orden del caso base `6V 12V 4F 5F 10F 11F 1S 2S 3S 7S 8S 9S` y pase inventado → excepción.

### Constantes
- [x] `DURACION_ATRACCION`, `PERSONAS_POR_ATRACCION` y `VISITANTE_VIP_PASS` eran `private`; ya son `public`.
- [x] `Constantes` movida a `P3/util/` (paquete `P3.util`, imports actualizados).
