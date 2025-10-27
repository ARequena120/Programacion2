package problema1;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    public String titulo;
    public String isbn;
    public List<Pagina> paginas;

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
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

    // Clase interna Pagina (composición)
    public class Pagina {
        public int numero;
        public String contenido;

        public Pagina(int numero, String contenido) {
            this.numero = numero;
            this.contenido = contenido;
        }

        public void mostrar() {
            System.out.println("Pág. " + numero + ": " + contenido);
        }
    }
}
