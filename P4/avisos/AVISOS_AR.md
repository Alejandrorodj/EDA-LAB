# Buzón de avisos – AR

Avisos de la P4 para **AR**, agrupados por tema. Cuando arregles uno, márcalo con `[x]` y apunta el commit; lo terminado baja a **Hecho**.
Última revisión: 19-oct-2026 (rama `P4`, sin código todavía).

## Tus tareas (empezar después del `pull` de la Fase 0)
- [x] *(20-oct, `252ea70`)* `ListaElectoral.agregarCandidato` (l. 24-26).
- [x] *(20-oct, `252ea70`: las 4 listas completas y ordenadas)* `GestionElectoral.generarListasElectorales` (l. 61-64): meter cada candidato en su lista según partido y circunscripción, y dejar las 4 **ordenadas por posición** (`Collections.sort`; `Candidato` ya tiene `compareTo`).
- [x] Javadoc de esos dos métodos (aún sin hacer). *(24-oct: javadoc puesto en local, falta commit)*
- [x] Sobra `import java.util.Collection;` (sin `s`): no se usa. *(ya no está)*
- No toques otras partes de `ListaElectoral` ni de `GestionElectoral` (LP y VT trabajan ahí) y no añadas imports: `Collections` lo deja puesto LP.

## Commits
- [ ] *(20-oct)* En `c98f5aa` añadiste javadoc vacío a **todos** los métodos de `GestionElectoral`, también a los de VT y a los del código base. Cada uno documenta **solo sus métodos** (si no, hay conflictos). VT ya borró los suyos.
- [x] Los javadoc que pusiste son mínimos ("Proceso el archivo csv", `@param` sin descripción): poner qué hace y describir cada `@param`. *(24-oct: `@param` descritos en local, falta commit)*
- [ ] Mensajes que digan qué cambia (en P4 ya hay otro "no message", `252ea70`; en P3: "no message", "modificacion penultima", "Luis haz bien el compareTo").

## Hecho
