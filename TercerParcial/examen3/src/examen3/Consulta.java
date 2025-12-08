package examen3;

public class Consulta {
    private int ci;
    private int idMed;
    private int dia;
    private int anio;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String mes;

    public Consulta(int ci, int idMed, int dia, int anio, String nombrePaciente, String apellidoPaciente, String mes) {
        this.ci = ci;
        this.idMed = idMed;
        this.dia = dia;
        this.anio = anio;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.mes = mes;
    }

    // Getters y Setters
    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }
    public int getIdMed() { return idMed; }
    public String getMes() { return mes; }
}
