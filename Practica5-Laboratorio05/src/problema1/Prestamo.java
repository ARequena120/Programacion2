
package problema1;
import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = LocalDate.now().plusWeeks(2);
        this.estudiante = estudiante;
        this.libro = libro;
    }

    public void mostrarDetalle() {
        System.out.println("\nPréstamo a: " + estudiante.getNombre());
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Devuelto antes de: " + fechaDevolucion);
    }
}
