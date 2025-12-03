package problema1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Biblioteca {
    private String nombre;
    private List<Libro> librosDisponibles = new CopyOnWriteArrayList<>();
    private List<Autor> autores = new CopyOnWriteArrayList<>();
    private List<Estudiante> estudiantesRegistrados = new ArrayList<>();
    private List<Prestamo> prestamosActivos = new CopyOnWriteArrayList<>();
    

    // Constructor vacío para GSON
    public Biblioteca() {}

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para Libros
    public void agregarLibro(Libro libro) {
        if(librosDisponibles.stream().noneMatch(l -> l.getIsbn().equals(libro.getIsbn()))) {
            librosDisponibles.add(libro);
        }
    }
    
    // Métodos para Estudiantes
    public void registrarEstudiante(Estudiante estudiante) {
        Objects.requireNonNull(estudiante, "El estudiante no puede ser nulo");
        
        if (estudiantesRegistrados.stream()
            .anyMatch(e -> e.getCodigo().equals(estudiante.getCodigo()))) {
            throw new IllegalArgumentException("Código de estudiante duplicado");
        }
        
        estudiantesRegistrados.add(estudiante);
        Persistencia.guardarDatos(this); // Guardar inmediatamente
    }


    
    // Métodos para Préstamos
    public void realizarPrestamo(Libro libro, Estudiante estudiante, int cantidad) {
        if(libro.getStock() >= cantidad) {
            libro.setStock(libro.getStock() - cantidad);
            prestamosActivos.add(new Prestamo(libro, estudiante, cantidad));
        }
    }
    
    public void registrarDevolucion(Prestamo prestamo) {
        prestamo.getLibro().setStock(prestamo.getLibro().getStock() + prestamo.getCantidad());
        prestamosActivos.remove(prestamo);
    }
    
    // Métodos para Autores
    public void registrarAutor(Autor autor) {
        if(autores.stream().noneMatch(a -> a.getNombre().equalsIgnoreCase(autor.getNombre()))) {
            autores.add(autor);
        }
    }
    
    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public List<Libro> getLibrosDisponibles() { return librosDisponibles; }
    public void setLibrosDisponibles(List<Libro> librosDisponibles) { this.librosDisponibles = librosDisponibles; }
    
    public List<Estudiante> getEstudiantesRegistrados() { return estudiantesRegistrados; }
    public void setEstudiantesRegistrados(List<Estudiante> estudiantesRegistrados) { this.estudiantesRegistrados = estudiantesRegistrados; }
    
    public List<Prestamo> getPrestamosActivos() { return prestamosActivos; }
    public void setPrestamosActivos(List<Prestamo> prestamosActivos) { this.prestamosActivos = prestamosActivos; }
    
    public List<Autor> getAutoresRegistrados() { return autores; }
    public void setAutoresRegistrados(List<Autor> autores) { this.autores = autores; }
    
    public void procesarActualizacion() {

        LocalDate hoy = LocalDate.now();
        prestamosActivos.removeIf(prestamo -> 
            prestamo.getFechaPrestamo().plusDays(15).isBefore(hoy)
        );
    }

}
