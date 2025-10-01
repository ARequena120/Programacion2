package problema3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] numeros = new double[10];
        ingresarDatos(numeros);
        
        Estadisticas estadisticas = new Estadisticas(numeros);
        double promedio = estadisticas.promedio();
        double desviacion = estadisticas.desviacion();
        
        mostrarResultados(promedio, desviacion);
    }

    
    public static void ingresarDatos(double[] numeros) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese 10 números (solo numero enteros): ");
        for (int i = 0; i < 10; i++) {
            numeros[i] = scanner.nextDouble();
        }
    }

    
    public static void mostrarResultados(double promedio, double desviacion) {
        System.out.printf("El promedio es %.2f\n", promedio);
        System.out.printf("La desviación estándar es %.5f\n", desviacion);
    }
}
