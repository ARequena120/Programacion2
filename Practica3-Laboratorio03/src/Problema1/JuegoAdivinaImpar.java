package Problema1;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero % 2 == 0) {
            System.out.println("Error: Solo números impares permitidos (0-10).");
            return false;
        }
        return super.validaNumero(numero);
    }

    @Override
    public void juega() {
        reiniciaPartida();

        Random random = new Random();
        this.numeroAAdivinar = (random.nextInt(5) * 2) + 1; // 1,3,5,7,9
        System.out.println("¡Bienvenido al juego de adivinar el número IMPAR!");
        System.out.println("He pensado en un número IMPAR entre 0 y 10. Tienes " + getNumeroDeVidas() + " vidas.");

        Scanner scanner = new Scanner(System.in);
        boolean acertado = false;

        while (!acertado && getNumeroDeVidas() > 0) {
            System.out.print("Adivina el número IMPAR (0-10): ");
            int intento = scanner.nextInt();

            if (!validaNumero(intento)) {
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
