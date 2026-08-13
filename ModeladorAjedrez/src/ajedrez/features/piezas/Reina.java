package ajedrez.features.piezas;

import java.util.ArrayList;
import java.util.List;

import ajedrez.core.Color;
import ajedrez.core.Pieza;
import ajedrez.core.Posicion;
import ajedrez.core.Tablero;

/**
 * Feature: Reina.
 * Se mueve como Torre + Alfil combinados: recto o en diagonal.
 * Aqui se ve otra ventaja de la herencia: reutilizamos objetos Torre y
 * Alfil "temporales" solo para pedirles sus movimientos, sin repetir codigo.
 */
public class Reina extends Pieza {

    public Reina(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public List<Posicion> movimientosPosibles(Tablero tablero) {
        List<Posicion> movimientos = new ArrayList<>();

        Torre comoTorre = new Torre(color, posicion);
        Alfil comoAlfil = new Alfil(color, posicion);

        movimientos.addAll(comoTorre.movimientosPosibles(tablero));
        movimientos.addAll(comoAlfil.movimientosPosibles(tablero));

        return movimientos;
    }

    @Override
    public String getSimbolo() {
        return "D"; // Dama
    }
}
