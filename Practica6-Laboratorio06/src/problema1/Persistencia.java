package problema1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Persistencia {
    private static final String ARCHIVO = "biblioteca.json";
    private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .create();

    public static void guardarDatos(Biblioteca biblioteca) {
        try {
            Files.writeString(Paths.get(ARCHIVO), gson.toJson(biblioteca));
        } catch (IOException e) {
            System.err.println("Error guardando datos: " + e.getMessage());
        }
    }

 
    public static Biblioteca cargarDatos() {
        try {
            if (!Files.exists(Paths.get(ARCHIVO))) return new Biblioteca("Nueva Biblioteca");
            
            String json = Files.readString(Paths.get(ARCHIVO));
            return gson.fromJson(json, Biblioteca.class);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error cargando datos: " + e.getMessage(),
                "Error crítico", 
                JOptionPane.ERROR_MESSAGE);
            return new Biblioteca("Biblioteca de Respaldo");
        }
    }

}
