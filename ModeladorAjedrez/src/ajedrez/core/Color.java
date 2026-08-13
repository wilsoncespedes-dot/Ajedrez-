package ajedrez.core;

/**
 * Representa el color de una pieza o de un jugador.
 * Vive en el nucleo porque TODO en el tablero depende de esto.
 */
public enum Color {
    BLANCO,
    NEGRO;

    public Color contrario() {
        return this == BLANCO ? NEGRO : BLANCO;
    }
}
