package ajedrez.features.piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.core.Color;
import ajedrez.core.Pieza;
import ajedrez.core.Posicion;
import ajedrez.core.Tablero;

/**
 * Feature: Caballo.
 * Se mueve en forma de "L": 2 casillas en una direccion + 1 perpendicular.
 * Es la unica pieza que puede saltar sobre otras.
 */
public class Caballo extends Pieza {

    public Caballo(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public List<Posicion> movimientosPosibles(Tablero tablero) {
        List<Posicion> movimientos = new ArrayList<>();
        int[][] saltos = {
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
        };

        for (int[] salto : saltos) {
            Posicion destino = new Posicion(posicion.getFila() + salto[0], posicion.getColumna() + salto[1]);
            if (destino.esValida()) {
                if (tablero.estaVacia(destino) || tablero.hayPiezaEnemigaEn(destino, color)) {
                    movimientos.add(destino);
                }
            }
        }

        return movimientos;
    }

    @Override
    public String getSimbolo() {
        return "C";
    }
}
