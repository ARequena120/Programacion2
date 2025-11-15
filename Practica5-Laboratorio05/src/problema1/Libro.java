
package problema1;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String isbn;
    private List<Pagina> paginas;

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void agregarPagina(int numero, String contenido) {
        paginas.add(new Pagina(numero, contenido));
    }

    public void leer() {
        System.out.println("\nLeyendo: " + titulo);
        for(Pagina p : paginas) {
            p.mostrar();
        }
    }

    public void prestar() {
        System.out.println("Préstamo registrado: " + titulo);
    }

    public class Pagina {
        private int numero;
        private String contenido;

        public Pagina(int numero, String contenido) {
            this.numero = numero;
            this.contenido = contenido;
        }

        public void mostrar() {
            System.out.println("Pág. " + numero + ": " + contenido);
        }
    }
}
