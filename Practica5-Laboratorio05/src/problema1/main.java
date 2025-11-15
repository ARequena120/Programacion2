
package problema1;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");
        biblioteca.setHorarioAtencion(biblioteca.new Horario("Lunes a Viernes", "08:30", "20:00"));
        
        Autor autor = new Autor("Adela Zamudio", "Boliviana");
        biblioteca.registrarAutor(autor);
        
        Libro libro = new Libro("En la alta noche", "978-99974-58-47-3");
        
        libro.agregarPagina(1, "La noche era fría...");
        libro.agregarPagina(2, "El viento susurraba secretos...");
        libro.agregarPagina(3, "Final inesperado...");
        
        biblioteca.agregarLibro(libro);
        
        Estudiante estudiante = new Estudiante("2025-LP-001", "Juan Pérez");
        
        System.out.println("=== Sistema Bibliotecario ===");
        System.out.println("Fecha actual: " + LocalDate.now());
        
        System.out.println("\n=== Acción: Préstamo ===");
        biblioteca.realizarPrestamo(estudiante, libro);
        
        System.out.println("\n=== Estado Actual ===");
        biblioteca.mostrarEstado();
        
        System.out.println("\n=== Detalle de Préstamo ===");
        if(!biblioteca.getPrestamosActivos().isEmpty()) {
            biblioteca.getPrestamosActivos().get(0).mostrarDetalle();
        }
        
        System.out.println("\n=== Cierre de Biblioteca ===");
        biblioteca.cerrarBiblioteca();
    }
}
