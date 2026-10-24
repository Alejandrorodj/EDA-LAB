# Tareas – Laboratorio 4: Listas (S4)

Plan de trabajo de la P4. Creado el 19-oct-2026.
Enunciado: `archivos/2026_27_listas_v2_ES.pdf` · Datos: `candidaturas.csv` · Código base del Campus Virtual (copiado tal cual en `P4/`).

---

## 1. Resumen del enunciado

Programa para la Junta Electoral que procesa las candidaturas de **BB** y **BSOE** en **Madrid** y **Barcelona** (4 listas electorales).

`candidaturas.csv`: una línea por candidato, separada por `;` → `Partido;Circunscripción;Posición;Nombre;Género` (`H`/`M`). 48 líneas, 12 por lista, sin cabecera y sin línea vacía al final.

El programa tiene que:

1. **Leer** el CSV y crear los `Candidato` (ya hecho en el código base: `procesarArchivoCSV`).
2. **Generar las listas electorales**: repartir los candidatos en las 4 listas y mostrarlas **ordenadas por posición** (se recomienda `Collections.sort()`).
3. **Verificar la paridad**: una lista cumple si **cada género está entre el 40 % y el 60 %**. Mostrar una alerta por cada lista que no cumpla.
4. **Pedir los votos** de cada partido en cada circunscripción (ya hecho: `obtenerVotos` / `leerNumeroVotos`).
5. **Calcular los escaños**: **1 escaño por cada 30.000 votos completos** (ya se muestran en `obtenerEscanos`).
6. **Candidatos electos**: los **k primeros** de la lista ordenada, siendo k los escaños. Mostrarlos por partido y circunscripción.

### Lo que hay que implementar (8 métodos)

| Clase | Método | Qué hace |
|---|---|---|
| `ListaElectoral` | `agregarCandidato` | Añade un candidato a la lista. |
| `ListaElectoral` | `cumpleParidad` | `true` si H y M están entre el 40 % y el 60 %. |
| `ListaElectoral` | `calcularEscanos` | `votosPartido / 30000` (división entera). |
| `ListaElectoral` | `getCandidatosElectos` | Los k primeros de la lista ordenada. |
| `GestionElectoral` | `generarListasElectorales` | Recorre todos los candidatos y mete cada uno en su lista; deja las 4 ordenadas. |
| `GestionElectoral` | `verificarParidad` | Junta en una `List<ListaElectoral>` las listas que no cumplen y llama a `mostrarAlertasParidad`. |
| `GestionElectoral` | `mostrarAlertasParidad` | Muestra una alerta por cada lista recibida (con sus porcentajes). |
| `GestionElectoral` | `mostrarListaElectos` | Muestra los electos de un partido en una circunscripción. |

Todo lo demás ya viene hecho: lectura del CSV, mostrar las listas, pedir votos, mostrar escaños, `Candidato` (con `compareTo` por posición), `Genero` y `utils`.

---

## 2. Requisitos técnicos y normas

- [ ] Usar las **implementaciones de listas de la librería estándar** (`ArrayList`, `List`).
- [ ] **Sin moldes (casts) relacionados con las listas y sin ninguna referencia a `Object`**. (El `(double)` de `getPorcentajeHombres` es del código base y no es de listas.)
- [ ] **Javadoc de los métodos que completemos** (cada uno documenta los suyos, ver reparto).
- [ ] Cabeceras con **iniciales + código de grupo** (`Autores: [Iniciales]`, `Grupo: [CodigoGrupo]` ya vienen en `Genero`). Nada de nombres ni correos.
- [ ] Sin caracteres especiales en los nombres de fichero.
- [ ] En equipo; **sin asistentes de generación de código** (el enunciado nombra expresamente a Claude).

---

## 3. Reparto (sin conflictos)

La regla para no pisarse en git: **cada método tiene un solo dueño**, y los métodos de dos personas en el mismo fichero están **lejos entre sí** (git solo da conflicto si se tocan las mismas líneas o líneas pegadas).

| Quién | Fichero | Métodos (líneas del código base) |
|---|---|---|
| **LP** | `ListaElectoral.java` | `cumpleParidad`, `calcularEscanos`, `getCandidatosElectos` (l. 88-98, seguidos) |
| **LP** | todos | **Fase 0** (preparación, abajo), antes de que nadie empiece |
| **AR** | `ListaElectoral.java` | `agregarCandidato` (l. 24-26) |
| **AR** | `GestionElectoral.java` | `generarListasElectorales` (l. 61-64), incluida la **ordenación** |
| **VT** | `GestionElectoral.java` | `verificarParidad` + `mostrarAlertasParidad` (l. 77-87, seguidos) y `mostrarListaElectos` (l. 122-124) |
| **IA** | — | Pruebas (Fase 3) cuando todo esté OK; no se añade código de pruebas al repo |

