package ajedrez.features.juego;

import java.util.List;

import ajedrez.core.Color;
import ajedrez.core.Pieza;
import ajedrez.core.Posicion;
import ajedrez.core.Tablero;
import ajedrez.features.piezas.Caballo;
import ajedrez.features.piezas.Peon;
import ajedrez.features.piezas.Reina;
import ajedrez.features.piezas.Rey;
import ajedrez.features.piezas.Torre;

/**
 * Punto de entrada para probar el modelador.
 * Aqui se ve como el nucleo (Tablero, Pieza, Posicion) y las
 * features (Peon, Torre, Caballo, Reina, Rey) trabajan juntas.
 */
public class Main {

    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        // Colocamos algunas piezas blancas
        tablero.colocarPieza(new Torre(Color.BLANCO, new Posicion(7, 0)));
        tablero.colocarPieza(new Caballo(Color.BLANCO, new Posicion(7, 1)));
        tablero.colocarPieza(new Rey(Color.BLANCO, new Posicion(7, 4)));
        tablero.colocarPieza(new Reina(Color.BLANCO, new Posicion(7, 3)));
        tablero.colocarPieza(new Peon(Color.BLANCO, new Posicion(6, 4)));

        // Y algunas piezas negras
        tablero.colocarPieza(new Torre(Color.NEGRO, new Posicion(0, 0)));
        tablero.colocarPieza(new Rey(Color.NEGRO, new Posicion(0, 4)));
        tablero.colocarPieza(new Peon(Color.NEGRO, new Posicion(1, 4)));

        System.out.println("Tablero inicial:");
        tablero.imprimirTablero();

        // Probamos los movimientos posibles de la Reina blanca
        Pieza reina = tablero.obtenerPieza(new Posicion(7, 3));
        List<Posicion> movimientos = reina.movimientosPosibles(tablero);

        System.out.println("\nLa Reina blanca en " + reina.getPosicion() + " puede moverse a:");
        for (Posicion p : movimientos) {
            System.out.print(p + " ");
        }

        // Movemos el peon blanco dos casillas hacia adelante
        System.out.println("\n\nMovemos el peon blanco de e2 a e4...");
        tablero.moverPieza(new Posicion(6, 4), new Posicion(4, 4));
        tablero.imprimirTablero();
    }
}
