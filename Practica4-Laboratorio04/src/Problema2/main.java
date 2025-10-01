package Problema2;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rand = new Random();
        Figura[] figuras = new Figura[5];
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Negro"};
        
        for(int i = 0; i < 5; i++) {
            int tipo = rand.nextInt(2) + 1;
            String color = colores[rand.nextInt(colores.length)];
            double dimension = rand.nextDouble() * 10 + 1;
            
            figuras[i] = (tipo == 1) 
                ? new Cuadrado(color, dimension)
                : new Circulo(color, dimension);
        }
        
        System.out.println("=== REPORTE DE FIGURAS ===");
        for(Figura figura : figuras) {
            System.out.println("\n" + figura);
            System.out.printf("Área: %.2f | Perímetro: %.2f%n", 
                            figura.area(), figura.perimetro());
            
            if(figura instanceof Coloreado) {
                System.out.println("Método colorear: " + 
                                ((Coloreado)figura).comoColorear());
            }
        }
    }
}
