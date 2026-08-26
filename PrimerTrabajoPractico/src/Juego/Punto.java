package Juego;

public class Punto {

    private final int fila;
    private final int columna;

    public Punto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}