# Buzón de avisos – LP

Avisos de la P4 para **LP**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 20-oct-2026, noche (rama `P4` = `e596626`).

## Tus tareas (por orden)

### 1. `getCandidatosElectos()` — `ListaElectoral` (sin hacer: devuelve una lista vacía)
Devuelve los k primeros candidatos de la lista, siendo k los escaños.
- [x] Calcular k con `calcularEscanos()`. *(24-oct, en local, falta commit)*
- [x] **Si k es mayor que `candidatos.size()`, usar `candidatos.size()`.** Con 400.000 votos salen 13 escaños y solo hay 12 candidatos: sin este límite → `IndexOutOfBoundsException`. *(24-oct, en local, falta commit)*
- [x] Crear un `ArrayList` nuevo y añadir los k primeros recorriendo `candidatos` desde la posición 0 (o `subList(0, k)` metido en un `ArrayList` nuevo). *(24-oct, en local, falta commit)*
- [x] No hace falta ordenar: AR ya deja las listas ordenadas en `generarListasElectorales`. *(24-oct, en local, falta commit)*
- [x] Quitar el comentario `// TO DO: completar implementación`. *(24-oct, en local, falta commit)*
- [x] Javadoc: qué hace, que con k mayor que la lista devuelve todos, y `@return`. *(24-oct, en local, falta commit)*
- Esperado con 95.000 votos (3 escaños): BB Madrid → Elena Gomez, Carlos Ruiz, Lucia Sanz · BSOE Madrid → Javier Lopez, Carmen Cano, Andres Gil · BB Barcelona → Marta Roca, Jordi Serra, Adrian Mas · BSOE Barcelona → Lluis Vidal, Laia Sole, Marc Pujol. Con 0 votos: lista vacía. Con 400.000: los 12.

### 2. `cumpleParidad()` — arreglos (ya funciona con el CSV: solo BB Barcelona da `false`)
- [x] **Lista vacía** *(confirmado al ejecutar en VS Code el 20-oct: `ArithmeticException: / by zero` en la línea 120 cuando no se encuentra el CSV)*: lanza `ArithmeticException` (divide entre `total = 0`). Si `candidatos` está vacía, devolver `false` antes de dividir. *(24-oct, en local, falta commit)*
- [x] **División entera**: `(mujeres * 100) / total` se calcula con enteros aunque se guarde en `double` (79 H / 121 M = 60,5 % → 60 → `true`, y debería ser `false`). Multiplicar por `100.0`, o usar `getPorcentajeMujeres()` y `getPorcentajeHombres()`, que ya existen. *(24-oct, en local, falta commit)*
- [x] **Javadoc**: quitar `@param listCandidatos` (ese parámetro ya no existe y **hace fallar `generar_javadoc.bat`** con un error). Poner descripción y `@return true si hombres y mujeres están entre el 40 % y el 60 % (incluidos)`. *(24-oct, en local, falta commit)*
- [x] Errata `porcertajeMujeres` → `porcentajeMujeres`. *(24-oct, en local, falta commit)*

### 3. `calcularEscanos()` (funciona: 0, 29.999, 30.000, 95.000, 360.000, 400.000 → 0, 0, 1, 3, 12, 13)
- [x] Javadoc: 1 escaño por cada 30.000 votos completos; `@return` número de escaños. *(24-oct, en local, falta commit)*

### 4. Lo que queda de la Fase 0
- [ ] **Cabeceras de clase** con iniciales (`LP, AR, VT`) y **código de grupo** en las 7 clases. `Genero` aún tiene `Autores: [Iniciales]` y `Grupo: [CodigoGrupo]`; el resto, nada o sin grupo.
- [x] *(21-oct, falta commit)* **Ruta del CSV**: `"P4/archivos/candidaturas.csv"`. VS Code ejecuta desde `LAB`; con la ruta anterior daba `FileNotFoundException` y luego `/ by zero`.

### 5. Coordinación (antes del martes 27)
- [x] *(21-oct: ya compila, `7804cf4`)* **La rama `P4` no compila** desde `9afe799` (VT, "hay errores"): en `mostrarAlertasParidad` usa `listasAlertasIncorrecta`, que es una variable de `verificarParidad`. Hasta que VT lo arregle, nadie puede ejecutar. Avisarle (detalle en `AVISOS_VT.md`).
- [ ] AR añadió javadoc vacío a **todos** los métodos de `GestionElectoral`, también a los de VT (en `c98f5aa`), y VT los borró. Recordar la norma: cada uno solo sus métodos.
- [ ] Commits con mensaje: en P4 ya hay 5 "no message" (AR) y 2 "hay errores" (VT).
- [ ] Subir `TAREAS.md` y `avisos/` cuando se actualicen (solo tú).

## Hecho
- [x] Fase 0: paquete `P4` con `model/` y `util/`; lectura con `FicheroSecuencial`/`LeerFicheroInt` como en P1/P2; `return` provisionales; `generar_javadoc.bat` (20-oct).
- [x] `cumpleParidad` sin parámetros y devolviendo `true` cuando toca (20-oct).
- [x] `calcularEscanos` (20-oct).
