package problema1;

import java.time.LocalDate;
import com.google.gson.annotations.JsonAdapter;

public class Prestamo {
    private Libro libro;
    private Estudiante estudiante;
    @JsonAdapter(LocalDateAdapter.class)
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private int cantidad;

    // Constructor vacío para GSON
    public Prestamo() {}

    public Prestamo(Libro libro, Estudiante estudiante, int cantidad) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDate.now();
        this.cantidad = cantidad;
        this.fechaDevolucion = null;
    }

    // Getters y Setters
    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }
    
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fecha) { this.fechaDevolucion = fecha; }
}
