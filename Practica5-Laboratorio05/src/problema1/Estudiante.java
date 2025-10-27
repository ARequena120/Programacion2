package problema1;
public class Estudiante {
    public String codigo;
    public String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante #" + codigo + ": " + nombre);
    }
}
