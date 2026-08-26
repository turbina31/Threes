package Juego;

import java.util.ArrayList;
import java.util.List;

public class Mover {
	private final Estado estado;

    public Mover(Estado estado) {
        this.estado = estado;
    }

    /**
     * Método principal de esta clase.
     * Intenta mover el tablero en la dirección indicada.
     */
    public boolean intentarMover(char direccion) {
        return mover(direccion);
    }

    // ==================== LÓGICA INTERNA ====================

    private boolean mover(char direccion) {
        List<Integer> lineasMovidas = new ArrayList<>();

        switch (direccion) {
            case 'w':
                for (int columna = 0; columna < Estado.tamanio(); columna++) {
                    if (moverColumnaArriba(columna)) {
                        lineasMovidas.add(columna);
                    }
                }
                break;
            case 's':
                for (int columna = 0; columna < Estado.tamanio(); columna++) {
                    if (moverColumnaAbajo(columna)) {
                        lineasMovidas.add(columna);
                    }
                }
                break;
            case 'a':
                for (int fila = 0; fila < Estado.tamanio(); fila++) {
                    if (moverFilaIzquierda(fila)) {
                        lineasMovidas.add(fila);
                    }
                }
                break;
            case 'd':
                for (int fila = 0; fila < Estado.tamanio(); fila++) {
                    if (moverFilaDerecha(fila)) {
                        lineasMovidas.add(fila);
                    }
                }
                break;
        }
    }

    private boolean moverFilaIzquierda(int fila) {
        boolean seMovio = false;
        
        return seMovio;
    }

    private boolean moverFilaDerecha(int fila) {
        boolean seMovio = false;
        
        return seMovio;
    }

    private boolean moverColumnaArriba(int columna) {
        boolean seMovio = false;
        
        return seMovio;
    }

    private boolean moverColumnaAbajo(int columna) {
        boolean seMovio = false;
        
        return seMovio;
    }


    private boolean tablerosIguales(int[][] a, int[][] b) {
        for (int i = 0; i < Estado.tamanio(); i++) {
            for (int j = 0; j < Estado.tamanio(); j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
