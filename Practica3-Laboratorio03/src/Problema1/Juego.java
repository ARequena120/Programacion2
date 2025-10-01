package Problema1;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    private int numeroDeVidas;
    private int record;
    private int vidasInicial;

    public Juego(int vidasInicial) {
        this.vidasInicial = vidasInicial;
        this.numeroDeVidas = vidasInicial;
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = this.vidasInicial;
    }

    public void actualizaRecord() {
        this.record++;
        System.out.println("¡Nuevo record actualizado! Victorias totales: " + this.record);
    }

    public boolean quitaVida() {
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }

    public int getNumeroDeVidas() {
        return numeroDeVidas;
    }

    public int getRecord() {
        return record;
    }
}
