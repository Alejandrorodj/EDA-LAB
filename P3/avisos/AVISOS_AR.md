# Buzón de avisos – AR

Avisos de la P3 para **AR**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 17-oct-2026 (`origin/P3` = `566f07b` más los cambios sin subir).

## Lectura de parámetros (`ParqueDeAtracciones.leerPorPantalla`)
- [ ] Pide "número de visitantes" como `N` y obliga a que `E + F + 1 == N` (l. 35-51). En el enunciado **`N` es el número de lotes** y `E`, `F` son visitantes **por lote**: no hay relación entre ellos. Con el caso base `N=2, E=3, F=2` el programa no deja seguir.
- [ ] **No se pide `L`** (tiempo entre lotes).
- [ ] Validar `N ≥ 1`, `E ≥ 0`, `F ≥ 0`, `L ≥ 0` y avisar si no.
- [ ] Si se escribe algo que no es un número, `nextInt()` lanza `InputMismatchException` y el programa se cae.
- [ ] Falta un espacio: `"Has introducido" + N` (l. 38).

## Generación de visitantes (`ParqueDeAtracciones.generarVisitantes`)
- [ ] Solo genera **un lote**; hay que generar los `N`.
- [ ] `while (id < E)` crea `E - 1` Standard, no `E`.
- [ ] `while (id < F)` compara el id con `F`, no con `E + F`: con `E=3, F=2` salen 2 Standard, **0 Fast** y el VIP con id 3. Debería ser Standard 1-3, Fast 4-5 y VIP 6.
- [ ] `id` empieza en 1 en cada llamada: los ids tienen que seguir entre lotes (lote 2: 7-12).
- [ ] El parámetro `tiempo` no se usa: cada visitante tiene que llevar su **llegada** (`k·L`).
- [ ] Devuelve una `List`; la pista del enunciado es meter a todos en una **cola** (`Queue<Visitante>`) en orden de llegada.
- [ ] No se llama desde ningún sitio.
- [ ] Nombres: `N, E, F, L` y `LoteVisitantes` empiezan por mayúscula (en Java, variables en minúscula).
- Coordinar con **VT**, que va a quitar los `static` de `ParqueDeAtracciones`: cambia la forma de estos dos métodos.

## `Visitante` (`model/Visitante.java`)
Va unido a la generación: cada visitante que crees tiene que salir con su llegada.
- [ ] **Constructores**: hay dos. `Visitante(id, inicio, llegada, pase)` pide el `inicio`, que no se sabe al llegar (se pone al montar, con `setInicio`). `Visitante(id, pase)` deja la llegada a 0, y es el que usa `generarVisitantes`. Mejor dejar uno solo: `Visitante(int id, int llegada, String pase)`, y usarlo en `generarVisitantes`.
- [ ] **Espera**: método que devuelva `inicio - llegada` (cuánto esperó desde que llegó hasta que montó). Lo necesita la salida final (el que más espera).
- [ ] **`toString`**: id y pase al menos (para listar los que montan en cada recorrido), y si queréis llegada, inicio y espera para el resumen final.
- No tocar `compareTo` ni `prioridadPase`: están terminados y probados (LP).

## Commits
- [ ] Mensajes que no dicen nada ("no message", "Luis me manda lo mas aburrido"…). Mejor: "generarVisitantes: ids correlativos entre lotes".

## Hecho
- [x] El commit `887a748` no compilaba: cambió `llegada` por `salida` en `Visitante`. Arreglado por LP en `566f07b` "Fix error".