- Cada uno escribe el **javadoc de sus propios métodos** (así nadie toca métodos ajenos).
- `TAREAS.md` y `avisos/` solo los sube **LP**.

### Normas para no tener conflictos
1. **`git pull` antes de empezar** y antes de cada commit.
2. **Tocar solo tus métodos.** Nada de "Formatear documento" en el fichero entero ni reordenar imports (cambia líneas de otros).
3. **No añadir imports por tu cuenta**: los que hacen falta (`java.util.Collections`) los deja puestos LP en la Fase 0.
4. Commits pequeños, uno por método o por tarea, con un mensaje que diga qué cambia (por ejemplo, "ListaElectoral: calcularEscanos").
5. Si de verdad necesitas cambiar algo fuera de tus métodos, avísalo antes en el grupo.

### Dependencias (se puede trabajar en paralelo)
- VT usa `cumpleParidad` (LP) y `getCandidatosElectos` (LP), pero sus firmas ya existen: puede escribir su parte ya; para probarla necesita lo de LP.
- AR no depende de nadie. Sin lo de AR las listas salen vacías, pero el programa arranca.

---

## 4. Plan por fases

### Fase 0 · Preparación **[LP]** (antes de que empiecen AR y VT)
- [x] Rama `P4` creada (`e86c435`, `3a37ba0`).
- [x] Copiar el código base, `candidaturas.csv` y el enunciado en `P4/` (19-oct, sin modificar).
- [x] **Lectura del fichero con las mismas clases que en P1 y P2** (decisión de LP, 20-oct): `util/file/FicheroSecuencial` y `util/file/LeerFicheroInt` (copiadas de P2, paquete `P4.util.file`; carpeta `util` como en P2). `Candidato` implementa `LeerFicheroInt` (`leerDatos`) y `GestionElectoral.procesarArchivoCSV` usa `FicheroSecuencial`. Lee los 48 candidatos.
  - [x] Borrar `util/file/SequentialFile.java` y `SequentialFileReadable.java`, que ya no se usan.
- [x] **Decidir el paquete**: `package P4;` con `model/` (`Candidato`, `Genero`) y `util/` (`Constantes`, `file/`) (20-oct).
- [x] **Ruta del CSV**: `"candidaturas.csv"` se busca en la carpeta desde la que se ejecuta. Ajustarla según el punto anterior.
  - **(21-oct) Decidido: todo se ejecuta desde `LAB`**, como hace VS Code (y como P2). `RUTA_FICHERO = "P4/archivos/candidaturas.csv"` (cambiado por LP, falta commit). Con `".//archivos//..."` VS Code daba `FileNotFoundException`.
  - (20-oct) LP: `".//archivos//candidaturas.csv"` funciona en su VS Code (directorio de trabajo = `P4`). Desde `LAB` falla. **Unificar con P2**, que usa la ruta desde `LAB` (`.\\P2\\archivos\\acciones.csv`): el evaluador tiene que poder ejecutar las tres de la misma forma.
- [x] *(20-oct)* **Que compile**: `cumpleParidad`, `calcularEscanos` y `getCandidatosElectos` no tienen `return` y el código base **no compila**. Poner un `return` provisional (`false`, `0`, lista vacía) con `// TODO` para que todos puedan ejecutar mientras tanto.
- [x] Añadir `import java.util.Collections;` en `GestionElectoral` (lo puso AR en `252ea70`).
- [x] Cabeceras con iniciales + grupo en las 7 clases (24-oct, falta confirmar el código real).
- [x] `generar_javadoc.bat` adaptado a la P4 (20-oct; con `cd` a `LAB` y `pause`).
- [ ] Commit y push; avisar a AR y VT para que hagan `pull` y empiecen.

### Fase 1 · `ListaElectoral`
- [x] `agregarCandidato` **[AR]** (`252ea70`). Falta javadoc.
- [x] `cumpleParidad` **[LP]** (funciona con el CSV). Lista vacía, división entera y javadoc corregidos (24-oct, falta commit).
- [x] `calcularEscanos` **[LP]** (probado). Javadoc hecho.
- [x] `getCandidatosElectos` **[LP]** (falta commit)

