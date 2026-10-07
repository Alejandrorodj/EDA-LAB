# Tareas – Laboratorio 3: Colas (S3)

**Asignatura:** Estructuras de Datos · Curso 2026/27 · UCLM (ESI)
**Objetivo:** simular la cola de acceso a la atracción *Shoot the Bug* del parque *Santa Tecla Computer World* usando **colas** y **colas con prioridad** de la librería estándar de Java.
**Enunciado:** `archivos/2026_27_colas_ES.pdf`

> Este documento es solo una planificación. El enunciado **prohíbe usar asistentes de generación de código** (ChatGPT, Copilot, Claude…): la implementación la hace el equipo.

---

## 1. Resumen del enunciado

### La atracción
- Un tren de **5 vagonetas individuales**: en cada recorrido montan **como máximo 5 personas**.
- Cada recorrido dura **300 unidades de tiempo**.
- Montan los que toque según su **pase** y su **orden de llegada**.

### Los visitantes
- Tienen un **identificador numérico**, del 1 en adelante, y uno de estos **tres tipos de pase**: `Standard`, `Fast pass` y `VIP pass`.
- **Prioridad** en la cola de espera:
  1. **VIP pass** (máxima)
  2. **Fast pass**
  3. **Standard**
- **Desempates** a igualdad de pase:
  1. El que **llegó antes** a la cola.
  2. Si llegaron a la vez, el de **menor identificador**.

### Parámetros de la simulación
| Parámetro | Significado |
|---|---|
| `N` | Número de lotes de visitantes |
| `E` | Visitantes **Standard** por lote |
| `F` | Visitantes **Fast pass** por lote |
| `L` | Tiempo entre lotes (unidades de tiempo) |

### Generación de visitantes
- Cada lote crea, **en este orden**: `E` Standard, después `F` Fast pass y después **1 VIP**. Todo el lote llega **a la vez**.
- El lote 1 llega en `t = 0`, el lote 2 en `t = L`, el lote 3 en `t = 2L`… En general, el lote *k* (empezando en 0) llega en `t = k·L`.
- Total de visitantes: `N · (E + F + 1)`.
- Los identificadores son correlativos entre lotes. Por ejemplo, con E = 3 y F = 2, el lote 1 tiene los ids 1–3 (S), 4–5 (F) y 6 (VIP); el lote 2, los ids 7–9 (S), 10–11 (F) y 12 (VIP).

### Salida obligatoria
1. **Cada recorrido**: hora de inicio y visitantes que montan, con su **tipo de pase**.
2. **Al final**: el visitante que **más ha esperado**, desde que llega hasta que empieza su recorrido. Si hay empate, el que **llegó primero**.

---

## 2. Requisitos técnicos y normas (checklist de cumplimiento)

- [ ] **Pista del enunciado:** usar una **cola para recoger inicialmente a todos los visitantes** del parque, en orden de llegada (una `Queue` básica: `LinkedList` o `ArrayDeque`).
- [ ] Usar las **implementaciones de colas de la librería estándar** que correspondan:
  - una cola FIFO (`Queue` / `ArrayDeque` / `LinkedList`) para la llegada de visitantes;
  - una **cola con prioridad** (`PriorityQueue`) para la cola de espera de la atracción.
- [ ] **Sin moldes (casts)** relacionados con las colas y **sin ninguna referencia a `Object`**:
  - genéricos siempre tipados (`Queue<Visitante>`, `PriorityQueue<Visitante>`), nunca tipos crudos;
  - el criterio de ordenación tipado (`Comparable<Visitante>` o `Comparator<Visitante>`);
  - ojo con `equals(Object)` y con `toArray()` sin argumentos (devuelve `Object[]`): mejor no usarlos.
- [ ] **Documentación interna (Javadoc)** en **cada clase** y en los métodos relevantes. La guía está en Campus Virtual → sección *Laboratorio*.
  - Lección de P2: el comentario de clase va **justo encima de la declaración de la clase**, no encima de `package`; usar `@param`, `@return`, `@throws` y `{@code ...}` para los genéricos (`{@code Queue<Visitante>}`), y no dejar bloques `/** */` vacíos duplicados.
