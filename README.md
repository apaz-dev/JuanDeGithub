# Proyecto: BlackJack

Este proyecto implementa el popular juego de cartas **BlackJack** utilizando dos clases principales: `Baraja.java` y `BlackJack.java`.

## Descripción de los archivos

### 1. `Baraja.java`
Esta clase representa una baraja de cartas estándar. Incluye funcionalidades para:
- Crear una baraja con 52 cartas (13 valores por cada uno de los 4 palos: corazones, diamantes, tréboles y picas).
- Barajar las cartas de manera aleatoria.
- Repartir cartas, eliminándolas de la baraja.

### 2. `BlackJack.java`
Esta clase implementa la lógica del juego BlackJack. Incluye:
- Reglas básicas del juego: el objetivo es alcanzar 21 puntos o acercarse lo máximo posible sin pasarse.
- Gestión de jugadores y el crupier.
- Reparto inicial de cartas y mecánica para "pedir" o "plantarse".
- Determinación del ganador según las reglas del BlackJack.

## Cómo funciona el código
1. **Inicialización**: Se crea una instancia de `Baraja` para generar y barajar las cartas.
2. **Reparto inicial**: Cada jugador (incluido el crupier) recibe dos cartas.
3. **Turnos**: Los jugadores deciden si quieren pedir más cartas o plantarse.
4. **Cálculo de resultados**: Se suman los valores de las cartas para determinar el puntaje de cada jugador.
5. **Ganador**: El jugador más cercano a 21 puntos sin pasarse gana la partida.

## Requisitos
- Java 8 o superior.
- Compilador de Java (por ejemplo, `javac`).

## Ejecución
1. Compila los archivos:
	```bash
	javac Baraja.java BlackJack.java
	```
2. Ejecuta el programa principal:
	```bash
	java BlackJack
	```

¡Disfruta jugando al BlackJack con este proyecto en Java!