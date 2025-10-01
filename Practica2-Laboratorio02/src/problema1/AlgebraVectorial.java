package problema1;


public class AlgebraVectorial {
    private final double[] a;
    private final double[] b;
    private static final double TOLERANCIA = 1e-12;

    public AlgebraVectorial(double[] vectorA, double[] vectorB) {
        if (vectorA.length != 3 || vectorB.length != 3) {
            throw new IllegalArgumentException("Vectores deben ser 3D");
        }
        this.a = vectorA.clone();
        this.b = vectorB.clone();
    }

    // Verifica perpendicularidad usando producto punto
    public boolean sonPerpendiculares() {
        return Math.abs(productoPunto(a, b)) < TOLERANCIA;
    }

    // Verifica paralelismo usando producto cruz
    public boolean sonParalelos() {
        double[] cruz = productoCruz(a, b);
        return magnitud(cruz) < TOLERANCIA;
    }

    // Calcula proyección vectorial: (a·b / |b|²) * b
    public double[] proyeccionASobreB() {
        double escalar = productoPunto(a, b) / Math.pow(magnitud(b), 2);
        return escalarPorVector(escalar, b);
    }

    // --- Métodos auxiliares privados ---
    private double productoPunto(double[] v1, double[] v2) {
        return v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2];
    }

    private double[] productoCruz(double[] v1, double[] v2) {
        return new double[]{
            v1[1]*v2[2] - v1[2]*v2[1],
            v1[2]*v2[0] - v1[0]*v2[2],
            v1[0]*v2[1] - v1[1]*v2[0]
        };
    }

    private double magnitud(double[] v) {
        return Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
    }

    private double[] escalarPorVector(double escalar, double[] vector) {
        return new double[]{
            escalar * vector[0],
            escalar * vector[1],
            escalar * vector[2]
        };
    }
}
