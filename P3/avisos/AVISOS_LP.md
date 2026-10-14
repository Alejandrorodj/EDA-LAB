# Buzón de avisos – LP

Avisos de revisión de la P3 para **LP**. Cuando arregles uno, márcalo con `[x]` y apunta el commit.
Lo más nuevo, arriba. Estado del repositorio revisado: `origin/P3` = `887a748` (14-oct-2026).

## 14-oct-2026

### Constantes (`Constantes.java`, añadido en `9f12e22`)
- [ ] `DURACION_ATRACCION`, `PERSONAS_POR_ATRACCION` y `VISITANTE_VIP_PASS` son **`private`** (l. 7-9): ninguna otra clase puede usarlas. Pasarlas a `public static final`.

### Criterio de prioridad (`Visitante.compareTo`)
- [ ] **No cumple el contrato de `compareTo`**: VIP contra VIP devuelve `-1` en los dos sentidos; Fast devuelve `0` contra todos (empata con VIP y con Standard); Standard contra Standard devuelve `1` en los dos sentidos. `PriorityQueue` saca entonces los elementos en orden imprevisible.
  - Probado con los 12 visitantes del caso base (todos a la vez): sale `12V 6V 11F 10F 7S 3S 9S 1S 5F 4F 2S 8S`; debería ser `6V 12V 4F 5F 10F 11F 1S 2S 3S 7S 8S 9S`.
- [ ] Las comparaciones de las líneas 95-115 casi nunca se ejecutan: a esas alturas `this` ya no es VIP ni Fast.
- [ ] Falta el desempate: a igual pase, el que **llegó antes**; si llegaron a la vez, el de **menor id**.
- Idea: traducir cada pase a un número (VIP = 0, Fast = 1, Standard = 2) y comparar ese número, luego la llegada y luego el id, con `Integer.compare(...)`.

### Commits
- [ ] "aaa", "tarea": mejor un mensaje que diga qué cambia.
