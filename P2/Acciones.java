package P2;

public class Acciones {

    public static String robar(Accion accion){
        if (mazoDeRobo.empty()) {
            while (!mazoDeDescartes.empty()) {
                mazoDeRobo.push(mazoDeDescartes.pop());
            }
        }
    
        if (mazoDeRobo.empty()) {
            System.out.println("Está vacío");
        } else {
            Carta carta = mazoDeRobo.pop();
            System.out.println(accion.getJugador() + " roba " + carta);
        }
    }

    public static String jugar(Accion accion){
        pilaEfectos.push(accion);
    }

    public static String descartar(){
        return "";
    }

    public static String resolver(){
        return "";
    }
}
