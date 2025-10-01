package problema1;

public class EmpleadoTiempoHorario extends Empleado {
    // Inciso a) Atributos
    private double horasTrabajadas;
    private double tarifaPorHora;
    
    // Inciso b) Constructor
    public EmpleadoTiempoHorario(String nombre, double horasTrabajadas, double tarifaPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    
    // Inciso c) Cálculo salario
    @Override
    public double CalcularSalarioMensual() {
        return horasTrabajadas * tarifaPorHora;
    }
    
    // Inciso d) toString() descriptivo
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Horario | Horas: %.1f | Tarifa: $%.2f/h", 
               horasTrabajadas, tarifaPorHora);
    }
}