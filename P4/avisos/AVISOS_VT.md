# Buzón de avisos – VT

Avisos de la P4 para **VT**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (rama `P4`, sin código todavía).

## Tus tareas (empezar después del `pull` de la Fase 0)
- [ ] `GestionElectoral.verificarParidad` (l. 77-83): juntar en una `List<ListaElectoral>` las listas que **no** cumplen (`cumpleParidad`, de LP) y pasársela a `mostrarAlertasParidad`.
- [ ] `GestionElectoral.mostrarAlertasParidad` (l. 85-87): una alerta por lista, con partido, circunscripción y porcentajes (`getPorcentajeHombres`/`getPorcentajeMujeres` ya existen). Si no hay ninguna, decirlo.
- [ ] `GestionElectoral.mostrarListaElectos` (l. 122-124): partido, circunscripción y los electos en orden (posición, nombre). Si la lista está vacía (0 escaños), indicarlo.
- [ ] Javadoc de esos tres métodos.
- No toques `generarListasElectorales` (AR) ni `ListaElectoral` (LP y AR).

## Lecciones de P3
- [ ] Pasar `generar_javadoc.bat` antes de decir "todo correcto": en P3 quedaron 12 avisos.
- [ ] Mensajes de commit que digan qué cambia ("jdad", "no message", "limpio").

## Hecho
