package Problema1;

import java.util.Random;
import java.util.Scanner;
public class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    public void juega() {
        reiniciaPartida();

        Random random = new Random();
        this.numeroAAdivinar = random.nextInt(11);
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("He pensado en un número entre 0 y 10. Tienes " + getNumeroDeVidas() + " vidas.");

        Scanner scanner = new Scanner(System.in);
        boolean acertado = false;

        while (!acertado && getNumeroDeVidas() > 0) {
            System.out.print("Adivina el número (0-10): ");
            int intento = scanner.nextInt();

            if (!validaNumero(intento)) {
                System.out.println("Número inválido. Debe estar entre 0 y 10. Intenta de nuevo.");
                continue;
            }

            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!!");
                actualizaRecord();
                acertado = true;
            } else {
                boolean quedanVidas = quitaVida();
                if (!quedanVidas) {
                    System.out.println("¡Te has quedado sin vidas! El número era: " + numeroAAdivinar);
                } else {
                    if (intento < numeroAAdivinar) {
                        System.out.println("El número a adivinar es MAYOR. Te quedan " + getNumeroDeVidas() + " vidas.");
                    } else {
                        System.out.println("El número a adivinar es MENOR. Te quedan " + getNumeroDeVidas() + " vidas.");
                    }
                }
            }
        }

        if (!acertado) {
            System.out.println("¡Fin del juego! Mejor suerte la próxima vez.");
        } else {
            System.out.println("¡Juego completado!");
        }

    }
}
