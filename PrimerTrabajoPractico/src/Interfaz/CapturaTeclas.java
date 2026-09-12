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
        int codigo = e.getKeyCode();
        if (juego.estaTerminado()) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                 juego.reiniciar();  
            }
            return;
        }

        if (codigo == KeyEvent.VK_UP) {
            juego.mover(Direccion.ARRIBA);
        } 
        else if (codigo == KeyEvent.VK_DOWN) {
            juego.mover(Direccion.ABAJO);
        } 
        else if (codigo == KeyEvent.VK_LEFT) {
            juego.mover(Direccion.IZQUIERDA);
        } 
        else if (codigo == KeyEvent.VK_RIGHT) {
            juego.mover(Direccion.DERECHA);
        } 
        else if (codigo == KeyEvent.VK_R) {
            juego.reiniciar();
    }
}
