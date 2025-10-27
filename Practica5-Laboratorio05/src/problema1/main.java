package problema1;
public class main {
    public static void main(String[] args) {
        // 1. Crear biblioteca con horario
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");
        biblioteca.horarioAtencion = biblioteca.new Horario("Lunes a Viernes", "08:30", "20:00");
        
        // 2. Registrar autor
        Autor autor = new Autor("Adela Zamudio", "Boliviana");
        biblioteca.registrarAutor(autor);
        
        // 3. Crear y configurar libro
        Libro libro = new Libro("En la alta noche", "978-99974-58-47-3");
        
        // Agregar páginas (composición)
        libro.paginas.add(libro.new Pagina(1, "La noche era fría..."));
        libro.paginas.add(libro.new Pagina(2, "El viento susurraba secretos..."));
        libro.paginas.add(libro.new Pagina(3, "Final inesperado..."));
        
        biblioteca.agregarLibro(libro);
        
        // 4. Registrar estudiante
        Estudiante estudiante = new Estudiante("2025-LP-001", "Juan Pérez");
        
        System.out.println("=== Sistema Bibliotecario ===");
        System.out.println("Fecha actual: " + java.time.LocalDate.now());
        
        // 5. Realizar préstamo
        System.out.println("\n=== Acción: Préstamo ===");
        biblioteca.realizarPrestamo(estudiante, libro);
        
        // 6. Mostrar estado actual
        System.out.println("\n=== Estado Actual ===");
        biblioteca.mostrarEstado();
        
        // 7. Mostrar detalle del préstamo
        System.out.println("\n=== Detalle de Préstamo ===");
        if(!biblioteca.prestamosActivos.isEmpty()) {
            biblioteca.prestamosActivos.get(0).mostrarDetalle();
        }
        
        // 8. Cerrar biblioteca (demo)
        System.out.println("\n=== Cierre de Biblioteca ===");
        biblioteca.cerrarBiblioteca();
    }
}
