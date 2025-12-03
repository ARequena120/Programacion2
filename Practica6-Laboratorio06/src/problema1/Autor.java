package problema1;

import java.time.LocalDate;
import com.google.gson.annotations.JsonAdapter;

public class Autor {
    private String nombre;
    private String nacionalidad;
    @JsonAdapter(LocalDateAdapter.class)
    private LocalDate fechaNacimiento;

    // Constructor vacío para GSON
    public Autor() {}

    public Autor(String nombre, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    
    @Override
    public String toString() { return nombre; }
}
