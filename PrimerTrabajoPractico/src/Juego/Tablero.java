package Juego;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private final int filas;
    private final int columnas;
    private final Ficha[][] celdas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Ficha[filas][columnas];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Ficha getFicha(int fila, int columna) {
        return celdas[fila][columna];
    }

    public boolean estaVacia(int fila, int columna) {
        return celdas[fila][columna] == null;
    }

    public void colocarFicha(int fila, int columna, Ficha ficha) {
        celdas[fila][columna] = ficha;
    }

    public List<Punto> celdasLibres() {
        List<Punto> libres = new ArrayList<>();
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (celdas[f][c] == null) {
                    libres.add(new Punto(f, c));
                }
            }
        }
        return libres;
    }

    public boolean mover(Direccion direccion) {
        boolean huboCambios = false;

        if (direccion == Direccion.IZQUIERDA || direccion == Direccion.DERECHA) {
            boolean invertida = direccion == Direccion.DERECHA;
            for (int f = 0; f < filas; f++) {
                List<Ficha> linea = extraerFila(f, invertida);
                boolean cambio = moverLinea(linea);
                insertarFila(f, linea, invertida);
                huboCambios = huboCambios || cambio;
            }
        } else {
            boolean invertida = direccion == Direccion.ABAJO;
            for (int c = 0; c < columnas; c++) {
                List<Ficha> linea = extraerColumna(c, invertida);
                boolean cambio = moverLinea(linea);
                insertarColumna(c, linea, invertida);
                huboCambios = huboCambios || cambio;
            }
        }

        return huboCambios;
    }

    public boolean hayMovimientosPosibles() {
        for (Direccion direccion : Direccion.values()) {
            if (clonar().mover(direccion)) {
                return true;
            }
        }
        return false;
    }

    private List<Ficha> extraerFila(int fila, boolean invertida) {
        List<Ficha> linea = new ArrayList<>();
        if (!invertida) {
            for (int c = 0; c < columnas; c++) {
                linea.add(celdas[fila][c]);
            }
        } else {
            for (int c = columnas - 1; c >= 0; c--) {
                linea.add(celdas[fila][c]);
            }
        }
        return linea;
    }

    private void insertarFila(int fila, List<Ficha> linea, boolean invertida) {
        for (int c = 0; c < columnas; c++) {
            int destino = invertida ? (columnas - 1 - c) : c;
            celdas[fila][destino] = linea.get(c);
        }
    }

    private List<Ficha> extraerColumna(int columna, boolean invertida) {
        List<Ficha> linea = new ArrayList<>();
        if (!invertida) {
            for (int f = 0; f < filas; f++) {
                linea.add(celdas[f][columna]);
            }
        } else {
            for (int f = filas - 1; f >= 0; f--) {
                linea.add(celdas[f][columna]);
            }
        }
        return linea;
    }

    private void insertarColumna(int columna, List<Ficha> linea, boolean invertida) {
        for (int f = 0; f < filas; f++) {
            int destino = invertida ? (filas - 1 - f) : f;
            celdas[destino][columna] = linea.get(f);
        }
    }

    /**
     * Mueve y fusiona una linea (fila o columna) ya orientada, donde el indice
     * 0 es el "frente" hacia donde se mueve. Cada ficha avanza a lo sumo una
     * celda, tal como especifica la consigna. Modifica la lista recibida.
     */
    private boolean moverLinea(List<Ficha> linea) {
        boolean cambio = false;

        for (int i = 0; i < linea.size() - 1; i++) {
            Ficha actual = linea.get(i);
            Ficha siguiente = linea.get(i + 1);

            if (siguiente == null) {
                continue;
            }

            if (actual == null) {
                linea.set(i, siguiente);
                linea.set(i + 1, null);
                cambio = true;
            } else if (actual.puedeFusionarseCon(siguiente)) {
                linea.set(i, actual.fusionar(siguiente));
                linea.set(i + 1, null);
                cambio = true;
            }
        }

        return cambio;
    }

    private Tablero clonar() {
        Tablero copia = new Tablero(filas, columnas);
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                copia.celdas[f][c] = celdas[f][c];
            }
        }
        return copia;
    }
}