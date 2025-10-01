package problema1;



public class main {
    public static void main(String[] args) {
        double[] a = {2, 3, 4};
        double[] b = {5, 6, 7};
        
        AlgebraVectorial algebra = new AlgebraVectorial(a, b);
        
        // Resultados con formato printf
        System.out.println("Perpendiculares: " + algebra.sonPerpendiculares());
        System.out.println("Paralelos: " + algebra.sonParalelos());
        
        double[] proyeccion = algebra.proyeccionASobreB();
        System.out.printf("Proyección A sobre B: [%.3f, %.3f, %.3f]%n", 
            proyeccion[0], 
            proyeccion[1], 
            proyeccion[2]);
    }
}