- [ ] **Modularización y diseño orientado a objetos** adecuados: no meter todo en `main` ni en métodos `static`.
- [ ] **Ningún dato personal en el código.** Nada de nombres ni correos: solo **iniciales + código de grupo de prácticas**.
  - Lección de P2: allí se pusieron los nombres completos en las cabeceras. **No repetirlo.**
- [ ] **Sin caracteres especiales en los nombres de ficheros**: ni tildes, ni `ñ`, ni espacios.
- [ ] Práctica hecha **en equipo**, no individual.
- [ ] Sin asistentes de generación de código.

---

## 3. Diseño propuesto (clases)

| Clase | Responsabilidad |
|---|---|
| `TipoPase` (enum) | `VIP`, `FAST_PASS`, `STANDARD`, cada uno con su **prioridad explícita** (un atributo numérico o el orden de declaración, documentado) y un nombre para mostrar. |
| `Visitante` | `id`, `tipoPase`, `tiempoLlegada` y `tiempoInicioRecorrido`, que se rellena al montar. Calcula su **tiempo de espera**. Getters y `toString`. |
| Criterio de prioridad | `Visitante implements Comparable<Visitante>` **o** una clase/lambda `Comparator<Visitante>`. Compara por pase, luego por llegada y luego por id. |
| `Atraccion` (o `Tren`) | Constantes de **capacidad (5)** y **duración (300)**. Saca hasta 5 visitantes de la cola de espera e informa del recorrido. |
| `Simulador` | Recibe `N, E, F, L`. **Genera** los visitantes en la cola inicial, controla el **reloj**, pasa los visitantes de la cola inicial a la cola de prioridad cuando llegan, lanza los recorridos y busca al que **más ha esperado**. |
| `Constantes` (opcional) | Capacidad, duración y, si se fijan, los valores de N, E, F y L. |
| `ParqueDeAtracciones` | Clase principal (`main`): obtiene los parámetros, crea el `Simulador` y lo arranca. |

### Estructura de carpetas
```
LAB/
└── P3/
    ├── ParqueDeAtracciones.java   arranque: obtiene N, E, F, L, crea el Simulador y lo lanza
    ├── Simulador.java             reloj, las dos colas, bucle de recorridos, visitante de mayor espera
    ├── model/
    │   ├── TipoPase.java          enum VIP, FAST_PASS, STANDARD (con su prioridad)
    │   ├── Visitante.java         id, pase, llegada, inicio de recorrido, espera
    │   └── ComparadorVisitantes.java   (solo si se usa Comparator en vez de Comparable)
    ├── util/
    │   └── Constantes.java        CAPACIDAD = 5, DURACION = 300 y los valores por defecto de N, E, F, L
    ├── archivos/
    │   └── 2026_27_colas_ES.pdf   enunciado
    ├── doc/                       Javadoc generado (en .gitignore)
    ├── generar_javadoc.bat
    └── TAREAS.md
```
- El `package` de cada fichero coincide con su carpeta: `P3`, `P3.model` y `P3.util`.
- No se lee ningún fichero de datos, así que no hace falta `util/file/`. Si al final los parámetros vienen de un fichero, se añade.
- `Atraccion` (o `Tren`) es opcional: si `Simulador` crece mucho, se le saca a esa clase lo de montar a 5 y mostrar el recorrido.
- Se compila desde `LAB/`, igual que en P2.

### Las dos colas
```
generar lotes ──► Queue<Visitante> (FIFO, todos los visitantes en orden de llegada)
                        │  cuando su tiempoLlegada ≤ reloj
                        ▼
                  PriorityQueue<Visitante> (cola de espera: VIP > Fast > Standard)
                        │  hasta 5 por recorrido
                        ▼
                     recorrido (inicio = reloj) ──► registrar espera
```

