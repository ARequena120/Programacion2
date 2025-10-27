package problema1;
import java.time.LocalDate;

public class Prestamo {
    public LocalDate fechaPrestamo;
    public LocalDate fechaDevolucion;
    public Estudiante estudiante;
    public Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = LocalDate.now().plusWeeks(2);
        this.estudiante = estudiante;
        this.libro = libro;
    }

    public void mostrarDetalle() {
        System.out.println("\nPréstamo a: " + estudiante.nombre);
        System.out.println("Libro: " + libro.titulo);
        System.out.println("Devuelto antes de: " + fechaDevolucion);
    }
}
