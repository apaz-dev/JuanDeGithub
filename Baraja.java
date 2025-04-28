import java.util.ArrayList;
import java.util.List;

public class Baraja {

    String[] palos = {"Picas", "Corazones", "Tréboles", "Diamantes"};
    List<String> baraja = new ArrayList<>();
    List<String> manojugador = new ArrayList<>();
    List<String> manocrupier = new ArrayList<>();


    public void CrearBaraja() {
            // Crear la baraja de cartas
            for (String palo : palos) {
                for (int numero = 1; numero <= 12; numero++) {
                    baraja.add(numero + " de " + palo);
                }
            }
    }

    public static boolean Valorar( int valorJugador, int valorCrupier) {

        if (valorJugador > 21) {
            System.out.println("\nTu mano  supera 21, ¡El crupier gana!");
            return false;
        } else if (valorCrupier > 21) {
            System.out.println("\nLa mano  del crupier supera 21, ¡Tú ganas!");
            return false;
        } else return true;
    }
}