---

## 4. Algoritmo de la simulación (en palabras, sin código)

1. **Generar** los `N` lotes. Para cada lote *k*: E Standard, F Fast y 1 VIP, con llegada `k·L` e id correlativo. Todos van, en ese orden, a la **cola inicial**.
2. **Reloj** a 0.
3. **Mientras** queden visitantes en la cola inicial **o** en la cola de espera:
   1. Si la cola de espera está vacía y el siguiente visitante llega más tarde, **adelantar el reloj** hasta su llegada (ver ambigüedad 1).
   2. **Pasar** a la cola de espera a todos los visitantes de la cola inicial cuya llegada sea **≤ reloj**. Como la cola inicial está ordenada por llegada, basta con mirar el frente (`peek`) y sacar (`poll`) mientras se cumpla.
   3. **Montar** hasta 5 visitantes, sacándolos (`poll`) de la cola con prioridad. Guardar en cada uno la hora de inicio.
   4. **Mostrar** el recorrido: hora de inicio, ids y tipos de pase.
   5. **Avanzar** el reloj 300 unidades, lo que dura el recorrido.
4. Recorrer a los visitantes que han montado y quedarse con el de **mayor espera**. Si hay empate, el de **menor tiempo de llegada** y, después, el de **menor id**.

Notas importantes sobre `PriorityQueue`:
- **No es estable**: a igual prioridad no conserva el orden de inserción. Por eso el criterio tiene que desempatar **siempre**, hasta llegar al id, y dejar un orden total.
- **Recorrerla con un `for-each` o con `toString()` NO da los elementos en orden de prioridad**: solo `poll()` los saca en orden. Si se quiere mostrar la cola ordenada, hay que hacerlo de otra forma.
- En el criterio, comparar enteros con `Integer.compare(...)`, no restando (la resta puede desbordar).

---

## 5. Plan de tareas

### Fase 0 · Preparación
- [ ] Leer el enunciado completo en equipo y repartir roles.
- [ ] Consultar en Campus Virtual la guía de documentación (Javadoc).
- [ ] Anotar las **iniciales de cada integrante y el código de grupo** para la cabecera de los comentarios.
- [ ] Decidir cómo se dan los parámetros `N, E, F, L` (constantes, argumentos de `main` o lectura por teclado) y documentarlo.
- [x] Crear la estructura de paquetes en `P3/` (`P3`, `P3.model`, `P3.util`), con nombres sin caracteres especiales.
  - OK (7-oct): existen `ParqueDeAtracciones.java` (con `main` vacío), `model/Visitante.java` (vacía), `util/` (vacía) y `archivos/` con el enunciado.
  - En git (ramas `P3` y `origin/P3`) solo está `P3/Main.java`; los ficheros nuevos aún no se han subido.
- [x] Copiar `generar_javadoc.bat` de P2 y cambiar `P2` por `P3` (`-d P3\doc` y `-subpackages P3`).
  - OK (7-oct): creado `P3/generar_javadoc.bat`; `P3/doc/` ya queda fuera de git por la regla `doc/` del `.gitignore`.

### Fase 1 · Modelo de datos
- [ ] Enum `TipoPase` con los tres pases y su prioridad.
- [ ] Clase `Visitante` (id, pase, llegada e inicio de recorrido) con constructor, getters, cálculo de espera y `toString`.
  - Creada vacía (7-oct).
- [ ] Criterio de prioridad (`Comparable<Visitante>` o `Comparator<Visitante>`): pase, luego llegada, luego id.
- [ ] Javadoc de cada clase y método.

### Fase 2 · Generación de visitantes
- [ ] Generar `N` lotes con el orden exacto: E Standard, F Fast y 1 VIP.
- [ ] Asignar los ids correlativos desde 1 (un contador que no se reinicie por lote).
- [ ] Asignar la llegada `k·L` a todo el lote.
- [ ] Encolarlos en la **cola inicial** (`Queue<Visitante>`).
- [ ] Validar los parámetros: `N ≥ 1`, `E ≥ 0`, `F ≥ 0`, `L ≥ 0`. Avisar si son incorrectos.

