package Juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CapturaTeclas extends KeyAdapter {

    private final Controlador controlador;

    public CapturaTeclas(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (controlador.estaJuegoTerminado() && e.getKeyCode() != KeyEvent.VK_R) {
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                controlador.intentarMover('w');
                break;
            case KeyEvent.VK_DOWN:
                controlador.intentarMover('s');
                break;
            case KeyEvent.VK_LEFT:
                controlador.intentarMover('a');
                break;
            case KeyEvent.VK_RIGHT:
                controlador.intentarMover('d');
                break;
            case KeyEvent.VK_R:
                controlador.reiniciarJuego();
                break;
        }
    }
}
