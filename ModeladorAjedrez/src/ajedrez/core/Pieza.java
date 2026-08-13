package ajedrez.core;

import java.util.List;

/**
 * Clase abstracta que representa una pieza de ajedrez cualquiera.
 * Va en el nucleo porque el tablero necesita saber que es una "Pieza"
 * sin importar si es un Peon, una Torre, etc.
 *
 * Cada pieza especifica (en features/piezas) hereda de esta clase
 * y define COMO se mueve.
 */
public abstract class Pieza {

    protected Color color;
    protected Posicion posicion;

    public Pieza(Color color, Posicion posicion) {
        this.color = color;
        this.posicion = posicion;
    }

    public Color getColor() {
        return color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void moverA(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    /**
     * Cada pieza concreta debe decir cuales son sus movimientos posibles
     * segun donde este parada y como esta el tablero.
     */
    public abstract List<Posicion> movimientosPosibles(Tablero tablero);

    /**
     * Letra que representa la pieza al imprimir el tablero (P, T, C, A, R, D)
     */
    public abstract String getSimbolo();

    @Override
    public String toString() {
        return (color == Color.BLANCO ? "B" : "N") + getSimbolo();
    }
}
