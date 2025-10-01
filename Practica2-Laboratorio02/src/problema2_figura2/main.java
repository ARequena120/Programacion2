package problema2_figura2;

public class main {

	 public static void main(String[] args) {
	        Vector a = new Vector(2, 3, 1);
	        Vector b = new Vector(1, -1, 2);
	        
	        System.out.println("Proyección de a sobre b: " + a.proyectarSobre(b));
	        System.out.println("Componente de a sobre b: " + String.format("%.2f", a.componenteSobre(b)));
	    }

}
