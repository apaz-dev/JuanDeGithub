import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    /*public static void main(String[] args) {
        Baraja baraja = new Baraja();
        baraja.crearBaraja();
        Collections.shuffle(baraja.getBaraja());

        // Repartir cartas iniciales
        baraja.agregarCartaJugador(baraja.robarCarta());
        baraja.agregarCartaJugador(baraja.robarCarta());
        baraja.agregarCartaCrupier(baraja.robarCarta());
        baraja.agregarCartaCrupier(baraja.robarCarta()); // esta se mostrará después

        boolean juegoEnCurso = true;
        boolean jugadorSePlanta = false;
        boolean crupierSePlanta = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- ¡EMPEZAMOS! --------");

        while (juegoEnCurso) {
            int valorJugador = calcularValorMano(baraja.getManoJugador());
            int valorCrupier = calcularValorMano(baraja.getManoCrupier());

            juegoEnCurso = Baraja.valorar(valorJugador, valorCrupier);
            if (!juegoEnCurso) break;

            // Mostrar cartas del jugador
            System.out.println("\nTu mano:");
            mostrarCartas(baraja.getManoJugador());
            System.out.println("Valor total: " + valorJugador);

            // Mostrar UNA carta del crupier (al inicio)
            System.out.println("\nCarta visible del crupier:");
            System.out.println(baraja.getManoCrupier().get(0));

            // Preguntar al jugador
            if (!jugadorSePlanta) {
                System.out.println("\n¿Qué deseas hacer? (1 = Pedir carta, 2 = Plantarte)");

                int opcion = -1;
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                } else {
                    scanner.next(); // limpiar entrada
                }

                if (opcion == 1) {
                    baraja.agregarCartaJugador(baraja.robarCarta());
                    System.out.println("Pides una carta.");
                } else if (opcion == 2) {
                    jugadorSePlanta = true;
                    System.out.println("Te plantas.");
                } else {
                    System.out.println("Opción inválida.");
                }
            }

            // Turno del crupier
            if (!crupierSePlanta) {
                crupierSePlanta = decidirCrupier(baraja);
            }

            // Ambos se plantaron
            if (jugadorSePlanta && crupierSePlanta) {
                System.out.println("\n--- Fin de la partida ---");

                // Mostrar todo
                System.out.println("\nTu mano final:");
                mostrarCartas(baraja.getManoJugador());
                System.out.println("Valor: " + valorJugador);

                System.out.println("\nMano completa del crupier:");
                mostrarCartas(baraja.getManoCrupier());
                System.out.println("Valor: " + valorCrupier);

                if (valorJugador > valorCrupier) {
                    System.out.println("\n¡Ganas tú!");
                } else if (valorCrupier > valorJugador) {
                    System.out.println("\nGana el crupier.");
                } else {
                    System.out.println("\n¡Empate!");
                }

                juegoEnCurso = false;
            }
        }

        scanner.close();
    }*/

    // Lógica del crupier
    public static boolean decidirCrupier(Baraja baraja) {
        int valorCrupier = calcularValorMano(baraja.getManoCrupier());
        Random random = new Random();

        if (valorCrupier < 12) {
            baraja.agregarCartaCrupier(baraja.robarCarta());
            System.out.println("El crupier pide carta (menos de 12).");
            return false;
        } else if (valorCrupier < 17) {
            if (random.nextBoolean()) {
                baraja.agregarCartaCrupier(baraja.robarCarta());
                System.out.println("El crupier decide pedir carta.");
                return false;
            } else {
                System.out.println("El crupier decide plantarse.");
                return true;
            }
        } else {
            System.out.println("El crupier se planta (tiene 17 o más).");
            return true;
        }
    }

    // Cálculo del valor de la mano
    public static int calcularValorMano(List<String> mano) {
        int total = 0;
        int ases = 0;

        for (String carta : mano) {
            String[] partes = carta.split(" ");
            int valor;

            try {
                valor = Integer.parseInt(partes[0]);
                if (valor > 10) valor = 10;
            } catch (NumberFormatException e) {
                valor = 11;
                ases++;
            }

            total += valor;
        }

        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }

    // Mostrar cartas
    public static void mostrarCartas(List<String> mano) {
        for (String carta : mano) {
            System.out.println("- " + carta);
        }
    }
}
