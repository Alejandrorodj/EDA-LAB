# Buzón de avisos – LP

Avisos de la P3 para **LP**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 17-oct-2026 (`origin/P3` = `566f07b` más los cambios sin subir).

## Pendiente
- [ ] **Hacer commit** de `Visitante.java` (compareTo terminado) y de `util/Constantes.java` (añadir la carpeta `P3/util/`; git ve `P3/Constantes.java` como borrado).
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
