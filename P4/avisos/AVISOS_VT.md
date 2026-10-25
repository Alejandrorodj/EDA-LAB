# Buzón de avisos – VT

Avisos de la P4 para **VT**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (rama `P4`, sin código todavía).

## URGENTE (20-oct, `9afe799` "hay errores")
- [x] *(21-oct, `7804cf4`: arreglado; las alertas salen bien)* **La rama `P4` no compila por tu cambio**: en `mostrarAlertasParidad` (l. 162) usas `listasAlertasIncorrecta`, que es una variable local de `verificarParidad`; desde otro método no existe → `cannot find symbol`. Nadie puede ejecutar el programa hasta que se arregle.
  - `mostrarAlertasParidad` ya recibe solo las listas que **no** cumplen: no hace falta comparar con nada. `verificarParidad` solo tiene que llamarla **una vez**, con las incorrectas (la lista de "correctas" sobra).
  - `listasAlertas.get(i)` imprime `P4.ListaElectoral@1b6d3586` (no tiene `toString`): usar `getPartido()`, `getCircunscripcion()`, `getPorcentajeHombres()`, `getPorcentajeMujeres()`.
  - `System.out.print` sin salto de línea: con varias alertas salen pegadas. Usar `println`. La frase "La representacion " está cortada.
  - Si no hay ninguna lista que falle, mostrar un mensaje ("Todas las listas cumplen la paridad").
  - Quitar los `// TO DO` y poner el javadoc (los borraste).
- [ ] Antes de hacer push, **compilar y ejecutar**. Si algo no compila, no subirlo a la rama compartida.

## Tus tareas (empezar después del `pull` de la Fase 0)
- [x] `GestionElectoral.verificarParidad` (l. 77-83): juntar en una `List<ListaElectoral>` las listas que **no** cumplen (`cumpleParidad`, de LP) y pasársela a `mostrarAlertasParidad`. *(hecho, `7804cf4`)*
- [x] `GestionElectoral.mostrarAlertasParidad` (l. 85-87): una alerta por lista, con partido, circunscripción y porcentajes (`getPorcentajeHombres`/`getPorcentajeMujeres` ya existen). Si no hay ninguna, decirlo. *(hecho, `7804cf4`)*
- [x] *(24-oct, `6241884`: hecho)* `GestionElectoral.mostrarListaElectos`: partido, circunscripción y los electos en orden (posición, nombre). Si la lista está vacía (0 escaños), indicarlo.
- [x] **Javadoc** de tus tres métodos (lo único que te queda). El "siempre me sale 0" es porque `getCandidatosElectos` (LP) aún no está hecho; tu método está bien. *(24-oct: javadoc puesto en local, falta commit)*
- No toques `generarListasElectorales` (AR) ni `ListaElectoral` (LP y AR).

## Lecciones de P3
- [ ] Pasar `generar_javadoc.bat` antes de decir "todo correcto": en P3 quedaron 12 avisos.
- [ ] Mensajes de commit que digan qué cambia ("jdad", "no message", "limpio").

## Hecho