### Fase 2 · `GestionElectoral`
- [x] `generarListasElectorales` (repartir y ordenar) **[AR]** (`252ea70`; las 4 listas salen completas y ordenadas). Falta javadoc; sobra `import java.util.Collection`.
- [x] `verificarParidad` **[VT]** (`7804cf4`). Falta javadoc.
- [x] `mostrarAlertasParidad` **[VT]** (`7804cf4`): solo BB Barcelona, 66,67 % H / 33,33 % M. Añadió además `mostrarAlertasParidadCorrecta` para las que sí cumplen. Falta javadoc.
- [x] `mostrarListaElectos` **[VT]** (`6241884`; falta javadoc)

### Fase 3 · Pruebas **[IA]**
Resultados esperados con `candidaturas.csv`:

- [x] **Listas ordenadas** (posición 1 a 12 en cada una; ninguna tiene huecos ni posiciones repetidas).
- [x] **Paridad**: solo **BB Barcelona** da alerta (4 M / 8 H = 33,3 % M). Las demás cumplen: BB Madrid 7 M / 5 H (58,3 % M), BSOE Madrid 5 M / 7 H, BSOE Barcelona 5 M / 7 H (41,7 % M).
- [x] **Escaños**: 0 → 0; 29.999 → 0; 30.000 → 1; 95.000 → 3; 360.000 → 12.
- [x] **Electos** con 95.000 votos (3 escaños):
  - BB Madrid: 1 Elena Gomez, 2 Carlos Ruiz, 3 Lucia Sanz
  - BSOE Madrid: 1 Javier Lopez, 2 Carmen Cano, 3 Andres Gil
  - BB Barcelona: 1 Marta Roca, 2 Jordi Serra, 3 Adrian Mas
  - BSOE Barcelona: 1 Lluis Vidal, 2 Laia Sole, 3 Marc Pujol
- [x] **0 escaños**: la lista de electos sale vacía y se indica (no un error).
- [x] **Más escaños que candidatos**: 400.000 votos → 13 escaños, pero solo hay 12 candidatos. Debe dar los 12, **no lanzar `IndexOutOfBoundsException`**.
- [x] Votos no numéricos o negativos → los vuelve a pedir (probado 24-oct: `-5`, `-1`, `abc`, vacío, ` 12.5` y `99999999999` se rechazan con mensaje y vuelve a pedir; `0`, `29999`, `30000`, `59999`, `60000` y `2147483647` bien, sin excepción).

### Fase 4 · Revisión final y entrega
- [ ] Repasar la **rúbrica** (sección 6): requisitos del enunciado + casos de prueba.
- [ ] Sin casts de listas ni `Object`.
- [x] Javadoc de los 8 métodos; `generar_javadoc.bat` sin errores (24-oct: 0 errores y solo avisos de atributos con `//` y constructor por defecto).
- [ ] Cabeceras con iniciales y código de grupo; sin nombres.
- [ ] Commits con mensajes claros.

---

## 5. Decisiones y puntos a vigilar

1. **Paquete.** El código base está en el **paquete por defecto** (sin `package`) y `utils` en `package utils`. En el repo, VS Code toma `LAB` como raíz (`.vscode/settings.json`), así que en `P4/` no compilará tal cual. Opciones:
   - **A (recomendada, como en P3):** `package P4;` en las 4 clases, `package P4.utils;` en `utils` e `import P4.utils...`. CSV en `"P4/candidaturas.csv"`.
   - **B:** dejar el código base sin tocar y abrir en VS Code la carpeta `P4` como raíz.
   - **Importante por la evaluación (sección 6):** otro grupo tiene que poder compilar y ejecutar lo que entreguemos. Elijamos la que elijamos, **la ruta del CSV y los paquetes tienen que funcionar en el ZIP tal como se entregue**, abriéndolo como lo abriría el otro grupo. Con la A hay que abrir la carpeta que contiene `P2/`, `P3/` y `P4/`; con la B, la carpeta `P4`. Probarlo antes de entregar.
