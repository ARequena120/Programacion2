
package problema1;

public class Estudiante {
    private String codigo;
    private String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante #" + codigo + ": " + nombre);
    }
}
