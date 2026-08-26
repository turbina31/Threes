package Juego;

public class Controlador {
	private final Estado estado;
    private final Mover motorMovimiento;
    private final ActualizarInterfaz actualizador;

    public Controlador(Estado estado, 
                       Mover motorMovimiento, 
                       ActualizarInterfaz actualizador) {
        this.estado = estado;
        this.motorMovimiento = motorMovimiento;
        this.actualizador = actualizador;
    }

    /**
     * Intenta mover el tablero en la dirección indicada.
     */
    public boolean intentarMover(char direccion) {
        if (estado.estaJuegoTerminado()) {
            return false;
        }

        boolean seMovio = motorMovimiento.intentarMover(direccion);

        if (seMovio) {
            actualizador.actualizar();
        }

        //ventana.requestFocusInWindow();
        return seMovio;
    }

    /**
     * Reinicia completamente el juego.
     */
    public void reiniciarJuego() {
        estado.reiniciar();
        actualizador.actualizar();
        //ventana.requestFocusInWindow();
    }

    /**
     * Permite saber si el juego terminó (lo usa CapturaTeclas).
     */
    public boolean estaJuegoTerminado() {
        return estado.estaJuegoTerminado();
    }
}