2. **Paridad con límites incluidos**: "entre el 40 % y el 60 %" → 40 % y 60 % cumplen. Hay que comprobar **los dos géneros** (con 2 géneros basta con uno, pero el enunciado dice "cada género").
3. **Lista vacía**: `getPorcentaje...` devuelve 0 → no cumple paridad. No pasa con este CSV.
4. **k > tamaño de la lista**: limitar k al número de candidatos antes de coger los primeros (ver Fase 3).
5. **Electos de una lista ordenada**: `getCandidatosElectos` da por hecho que la lista ya está ordenada (lo hace AR al generarla). Si no, los electos salen mal.
6. **Diseño `static`** en `GestionElectoral`: viene así en el código base del profesor; se mantiene.

---

## 6. Evaluación y entrega (`Evaluacion_Practicas_Lin_26_27.pdf`)

- Pilas (P2), colas (P3) y listas (P4) juntas valen el **10 % de la nota**. Son de **superación obligatoria** y la **asistencia a la sesión de evaluación es obligatoria**.
- **Evaluación por pares:** en la sesión, el profesor empareja grupos. Nosotros enviamos al otro grupo **exactamente lo que entregamos** (se descarga de la tarea del Campus Virtual).
- **Si no compila y ejecuta, no se revisa.** Es lo primero que se mira.
- El otro grupo comprueba los requisitos y restricciones de la **rúbrica** (en papel, se da al empezar) y **ejecuta los casos de prueba** que indique: si el programa cumple el enunciado.
- Nosotros también evaluamos a otro grupo; el profesor revisa nuestra corrección y **una evaluación mal hecha puede quitarnos puntos**. Hay que conocer bien los enunciados.
- **Entrega:** un solo **ZIP** por grupo (lo sube uno), en la tarea "[Grupos B1, B2, BD1, BD2, C1, C2] Entrega de las prácticas y plantilla de participación":
  - [ ] Los **3 proyectos (P2, P3, P4)**, cada uno en **su carpeta** con todas sus clases.
  - [ ] La **plantilla de participación** (Campus Virtual → Recursos).
  - [ ] Nombre del ZIP con el **primer apellido de cada miembro** (aquí sí van apellidos; en el código, no).
  - [ ] **Fecha: martes 27-oct-2026** (sesión de evaluación). Confirmar en Campus Virtual si la entrega del ZIP es ese mismo día o antes.

### Checklist antes de hacer el ZIP
- [ ] Cada proyecto **compila y se ejecuta desde el ZIP descomprimido** en un ordenador limpio (no solo desde nuestro VS Code): rutas de ficheros (`acciones.csv` en P2, `candidaturas.csv` en P4) y paquetes.
- [ ] **No meter** en el ZIP: `TAREAS.md`, `avisos/`, `doc/` generado, `bin/`, `.vscode/`. (En la rama `P2` está subido `P2/doc/`; quitarlo del ZIP.)
- [ ] Sin nombres ni correos en el código; cabeceras con iniciales y código de grupo en las 3 prácticas.
- [ ] Repasar cada enunciado contra el programa como si fuéramos el grupo evaluador.

## 7. Revisiones del código

### 20-oct (rama `P4` = `905d7f2`)
- Compila. Lee 48 candidatos; las 4 listas salen con 12 y **ordenadas por posición**; con 95.000 votos salen 3 escaños en cada una.
- **Hecho:** `agregarCandidato`, `generarListasElectorales` (AR), `cumpleParidad`, `calcularEscanos` (LP).
- **Falta:** `getCandidatosElectos` (LP); `verificarParidad`, `mostrarAlertasParidad`, `mostrarListaElectos` (VT, sin empezar): ahora las secciones 2 y 5 de la salida salen vacías.
- Javadoc de los 8 métodos y cabeceras de clase. `generar_javadoc.bat` da 1 error (`@param listCandidatos` en `cumpleParidad`).
- Ruta del CSV: unificar criterio con P2 (sección 4, Fase 0).

### 20-oct, noche (rama `P4` = `e596626`)
- **NO COMPILA** desde `9afe799` (VT): `mostrarAlertasParidad` usa `listasAlertasIncorrecta`, variable local de `verificarParidad`. Detalle en `avisos/AVISOS_VT.md`.
- VT: `verificarParidad` empezado (separa las que cumplen y las que no); `mostrarAlertasParidad` a medias; `mostrarListaElectos` sin empezar.
- LP: `getCandidatosElectos` sin hacer; arreglos de `cumpleParidad` y javadoc pendientes. Detalle en `avisos/AVISOS_LP.md`.
- AR: javadoc vacío en todos los métodos de `GestionElectoral` (`c98f5aa`), también en los ajenos.
- Commits: 5 "no message" (AR) y 2 "hay errores" (VT).

