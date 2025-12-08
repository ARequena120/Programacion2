package examen3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();

        try {
            // Registrar 3 médicos
            consultorio.altaMedico(new Medico(1, 5, "Juan", "Perez"));
            consultorio.altaMedico(new Medico(2, 8, "Ana", "Gomez"));
            consultorio.altaMedico(new Medico(3, 3, "Luis", "Martinez"));

            // Registrar 5 consultas con diferentes pacientes
            consultorio.altaConsulta(new Consulta(101, 1, 24, 2025, "Carlos", "García", "Diciembre"));
            consultorio.altaConsulta(new Consulta(102, 2, 15, 2025, "Laura", "Rodríguez", "Enero"));
            consultorio.altaConsulta(new Consulta(103, 3, 5, 2025, "Marta", "Sánchez", "Febrero"));
            consultorio.altaConsulta(new Consulta(104, 1, 12, 2025, "Pedro", "Díaz", "Navidad"));
            consultorio.altaConsulta(new Consulta(105, 2, 20, 2025, "Sofía", "Fernández", "Enero"));

            // Ejemplo: Eliminar médico Ana Gómez
            consultorio.bajaMedico("Juan", "Perez");

            // Ejemplo: Actualizar nombres festivos
            consultorio.actualizarFestivos();

            System.out.println("✅ Proceso completado. Ver archivos JSON.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
