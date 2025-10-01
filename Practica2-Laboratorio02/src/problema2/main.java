package problema2;

public class main {

	public static void main(String[] args) {
	    AlgebraVectorial a = new AlgebraVectorial(2, -1, 3);
	    AlgebraVectorial b = new AlgebraVectorial(4, 5, -2);
	    double escalar = 2.5;

	    // a) Suma de vectores
	    System.out.println("a) Suma: " + a.sumar(b));
	    
	    // b) Multiplicación por escalar
	    System.out.println("\nb) Multiplicación por " + escalar + ":");
	    System.out.println("   a * " + escalar + " = " + a.multiplicar(escalar));
	    System.out.println("   b * " + escalar + " = " + b.multiplicar(escalar));
	    
	    // c) Longitud del vector
	    System.out.println("\nc) Longitudes:");
	    System.out.println("   |a| = " + String.format("%.2f", a.longitud()));
	    System.out.println("   |b| = " + String.format("%.2f", b.longitud()));
	    
	    // d) Vector normalizado
	    System.out.println("\nd) Vectores normalizados:");
	    System.out.println("   â = " + a.normalizar());
	    System.out.println("   b̂ = " + b.normalizar());
	    
	    // e) Producto escalar
	    System.out.println("\ne) Producto escalar:");
	    System.out.println("   a · b = " + a.productoEscalar(b));
	    
	    // f) Producto vectorial
	    System.out.println("\nf) Producto vectorial:");
	    System.out.println("   a × b = " + a.productoVectorial(b));
	    
	    // Verificación de ortogonalidad
	    System.out.println("\nVerificación de ortogonalidad:");
	    System.out.println("   ¿Son ortogonales? " + a.esOrtogonal(b));
	}

}
