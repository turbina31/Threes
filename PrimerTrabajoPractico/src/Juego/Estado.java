package Juego;

import java.util.Random;

public class Estado {
	private static final int TAMANO = 4;

    public int[][] tablero = new int[TAMANO][TAMANO];
    private Random aleatorio = new Random();
    private int puntuacion = 0;
    private int siguienteFicha = 1;
    private boolean juegoTerminado = false;

    public Estado() {
        inicializarTablero();
        generarSiguienteFicha();
    }

    public void inicializarTablero() {
        
    }

    public void generarSiguienteFicha() {
        int r = aleatorio.nextInt(21);
        if (r < 4) {
            siguienteFicha = 1;
        } else if (r < 8) {
            siguienteFicha = 2;
        } else {
            siguienteFicha = 3;
        }
    }

    public void reiniciar() {
        inicializarTablero();
        generarSiguienteFicha();
        puntuacion = 0;
        juegoTerminado = false;
    }

    
	public static int tamanio() {
		return TAMANO;
	}

	public boolean estaJuegoTerminado() {
		return juegoTerminado;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getSiguienteFicha() {
		return siguienteFicha;
	}
    
    
}
