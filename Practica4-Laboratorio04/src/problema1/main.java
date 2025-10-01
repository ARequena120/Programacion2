package problema1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        
        // Registro tiempo completo (3 empleados)
        System.out.println("REGISTRO DE EMPLEADOS TIEMPO COMPLETO");
        for(int i = 0; i < 3; i++) {
            System.out.println("\nEmpleado #" + (i+1));
            System.out.print("Nombre: ");
            String nombre = input.nextLine();
            
            System.out.print("Salario anual: ");
            double salario = input.nextDouble();
            input.nextLine();
            
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salario);
        }
        
        // Registro por horas (2 empleados)
        System.out.println("\nREGISTRO DE EMPLEADOS POR HORAS");
        for(int i = 3; i < 5; i++) {
            System.out.println("\nEmpleado #" + (i-2));
            System.out.print("Nombre: ");
            String nombre = input.nextLine();
            
            System.out.print("Horas trabajadas: ");
            double horas = input.nextDouble();
            
            System.out.print("Tarifa por hora: ");
            double tarifa = input.nextDouble();
            input.nextLine();
            
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }
        
        // Reporte final
        System.out.println("\nREPORTE DE SALARIOS MENSUALES");
        System.out.println("Fecha: 30/09/2025");
        System.out.println("==============================");
        
        for(Empleado emp : empleados) {
            System.out.println(emp.toString());
            System.out.printf("Salario mensual: $%,.2f%n", emp.CalcularSalarioMensual());
            System.out.println("------------------------------");
        }
        
        input.close();
    }
}