### 21-oct (rama `P4` = `7804cf4` + ruta del CSV en local)
- **Error al ejecutar desde VS Code (LP, 20-oct):** `FileNotFoundException: .\archivos\candidaturas.csv` porque VS Code ejecuta desde `LAB` → 0 candidatos → `ArithmeticException: / by zero` en `cumpleParidad` (lista vacía).
  - [x] Ruta cambiada a `"P4/archivos/candidaturas.csv"` (LP, sin commit). Comprobado: carga los 48.
  - [x] **`cumpleParidad` con lista vacía** (arreglado el 24-oct) sigue dividiendo entre 0 **[LP]**: devolver `false` si `candidatos` está vacía.
  - [ ] (Opcional) `procesarArchivoCSV` (código base): si no encuentra el fichero imprime la traza, sigue y dice "Se han cargado correctamente 0 registros". Mejor un mensaje claro y terminar. Si se cambia, que lo haga solo uno.
- Compila. Secciones 1, 2 y 4 de la salida correctas. Con 400.000 votos sale "13 escaños" (bien; la sección 5 todavía no muestra nada).
- **Falta:** `getCandidatosElectos` **[LP]** y `mostrarListaElectos` **[VT]** → la sección 5 sale vacía. Javadoc de todos. Cabeceras con código de grupo.

### 24-oct (rama `P4` = `6241884`)
- VT subió `mostrarListaElectos` (imprime los electos o "No ha obtenido ningun escaño") y quitó el `// TO DO` de `verificarParidad`. Su commit avisa de que "siempre me sale 0": es normal, porque `getCandidatosElectos` sigue vacío.
- ~~Bloqueo de la sección 5~~ resuelto en local por LP (falta commit): compila sin avisos; 95.000 → 3 electos por lista (los esperados); 400.000 → 13 escaños y 12 electos; 0 y 29.999 votos → "No ha obtenido ningun escaño".
- [x] Ruta del CSV (`P4/archivos/candidaturas.csv`) ya está commiteada (`69ad47f`).
- [x] `cumpleParidad` (LP, local, sin commit): ahora usa `getPorcentajeMujeres()` → lista vacía = false, sin división entera, sin `@param` sobrante. `getCandidatosElectos` (LP, local) hecho y probado.
- [x] *(hecho en local el 24-oct, falta commit)* Javadoc de los 8 métodos con `@param`/`@return` descritos, atributos con `//`, `import Collection` quitado. Era lo pendiente de LP (`cumpleParidad`, `calcularEscanos`, `getCandidatosElectos`), VT (sus 3 métodos) y AR (`agregarCandidato`, `generarListasElectorales`). Quitar `import java.util.Collection;` sin usar en `GestionElectoral` [AR].
- [x] Cabeceras `@author LP, AR, VT -- Grupo C` + `@version 1.0 (24/10/2026)` en las 7 clases (en local). Código de grupo **confirmado: C** ("Grupo C" confirmado por LP el 24-oct).
- Quedan 3 días: hoy sáb 24 → `getCandidatosElectos` y `cumpleParidad`; dom 25 → javadoc y cabeceras; lun 26 → mis pruebas (Fase 3), `generar_javadoc.bat` y ZIP; mar 27 → evaluación.
- Pruebas de la Fase 3 pasadas en mi copia local (listas ordenadas, alerta solo en BB Barcelona, escaños 0/29.999/30.000/95.000/400.000, electos esperados, 0 escaños y 400.000 sin excepción). Falta repetirlas con la versión final ya subida.
- **Pendiente real:** commit y push de todo lo local (`ListaElectoral`, `GestionElectoral`, `Candidato`, `Genero`, `Constantes`, `FicheroSecuencial`, `LeerFicheroInt`, `TAREAS.md`, `avisos/`), con `git pull` antes. Después: código de grupo real, votos no numéricos/negativos, casts/`Object`, mensajes de commit claros y prueba desde el ZIP el lunes.
- El javadoc de los métodos de AR y VT lo ha puesto LP en local: que lo vean antes del commit (cada uno documenta los suyos).
- **Revisión completa 24-oct (estado local):** compila sin avisos; sin casts ni `Object`; sin nombres ni correos en el código; `javadoc` con 0 errores; pruebas con votos negativos/texto/límites OK. Solo queda subir (commit y push) y probar desde el ZIP.
