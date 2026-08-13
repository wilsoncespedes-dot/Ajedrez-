package ajedrez.core;

/**
 * Representa el tablero de 8x8 y administra donde esta cada pieza.
 * Es el corazon del nucleo: sin Tablero, ninguna pieza puede funcionar.
 */
public class Tablero {

    private final Pieza[][] casillas;

    public Tablero() {
        casillas = new Pieza[8][8];
    }

    public void colocarPieza(Pieza pieza) {
        Posicion pos = pieza.getPosicion();
        casillas[pos.getFila()][pos.getColumna()] = pieza;
    }

    public Pieza obtenerPieza(Posicion pos) {
        if (!pos.esValida()) return null;
        return casillas[pos.getFila()][pos.getColumna()];
    }

    public boolean estaVacia(Posicion pos) {
        return obtenerPieza(pos) == null;
    }

    public boolean hayPiezaEnemigaEn(Posicion pos, Color colorPropio) {
        Pieza p = obtenerPieza(pos);
        return p != null && p.getColor() != colorPropio;
    }

    public void moverPieza(Posicion origen, Posicion destino) {
        Pieza pieza = obtenerPieza(origen);
        if (pieza == null) {
            System.out.println("No hay pieza en " + origen);
            return;
        }
        casillas[origen.getFila()][origen.getColumna()] = null;
        pieza.moverA(destino);
        casillas[destino.getFila()][destino.getColumna()] = pieza;
    }

    public void imprimirTablero() {
        for (int fila = 0; fila < 8; fila++) {
            System.out.print((8 - fila) + " ");
            for (int col = 0; col < 8; col++) {
                Pieza p = casillas[fila][col];
                System.out.print((p == null ? " ." : p.toString()) + " ");
            }
            System.out.println();
        }
        System.out.println("   a  b  c  d  e  f  g  h");
    }
}
