package problema1;

import java.time.LocalDate;

public class Estudiante {
    private String codigo;
    private String nombre;
    private LocalDate fechaRegistro;

    public Estudiante(String codigo, String nombre) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código inválido");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        
        this.codigo = codigo.trim().toUpperCase();
        this.nombre = nombre.trim();
        this.fechaRegistro = LocalDate.now();
    }


    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    @Override
    public String toString() { return nombre + " (" + codigo + ")"; }
}
