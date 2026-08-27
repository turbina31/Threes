package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {

    private Tablero tablero;
    private final List<ObservadorJuego> observadores;
    private final Random random;

    private int puntaje;
    private Ficha proximaFicha;
    private boolean terminado;

    public Juego() {
        this.observadores = new ArrayList<>();
        this.random = new Random();
        inicializarPartida();
    }

    public void registrarObservador(ObservadorJuego observador) {
        observadores.add(observador);
    }

    public void reiniciar() {
        inicializarPartida();
        notificarObservadores();
    }

    private void inicializarPartida() {
        this.tablero = new Tablero(4, 4);
        this.puntaje = 0;
        this.terminado = false;

        colocarFichasIniciales();
        this.proximaFicha = generarFichaAleatoria();
    }

    public void mover(Direccion direccion) {
        if (terminado) {
            return;
        }

        boolean huboCambios = tablero.mover(direccion);

        if (huboCambios) {
            agregarFichaNueva();
            actualizarPuntaje();
            verificarFinDePartida();
            notificarObservadores();
        }
    }

    public boolean estaTerminado() {
        return terminado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Ficha getProximaFicha() {
        return proximaFicha;
    }

    private void colocarFichasIniciales() {
        // Coloca algunas fichas para arrancar la partida (cantidad y
        // posiciones a definir con el resto del grupo si quieren variarlo)
        for (int i = 0; i < 9; i++) {
            List<Punto> libres = tablero.celdasLibres();
            Punto destino = libres.get(random.nextInt(libres.size()));
            tablero.colocarFicha(destino.getFila(), destino.getColumna(), generarFichaAleatoria());
        }
    }

    private void agregarFichaNueva() {
        List<Punto> libres = tablero.celdasLibres();
        if (libres.isEmpty()) {
            return;
        }
        Punto destino = libres.get(random.nextInt(libres.size()));
        tablero.colocarFicha(destino.getFila(), destino.getColumna(), proximaFicha);
        proximaFicha = generarFichaAleatoria();
    }

    private Ficha generarFichaAleatoria() {
        int valor = random.nextInt(3) + 1; // 1, 2 o 3
        return new Ficha(valor);
    }

    private void actualizarPuntaje() {
        int total = 0;
        for (int f = 0; f < tablero.getFilas(); f++) {
            for (int c = 0; c < tablero.getColumnas(); c++) {
                Ficha ficha = tablero.getFicha(f, c);
                if (ficha != null) {
                    total += ficha.getPuntaje();
                }
            }
        }
        puntaje = total;
    }

    private void verificarFinDePartida() {
        if (!tablero.hayMovimientosPosibles()) {
            terminado = true;
        }
    }

    private void notificarObservadores() {
        for (ObservadorJuego observador : observadores) {
            observador.notificar(this);
        }
    }
}