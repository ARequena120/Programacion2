package examen3;

public class Medico {
    private int idMed;
    private int aniosExperiencia;
    private String nombreMed;
    private String apellidoMed;

    public Medico(int idMed, int aniosExperiencia, String nombreMed, String apellidoMed) {
        this.idMed = idMed;
        this.aniosExperiencia = aniosExperiencia;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
    }

    // Getters (requeridos para Gson)
    public int getIdMed() { return idMed; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public String getNombreMed() { return nombreMed; }
    public String getApellidoMed() { return apellidoMed; }
}
