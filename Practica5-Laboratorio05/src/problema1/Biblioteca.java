
package problema1;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> librosDisponibles;
    private List<Autor> autoresRegistrados;
    private List<Prestamo> prestamosActivos;
    private Horario horarioAtencion;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.librosDisponibles = new ArrayList<>();
        this.autoresRegistrados = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setHorarioAtencion(Horario horario) {
        this.horarioAtencion = horario;
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void registrarAutor(Autor autor) {
        autoresRegistrados.add(autor);
    }

    public void realizarPrestamo(Estudiante estudiante, Libro libro) {
        Prestamo prestamo = new Prestamo(estudiante, libro);
        prestamosActivos.add(prestamo);
        libro.prestar();
    }

    public void mostrarEstado() {
        System.out.println("\n=== Estado Biblioteca: " + nombre + " ===");
        System.out.println("Libros disponibles: " + librosDisponibles.size());
        System.out.println("Autores registrados: " + autoresRegistrados.size());
        System.out.println("Préstamos activos: " + prestamosActivos.size());
        if(horarioAtencion != null) horarioAtencion.mostrar();
    }

    public void cerrarBiblioteca() {
        prestamosActivos.clear();
        System.out.println("Biblioteca cerrada - Préstamos cancelados");
    }

    public class Horario {
        private String dias;
        private String horaApertura;
        private String horaCierre;

        public Horario(String dias, String apertura, String cierre) {
            this.dias = dias;
            this.horaApertura = apertura;
            this.horaCierre = cierre;
        }

        public void mostrar() {
            System.out.println("Horario: " + dias + " " + horaApertura + "-" + horaCierre);
        }
    }
}
