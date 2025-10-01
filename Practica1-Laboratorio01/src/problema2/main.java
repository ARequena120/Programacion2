package problema2;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de ecuaciones: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese a, b, c: ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            
            EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
            
            if (ecuacion.tieneRaicesReales()) {
                double raiz1 = ecuacion.getRaiz1();
                double raiz2 = ecuacion.getRaiz2();
                if (raiz1 == raiz2) {
                    System.out.printf("La ecuación tiene una raíz: %.5f\n", raiz1);
                } else {
                    System.out.printf("La ecuación tiene dos raíces: %.5f y %.5f\n", raiz1, raiz2);
                }
            } else {
                System.out.println("La ecuación no tiene raíces reales.");
            }
        }
        
        scanner.close();
    }
}
