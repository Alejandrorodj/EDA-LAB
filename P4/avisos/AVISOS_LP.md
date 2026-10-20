# Buzón de avisos – LP

Avisos de la P4 para **LP**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (rama `P4`, sin código todavía).

## Tus tareas
- [ ] **Fase 0** (antes que nadie): paquete, ruta del CSV, `return` provisionales para que compile, `import java.util.Collections` en `GestionElectoral`, cabeceras, `generar_javadoc.bat`. Detalle en `TAREAS.md`, Fase 0.
- [ ] *(20-oct, 3ª prueba: **funciona con el CSV**: solo BB Barcelona `false`; 11/13 casos bien)* `ListaElectoral.cumpleParidad`: H **y** M entre 40 % y 60 %, límites incluidos. Falta: lista vacía → `ArithmeticException`; `(mujeres * 100) / total` sigue siendo división entera aunque se guarde en `double` (60,5 % → 60, p. ej. 79 H / 121 M da `true`); javadoc (aún dice `@param listCandidatos`) y errata `porcertaje`.
  - *(20-oct, probado con 11 casos y las 4 listas del CSV)* **Devuelve siempre `false`**:
    - En el `if` se pone `result = false`: nunca llega a `true`.
    - `mujeres / 100` es división entera → 0, así que el porcentaje siempre sale 0. Y la fórmula está al revés: es `mujeres * 100 / total`.
    - La firma cambió a `cumpleParidad(List<Candidato>)`; en el código base es `cumpleParidad()` sin parámetros y usa el atributo `candidatos`. VT la llamará sin parámetros.
    - Ya existen `getPorcentajeMujeres()` y `getPorcentajeHombres()`: se pueden usar.
    - Lista vacía: con la fórmula corregida, `total = 0` daría división entre 0.
    - Javadoc vacío; errata `porcertajeMujeres`.
    - Esperado con el CSV: solo BB Barcelona `false`; las otras tres `true`.
  - *(20-oct, 2ª prueba)* Fórmula arreglada (`mujeres * 100 / total`), pero **sigue devolviendo siempre `false`**: en el `if` sigue `result = false`. Con lista vacía ahora lanza `ArithmeticException` (división entre 0). Firma con parámetro y javadoc vacío, igual que antes.
- [x] *(20-oct: probado 0, 29.999, 30.000, 95.000, 360.000 y 400.000 → 0, 0, 1, 3, 12, 13)* `ListaElectoral.calcularEscanos`: división entera entre `VOTOS_ESCANO`. Falta su javadoc.
- [ ] `ListaElectoral.getCandidatosElectos`: los k primeros; si k es mayor que la lista, devolver todos (sin `IndexOutOfBoundsException`).
- [ ] Javadoc de esos tres métodos.

## Hecho
