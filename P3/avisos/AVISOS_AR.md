# Buzón de avisos – AR

Avisos de revisión de la P3 para **AR**. Cuando arregles uno, márcalo con `[x]` y apunta el commit.
Lo más nuevo, arriba. Estado del repositorio revisado: `origin/P3` = `887a748` (14-oct-2026).

## 14-oct-2026

### Urgente
- [ ] **El último commit no compila** (`887a748`, "no message", subido a `origin/P3`). En `model/Visitante.java` se cambió `llegada` por `salida` en el constructor (l. 11-16) y en el getter/setter (l. 34-46), pero el atributo sigue llamándose `llegada` (l. 8) → `cannot find symbol` en las líneas 14, 38 y 45. Además se han perdido `getLlegada()`/`setLlegada()`. Quien haga `pull` recibe código que no compila. Volver a `llegada`.

### Lectura de parámetros (`ParqueDeAtracciones.leerPorPantalla`, commits `728ffa8`, `26a8fd8`)
- [ ] Pide "número de visitantes" como `N` y obliga a que `E + F + 1 == N` (l. 24-40). En el enunciado **`N` es el número de lotes** y `E`, `F` son visitantes **por lote**: no hay relación entre ellos. Con el caso base `N=2, E=3, F=2` el programa no deja seguir.
- [ ] **No se pide `L`** (tiempo entre lotes).
- [ ] Validar `N ≥ 1`, `E ≥ 0`, `F ≥ 0`, `L ≥ 0` y avisar si no.
- [ ] Si se escribe algo que no es un número, `nextInt()` lanza `InputMismatchException` y el programa se cae.
- [ ] Falta un espacio: `"Has introducido" + N` (l. 27).

### Generación de visitantes (`ParqueDeAtracciones.generarVisitantes`, commit `26a8fd8`)
- [ ] Solo genera **un lote**; hay que generar los `N`.
- [ ] `while (id < E)` crea `E - 1` Standard, no `E`.
- [ ] `while (id < F)` compara el id con `F`, no con `E + F`: con `E=3, F=2` salen 2 Standard, **0 Fast** y el VIP con id 3. Debería ser Standard 1-3, Fast 4-5 y VIP 6.
- [ ] `id` empieza en 1 en cada llamada: los ids tienen que seguir entre lotes (lote 2: 7-12).
- [ ] El parámetro `tiempo` no se usa: cada visitante tiene que llevar su **llegada** (`k·L`). El constructor `Visitante(id, pase)` la deja a 0.
- [ ] Devuelve una `List`; la pista del enunciado es meter a todos en una **cola** (`Queue<Visitante>`) en orden de llegada.
- [ ] No se llama desde ningún sitio.
- [ ] Nombres: `N, E, F, L` y `LoteVisitantes` empiezan por mayúscula (en Java, variables en minúscula).

### Commits
- [ ] Mensajes que no dicen nada ("no message", "Luis me manda lo mas aburrido"…). Mejor: "generarVisitantes: ids correlativos entre lotes".
