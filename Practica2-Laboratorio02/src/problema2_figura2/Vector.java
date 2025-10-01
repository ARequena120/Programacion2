package problema2_figura2;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Sobrecarga de operadores mediante métodos
    public Vector sumar(Vector otro) {
        return new Vector(this.x + otro.x, this.y + otro.y, this.z + otro.z);
    }
    
    public Vector restar(Vector otro) {
        return new Vector(this.x - otro.x, this.y - otro.y, this.z - otro.z);
    }
    
    public double productoEscalar(Vector otro) {
        return this.x * otro.x + this.y * otro.y + this.z * otro.z;
    }
    
    public Vector productoVectorial(Vector otro) {
        return new Vector(
            this.y * otro.z - this.z * otro.y,
            this.z * otro.x - this.x * otro.z,
            this.x * otro.y - this.y * otro.x
        );
    }
    
    public double longitud() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    
    public Vector normalizar() {
        double magnitud = this.longitud();
        return new Vector(x/magnitud, y/magnitud, z/magnitud);
    }
    
    // Proyección ortogonal (a sobre b)
    public Vector proyectarSobre(Vector otro) {
        double factor = this.productoEscalar(otro) / Math.pow(otro.longitud(), 2);
        return otro.multiplicar(factor);
    }
    
    // Componente escalar (a sobre b)
    public double componenteSobre(Vector otro) {
        return this.productoEscalar(otro) / otro.longitud();
    }
    
    public Vector multiplicar(double escalar) {
        return new Vector(x * escalar, y * escalar, z * escalar);
    }
    
    @Override
    public String toString() {
        return String.format("[%.2f, %.2f, %.2f]", x, y, z);
    }
    
   
}