### Fase 3 · Simulación
- [ ] Cola de espera `PriorityQueue<Visitante>` con el criterio de la Fase 1.
- [ ] Bucle principal (sección 4): pasar los que han llegado, montar hasta 5, mostrar y avanzar 300.
- [ ] Gestionar el **tren vacío**: si no hay nadie esperando, saltar a la siguiente llegada sin sacar un recorrido vacío.
- [ ] Guardar la hora de inicio de cada visitante al montar.
- [ ] Condición de fin: las dos colas vacías.

### Fase 4 · Salida por pantalla
- [ ] Por cada recorrido: número de recorrido (opcional), **hora de inicio** y lista de visitantes con **id y tipo de pase**.
- [ ] Resumen final: **visitante con mayor espera** (id, pase, llegada, inicio y espera), con el desempate por llegada.
- [ ] Formato legible y consistente. Sin trazas de depuración en la versión final.

### Fase 5 · Pruebas
Resultados calculados a mano con la interpretación de la sección 6 (ambigüedad 1, opción A):

- [ ] **Caso base**: `N=2, E=3, F=2, L=100`

  | Recorrido | Inicio | Visitantes |
  |---|---|---|
  | 1 | 0 | 6 VIP, 4 Fast, 5 Fast, 1 Std, 2 Std |
  | 2 | 300 | 12 VIP, 10 Fast, 11 Fast, 3 Std, 7 Std |
  | 3 | 600 | 8 Std, 9 Std |

  Mayor espera: **500**, empate entre el 8 y el 9 (los dos llegan en t = 100) → **visitante 8** (menor id).
  Este caso comprueba el desempate por llegada: el **3 Std (llegó en 0) monta antes que el 7 Std (llegó en 100)**.
- [ ] **Recorrido incompleto**: `N=1, E=2, F=1, L=50` → un solo recorrido en t = 0 con 4 personas (4 VIP, 3 Fast, 1 Std, 2 Std).
- [ ] **Solo VIP**: `N=3, E=0, F=0, L=0` → un recorrido en t = 0 con los VIP 1, 2 y 3 (desempate por id).
- [ ] **Lotes muy separados** (`L > 300`): `N=2, E=1, F=1, L=400` → el tren queda libre y espera al siguiente lote (recorridos en 0 y en 400 con la opción A; en 0 y en 600 con la opción B).
- [ ] **`L = 0`**: todos los lotes llegan a la vez. Hay que comprobar que todos los VIP van primero, luego todos los Fast y luego todos los Standard.
- [ ] **Mucha cola** (`E` grande, `L` pequeño): los Standard esperan mucho. Comprobar que el de mayor espera es un Standard.
- [ ] Parámetros inválidos (negativos, `N = 0`).

### Fase 6 · Revisión final y entrega
- [ ] **No hay casts ni referencias a `Object`** relacionados con las colas.
- [ ] Javadoc completo y **sin bloques vacíos duplicados**. Ejecutar `javadoc` y revisar los avisos.
- [ ] **Sin nombres ni correos**: solo iniciales + código de grupo.
- [ ] Nombres de fichero sin caracteres especiales.
- [ ] Modularización y diseño orientado a objetos (nada de "todo en `main`").
- [ ] Preparar la entrega según indique Campus Virtual. TODO: fecha de entrega.

---

## 6. Puntos ambiguos del enunciado (conviene aclarar o documentar)

1. **¿Cuándo sale el tren?** El enunciado solo dice que el recorrido dura 300.
   - **Opción A (la de las pruebas):** el tren sale en cuanto queda libre si hay alguien esperando. Si no hay nadie, espera a la siguiente llegada y sale en ese momento.
   - **Opción B:** el tren sale siempre en múltiplos de 300 (0, 300, 600…), aunque esté vacío hasta entonces.
   - Solo cambian los resultados cuando `L > 300` o hay huecos sin visitantes. **Preguntar al profesor** o documentar la elección.
