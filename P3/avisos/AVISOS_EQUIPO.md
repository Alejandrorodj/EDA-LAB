# Buzón de avisos – Equipo (sin asignar)

Avisos de la P3 que no son de nadie todavía, agrupados por tema. Si alguien coge uno, que lo pase a su buzón.
Última revisión: 17-oct-2026 (`origin/P3` = `566f07b` más los cambios sin subir).

## Reparto actual
- **VT:** documentación, tipo de la `PriorityQueue` y diseño sin `static`.
- **LP:** `compareTo` y `Constantes` (terminado; falta commit).
- **AR:** lectura de parámetros, generación de visitantes y `Visitante` (constructores, espera, `toString`).
- **IA:** pruebas (Fase 5), cuando todo lo demás esté OK.

## Sin asignar
- [ ] **Simulación** (Fase 3 de `TAREAS.md`): cola FIFO de llegada, paso a la `PriorityQueue`, recorridos de 5 cada 300.
- [ ] **Salida** (Fase 4): hora de inicio de cada recorrido con ids y pases, y el visitante que más espera.
- [ ] **Saltos de línea**: al abrir y guardar con distintos editores, git marca ficheros enteros como modificados aunque solo cambien los finales de línea. Conviene acordar uno (por ejemplo, `* text=auto` en un `.gitattributes`).

## Hecho / asignado
- [x] `Constantes` movida de `P3/` a `P3/util/` (17-oct). Al hacer commit, añadir `P3/util/`.
- `Visitante` (espera, `toString`, constructores) → buzón de **AR**.
- Diseño sin `static` → buzón de **VT**.
