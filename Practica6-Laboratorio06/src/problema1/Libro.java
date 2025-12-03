package problema1;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String isbn;
    private int stock;
    private Autor autor;

    // Constructor vacío para GSON
    public Libro() {}

    public Libro(String titulo, String isbn, int stock, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.stock = stock;
        this.autor = autor;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    
    public Autor getAutor() { return autor; }
    
    public void setAutor(Autor autor) {
        this.autor = Objects.requireNonNull(autor, "El autor no puede ser null");
    }
}
