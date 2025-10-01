package problema1;

public abstract class Empleado {
    // Inciso a) Atributo nombre
    protected String nombre;
    
    // Inciso b) Constructor
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    
    // Inciso c) Método abstracto
    public abstract double CalcularSalarioMensual();
    
    // Inciso d) toString()
    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}

