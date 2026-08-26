package Juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CapturaTeclas extends KeyAdapter {

    private final Juego juego;
    // Si más adelante quieres reiniciar, puedes recibir también un Controlador o la ventana

    public CapturaTeclas(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (juego.estaTerminado()) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                // juego.reiniciar();  // ← descomentar cuando este implementado
            }
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                juego.mover(Direccion.ARRIBA);
                break;

            case KeyEvent.VK_DOWN:
                juego.mover(Direccion.ABAJO);
                break;

            case KeyEvent.VK_LEFT:
                juego.mover(Direccion.IZQUIERDA);
                break;

            case KeyEvent.VK_RIGHT:
                juego.mover(Direccion.DERECHA);
                break;

            case KeyEvent.VK_R:
                // juego.reiniciar();
                break;
        }
    }
}
