# Buzón de avisos – AR

Avisos de la P3 para **AR**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (`origin/P3` = `2a8229f`).

## `compareTo` (lo tocaste en `c34d14b`; es de LP)
- [x] *(18-oct: LP lo devolvió a `else if (this.id > v.getId())`; `v.compareTo(v) == 0`.)* En el paso del id cambiaste el segundo `if (this.id > v.getId())` por `else`. Ahora, con el **mismo visitante**, devuelve **1**: `v.compareTo(v) == 1` (probado), y el contrato pide 0. Volver a como estaba (`else if (this.id > v.getId())`). El `compareTo` era de LP y estaba probado; si ves algo, avisa en su buzón en vez de cambiarlo.

## `Visitante` (`model/Visitante.java`)
- [x] *(18-oct: LP lo volvió a poner, con `getInicio`/`setInicio` y en `toString`)* **Has quitado el atributo `inicio`** (y `getInicio`/`setInicio`) en `8c02882`. Hace falta: es la hora a la que monta cada visitante (se pone con `setInicio` al montar) y sin él no hay espera ni "visitante que más espera". Volver a ponerlo (sin meterlo en el constructor).
- [→EQUIPO] *(18-oct)* **Espera**: no hace falta un método en `Visitante`; se calcula en la simulación al montar (`reloj - llegada`). Pasa a `AVISOS_EQUIPO.md`.
- [x] *(18-oct, corregido)* Los comentarios de `getLlegada`/`setLlegada` dicen "inicio" (`@return the inicio`, `@param inicio`).
- No tocar `compareTo` ni `prioridadPase` (LP).

## Lectura de parámetros (`leerPorPantalla`)
- [x] *(19-oct: hecho por VT en `03283a4`; probado con "x" y "abc": avisa y vuelve a pedir el dato. Ojo: la excepción se llama `e` en el `catch` y tapa al atributo `e`; mejor `ex`)* Si se escribe algo que no es un número, `nextInt()` lanza `InputMismatchException` y el programa se cae (probado con "x"). Capturarla y volver a pedir el dato.

## Generación de visitantes (`generarVisitantes`)
- [x] *(18-oct: ahora va a `colaEspera`, un `ArrayDeque`, en `Simulacion`)* Devuelve una `List`; la pista del enunciado es meter a todos en una **cola** (`Queue<Visitante>`, por ejemplo `ArrayDeque` o `LinkedList`) en orden de llegada.
- [x] *(18-oct: `generarVisitantes(int llegada)` crea un solo lote y la llegada la calcula `generarLote`)* El parámetro `tiempo` no sirve: se sobrescribe con `i * L` en el bucle. Quitarlo (y el `0` de la llamada en `main`).
- Coordinar con **VT**, que va a quitar los `static` de `ParqueDeAtracciones`.

## Commits
- [ ] Mensajes que no dicen nada o con indirectas ("no message", "Luis haz bien el compareTo", "modificacion penultima"). Mejor: "generarVisitantes: N lotes con ids correlativos".

## Hecho
- [x] `leerPorPantalla`: pide `N` como número de lotes, `E`, `F` y **`L`**, sin la relación `E + F + 1 == N`, y vuelve a pedirlos si `N ≤ 0` o alguno es negativo (`c34d14b`, `c1a4100`).
- [x] Espacio en "Has introducido " + N.
- [x] `generarVisitantes`: genera los `N` lotes, E Standard + F Fast + 1 VIP, ids correlativos y llegada `i * L`. **Probado** con `N=2, E=3, F=2, L=100`: ids 1-3 S, 4-5 F, 6 V en t=0 y 7-9 S, 10-11 F, 12 V en t=100.
- [x] `generarVisitantes` ya se llama desde `main`; `loteVisitantes` en minúscula.
- [x] `Visitante`: un solo constructor `Visitante(int id, int llegada, String pase)` y `toString`.
- [x] El commit `887a748` no compilaba (`salida`). Arreglado por LP en `566f07b`.
