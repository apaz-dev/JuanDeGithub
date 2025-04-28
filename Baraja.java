import java.util.ArrayList;
import java.util.List;

public class Baraja {

    private final String[] palos = {"Picas", "Corazones", "Tréboles", "Diamantes"};
    private final List<String> baraja = new ArrayList<>();
    private final List<String> manoJugador = new ArrayList<>();
    private final List<String> manoCrupier = new ArrayList<>();

    // Crear la baraja
    public void crearBaraja() {
        for (String palo : palos) {
            for (int numero = 1; numero <= 12; numero++) {
                baraja.add(numero + " de " + palo);
            }
        }
    }

    // Robar una carta de la baraja
    public String robarCarta() {
        if (!baraja.isEmpty()) {
            return baraja.remove(0);
        }
        return null;
    }

    // Accesores para las manos
    public List<String> getManoJugador() {
        return manoJugador;
    }

    public List<String> getManoCrupier() {
        return manoCrupier;
    }

    // Agregar carta a una mano
    public void agregarCartaJugador(String carta) {
        if (carta != null) manoJugador.add(carta);
    }

    public void agregarCartaCrupier(String carta) {
        if (carta != null) manoCrupier.add(carta);
    }

    // Obtener baraja para barajarla desde fuera
    public List<String> getBaraja() {
        return baraja;
    }

    // Evaluar situación de juego
    public static boolean valorar(int valorJugador, int valorCrupier) {
        if (valorJugador > 21) {
            System.out.println("\nTu mano supera 21, ¡El crupier gana!");
            return false;
        } else if (valorCrupier > 21) {
            System.out.println("\nLa mano del crupier supera 21, ¡Tú ganas!");
            return false;
        } else {
            return true;
        }
    }
}