2. **¿Sale el tren con menos de 5?** Se entiende que sí: si hay menos de 5 esperando, sale con los que haya. Si no, en el caso de `N=1, E=2, F=1` nunca saldría.
3. **¿Los que llegan justo cuando sale el tren pueden montar?** Se entiende que sí: llegada **≤** hora de salida. Es lo que pasa en t = 0 con el primer lote.
4. **Desempate del "visitante que espera más"**: si coinciden en espera y en llegada, el enunciado no dice nada más. Lo natural es el **menor id**, que es el que se generó antes.
5. **Unidad de tiempo:** solo hay enteros; no hace falta usar decimales.
6. **Origen de N, E, F y L**: no se especifica. Lo más cómodo para probar es leerlos por teclado o como argumentos, con valores por defecto.
7. **"Accederá a la atracción"** en el enunciado quiere decir **"llegará a la cola"** en t = 0, no que monte necesariamente en ese instante.

---

## 7. Relación con la teoría
- **Tema 3 – Colas:** FIFO (`offer`/`poll`/`peek`), cola con prioridad y `PriorityQueue` de Java.
- Diferencia clave: `add`/`remove`/`element` lanzan excepción; `offer`/`poll`/`peek` devuelven `false`/`null`. Con la cola vacía, usar los segundos y comprobar el `null`, o mirar antes `isEmpty()`.

---

## 8. Revisión del código (1ª revisión, 7-oct-2026)

**Hecho:** `Visitante` con `id`, `pase`, constructor, getters/setters e `implements Comparable<Visitante>`; `Constantes` con los tres nombres de pase; `ParqueDeAtracciones` crea una `PriorityQueue`. Compila (javac 21).

**Errores:**

1. **`compareTo` no ordena bien** (probado con una prueba aparte):
   - VIP frente a VIP devuelve `-1` en los dos sentidos, y Fast frente a cualquiera devuelve `0` (Fast "empata" con VIP y con Standard). Standard frente a Standard devuelve `1` en los dos sentidos.
   - Eso rompe el contrato de `compareTo` (si `a<b` entonces `b>a`; si `a==b` entonces `b==a`), y `PriorityQueue` saca los elementos en un orden imprevisible.
   - Con los 12 visitantes del caso base (todos a la vez), sale `12V 6V 11F 10F 7S 3S 9S 1S 5F 4F 2S 8S`: Fast mezclados con Standard e ids desordenados. Debería ser `6V 12V 4F 5F 10F 11F 1S 2S 3S 7S 8S 9S`.
   - Las comparaciones de las líneas 56-70 casi nunca se ejecutan: a esas alturas `this` ya no es VIP ni Fast, y todas menos una exigen que lo sea.
   - Falta el desempate por **llegada** y por **id**.
2. **Tipo crudo** en `ParqueDeAtracciones` (línea 10): `PriorityQueue cola = new PriorityQueue<Visitante>()`. Debe ser `PriorityQueue<Visitante>` a los dos lados; `javac -Xlint` avisa `[rawtypes]` y el enunciado lo prohíbe.
3. **El pase es un `String`** comparado con `equalsIgnoreCase`. Un enum (`TipoPase`) con su prioridad hace la comparación mucho más simple y evita erratas.
4. **Faltan atributos en `Visitante`**: tiempo de llegada y hora de inicio del recorrido (hacen falta para el desempate y para la espera).
5. **`Constantes` está en `P3`**, no en `P3/util` (la carpeta `util/` existe pero está vacía). Funciona, pero no coincide con la estructura de la sección 3.
6. **Javadoc**: solo los comentarios automáticos de Eclipse (`@return the id`…); sin comentario de clase ni `@author` con iniciales.

**Falta todo lo demás:** cola FIFO de llegada, generación de lotes, simulación, salida y pruebas.
