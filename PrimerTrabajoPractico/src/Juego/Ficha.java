package Juego;

public class Ficha {

    private final int valor;

    public Ficha(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public boolean puedeFusionarseCon(Ficha otra) {
        if (otra == null) {
            return false;
        }
        if ((valor == 1 && otra.valor == 2) || (valor == 2 && otra.valor == 1)) {
            return true;
        }
        
        if (valor >= 3 && valor == otra.valor) {
            return true;
        }

        return false;
    }

    public Ficha fusionar(Ficha otra) {
        if (!puedeFusionarseCon(otra)) {
            throw new IllegalArgumentException("Estas fichas no se pueden fusionar");
        }
        return new Ficha(valor + otra.valor);
    }

    public int getPuntaje() {
        if (valor == 1 || valor == 2) {
            return 0;
        }
        return (int) Math.pow(3, valor / 3);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}