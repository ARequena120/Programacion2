package examen3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Consultorio {
    private static final Gson gson = new Gson();
    private static final String MEDICOS_JSON = "medicos.json";
    private static final String CONSULTAS_JSON = "consultas.json";

    // Alta de médico
    public void altaMedico(Medico medico) throws IOException {
        List<Medico> medicos = leerDesdeJson(MEDICOS_JSON, new TypeToken<List<Medico>>() {});
        medicos.add(medico);
        guardarEnJson(MEDICOS_JSON, medicos);
    }

    // Alta de consulta
    public void altaConsulta(Consulta consulta) throws IOException {
        List<Consulta> consultas = leerDesdeJson(CONSULTAS_JSON, new TypeToken<List<Consulta>>() {});
        consultas.add(consulta);
        guardarEnJson(CONSULTAS_JSON, consultas);
    }

    // Baja de médico y consultas asociadas
    public void bajaMedico(String nombre, String apellido) throws IOException {
        List<Medico> medicos = leerDesdeJson(MEDICOS_JSON, new TypeToken<List<Medico>>() {});
        List<Integer> idsEliminar = medicos.stream()
            .filter(m -> m.getNombreMed().equals(nombre) && m.getApellidoMed().equals(apellido))
            .map(Medico::getIdMed)
            .collect(Collectors.toList());

        // Eliminar médicos
        List<Medico> nuevosMedicos = medicos.stream()
            .filter(m -> !idsEliminar.contains(m.getIdMed()))
            .collect(Collectors.toList());
        guardarEnJson(MEDICOS_JSON, nuevosMedicos);

        // Eliminar consultas asociadas
        List<Consulta> consultas = leerDesdeJson(CONSULTAS_JSON, new TypeToken<List<Consulta>>() {});
        List<Consulta> nuevasConsultas = consultas.stream()
            .filter(c -> !idsEliminar.contains(c.getIdMed()))
            .collect(Collectors.toList());
        guardarEnJson(CONSULTAS_JSON, nuevasConsultas);
    }

    // Actualizar nombres en festividades
    public void actualizarFestivos() throws IOException {
        List<Consulta> consultas = leerDesdeJson(CONSULTAS_JSON, new TypeToken<List<Consulta>>() {});
        consultas.forEach(c -> {
            if (("Diciembre".equalsIgnoreCase(c.getMes()) || "Enero".equalsIgnoreCase(c.getMes())) 
                && "Navidad".equalsIgnoreCase(c.getNombrePaciente())) {
                c.setNombrePaciente("Año Nuevo");
            }
        });
        guardarEnJson(CONSULTAS_JSON, consultas);
    }

    // Métodos auxiliares para JSON
    private <T> List<T> leerDesdeJson(String archivo, TypeToken<List<T>> typeToken) throws IOException {
        File file = new File(archivo);
        if (!file.exists()) return new ArrayList<>();

        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, typeToken.getType());
        }
    }

    private <T> void guardarEnJson(String archivo, List<T> datos) throws IOException {
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(datos, writer);
        }
    }
}
