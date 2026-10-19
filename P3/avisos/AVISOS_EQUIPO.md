# Buzón de avisos – Equipo (sin asignar)

Avisos de la P3 que no son de nadie todavía, agrupados por tema. Si alguien coge uno, que lo pase a su buzón.
Última revisión: 19-oct-2026 (`origin/P3` = `2a8229f`).

## Reparto actual
- **VT:** documentación, tipo de la `PriorityQueue` y diseño sin `static` (este último ya hecho con `Simulacion`).
- **LP:** `compareTo` y `Constantes` (terminado y subido).
- **AR:** lectura de parámetros, generación de visitantes y `Visitante` (constructores, espera, `toString`).
- **IA:** pruebas (Fase 5), cuando todo lo demás esté OK.

## Sin asignar
- [x] *(18-oct, noche: funciona; probados 7 casos)* **Simulación** (Fase 3 de `TAREAS.md`): cola FIFO de llegada, paso a la `PriorityQueue`, recorridos de 5 cada 300.
  - *(18-oct)* Ya hecho en `Simulacion.java` (sin subir): `colaEspera` es `ArrayDeque`, `generarVisitantes` crea un solo lote y lo mete en `colaEspera`, el id es atributo y empieza en 1.
  - [x] *(18-oct)* `generarLote` (l. 54): `tiempoLlegada += 1` → debe ser `+= l` (el tiempo entre lotes).
  - [x] *(18-oct, noche: arreglado `pasarALaCola` con la condición en el `while`, bucle principal y mensaje final; el equipo decide que la atracción salga cada 300 aunque vaya vacía y que se vean los recorridos vacíos, `esperaMaxima = -1`)* *(18-oct, revisión 2)* `iniciarSimulacion` ya está partida en `pasarALaCola` y `simularAtraccion` (bien), pero:
    - **`pasarALaCola` se queda colgado** con más de un lote: el `while` solo mira `!colaEspera.isEmpty()`; si el primero aún no ha llegado no se saca a nadie y repite para siempre. La condición de llegada tiene que ir en el `while` (con `&&`), no en un `if` dentro.
    - Falta el **bucle principal**: solo se hace un recorrido (con 1 lote de 3+2, el visitante 3 no monta nunca). Faltan `reloj += DURACION_ATRACCION`, el salto del reloj si la cola está vacía y el mensaje final con el que más espera.
    - `esperaMaxima` empieza en 0: si nadie espera, `visitanteMasEspera` queda `null` y al imprimirlo fallará. Empezar en -1.
  - [x] *(19-oct)* Erratas en los mensajes: "Introduce los número de lotes" → corregido. Queda: el mensaje final dice "El visitante con el ID que mas ha esperado es: ID = …" (repite "ID" y falta la tilde de "más").
- [x] *(18-oct, noche: cada recorrido con su hora, id y pase; al final el que más espera con su espera. Se podría añadir su llegada e inicio)* **Salida** (Fase 4): hora de inicio de cada recorrido con ids y pases, y el visitante que más espera.
  - La espera se calcula **al montar**: `reloj - llegada` (o `inicio - llegada` si se guarda con `setInicio`). No hace falta un método en `Visitante`; basta con quedarse con el mayor (y, si empatan, el que llegó antes). Es obligatoria: el enunciado pide mostrar al final el visitante que más ha esperado.
- [x] *(18-oct: creado `.gitattributes` en la raíz con `* text=auto`; `.bat` siempre CRLF y `.pdf` binario)* **Saltos de línea**: al abrir y guardar con distintos editores, git marca ficheros enteros como modificados aunque solo cambien los finales de línea. Conviene acordar uno (por ejemplo, `* text=auto` en un `.gitattributes`).

## Pendiente (19-oct)
- [ ] **Mensaje final**: mostrar también la **llegada** y el **inicio** del que más espera (Fase 4 de `TAREAS.md`) y arreglar el texto.
- [ ] (Opcional) En los recorridos vacíos solo sale "Recorrido en el tiempo: 300"; se entendería mejor con "(sin visitantes)".
- [ ] (Opcional) `leerPorPantalla` repite 4 veces el mismo bloque `try/catch`: se podría sacar a un método `leerEntero(mensaje, minimo)` (mejor modularización).

## Hecho / asignado
- [x] `Constantes` movida de `P3/` a `P3/util/` (17-oct). Al hacer commit, añadir `P3/util/`.
- `Visitante` (espera, `toString`, constructores) → buzón de **AR**.
- Diseño sin `static` → buzón de **VT**.
