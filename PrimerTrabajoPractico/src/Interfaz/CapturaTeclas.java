package Interfaz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Juego.Juego;
import Juego.Direccion;

public class CapturaTeclas extends KeyAdapter {

    private final Juego juego;
    
    public CapturaTeclas(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (juego.estaTerminado()) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                 juego.reiniciar();  
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
                 juego.reiniciar();
                break;
        }
    }
}
