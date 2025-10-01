package problema1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Ingrese a, b, c, d, e, f: ");
	        double a = scanner.nextDouble();
	        double b = scanner.nextDouble();
	        double c = scanner.nextDouble();
	        double d = scanner.nextDouble();
	        double e = scanner.nextDouble();
	        double f = scanner.nextDouble();
	        
	        ecuacion_lineal s = new ecuacion_lineal(a, b, c, d, e, f);
	        
	        if (s.tieneSolucion()) {
	            System.out.printf("x = %.1f, y = %.1f\n", s.getX(), s.getY());
	        } else {
	            System.out.println("No tiene solucion");
	        }
	        
	        scanner.close();
	    }
    }

