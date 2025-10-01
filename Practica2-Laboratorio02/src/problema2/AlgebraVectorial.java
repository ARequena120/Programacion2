package problema2;

public class AlgebraVectorial {
    private final double x;
    private final double y;
    private final double z;

    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // a) Suma de vectores
    public AlgebraVectorial sumar(AlgebraVectorial otro) {
        return new AlgebraVectorial(
            this.x + otro.x,
            this.y + otro.y,
            this.z + otro.z
        );
    }

    // b) Multiplicación por escalar
    public AlgebraVectorial multiplicar(double escalar) {
        return new AlgebraVectorial(
            escalar * this.x,
            escalar * this.y,
            escalar * this.z
        );
    }

    // c) Longitud del vector
    public double longitud() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    // d) Vector normalizado
    public AlgebraVectorial normalizar() {
        double magnitud = this.longitud();
        return new AlgebraVectorial(
            x/magnitud,
            y/magnitud,
            z/magnitud
        );
    }

    // e) Producto escalar
    public double productoEscalar(AlgebraVectorial otro) {
        return this.x*otro.x + this.y*otro.y + this.z*otro.z;
    }

    // f) Producto vectorial
    public AlgebraVectorial productoVectorial(AlgebraVectorial otro) {
        return new AlgebraVectorial(
            this.y*otro.z - this.z*otro.y,
            this.z*otro.x - this.x*otro.z,
            this.x*otro.y - this.y*otro.x
        );
    }

    // Verificar ortogonalidad (diagonales iguales)
    public boolean esOrtogonal(AlgebraVectorial otro) {
        AlgebraVectorial suma = this.sumar(otro);
        AlgebraVectorial resta = this.multiplicar(-1).sumar(otro);
        return Math.abs(suma.longitud() - resta.longitud()) < 1e-9;
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f, %.2f]", x, y, z);
    }

}
