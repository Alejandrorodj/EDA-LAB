# Buzón de avisos – Equipo (sin asignar)

Avisos de la P3 que no son de nadie todavía. Si alguien coge uno, que lo pase a su buzón.
Estado del repositorio revisado: `origin/P3` = `887a748` (14-oct-2026).

## 14-oct-2026
- [ ] **`Visitante`**: falta el cálculo de la **espera** (`inicio - llegada`) y `toString`. Hay dos constructores; el de `(id, pase)` deja la llegada a 0.
- [ ] **Simulación** (Fase 3 de `TAREAS.md`): cola FIFO de llegada, paso a la `PriorityQueue`, recorridos de 5 cada 300.
- [ ] **Salida** (Fase 4): hora de inicio de cada recorrido con ids y pases, y el visitante que más espera.
- [ ] **Diseño**: todo es `static` en `ParqueDeAtracciones` (atributos `N, E, F, L` incluidos). El enunciado penaliza no seguir la orientación a objetos.
- [ ] `Constantes` está en `P3/` y no en `P3/util/` como dice `TAREAS.md`.
- [ ] **Saltos de línea**: al abrir y guardar con distintos editores, git marca ficheros enteros como modificados aunque solo cambien los finales de línea (ahora pasa con `ParqueDeAtracciones.java`, `Visitante.java` y `TAREAS.md`). Conviene acordar uno (por ejemplo, `* text=auto` en un `.gitattributes`).
- Reparto actual: documentación → VT · `compareTo` y `Constantes` → LP · parámetros y generación → AR · pruebas (Fase 5) → IA, cuando todo lo demás esté OK.
