package problema1;

public class EmpleadoTiempoCompleto extends Empleado {
    // Inciso a) Atributo salario anual
    private double salarioAnual;
    
    // Inciso b) Constructor
    public EmpleadoTiempoCompleto(String nombre, double salarioAnual) {
        super(nombre);
        this.salarioAnual = salarioAnual;
    }
    
    // Inciso c) Cálculo salario mensual
    @Override
    public double CalcularSalarioMensual() {
        return salarioAnual / 12;
    }
    
    // Inciso d) toString() mejorado
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Completo | Salario Anual: $%,.2f", salarioAnual);
    }
}
