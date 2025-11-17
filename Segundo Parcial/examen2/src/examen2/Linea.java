package examen2;
import java.util.ArrayList;

public class Linea {
    private String color;
    private ArrayList<Persona> filaPersonas;
    private ArrayList<Cabina> cabinas;

    public Linea(String color) {
        this.color = color;
        this.filaPersonas = new ArrayList<>();
        this.cabinas = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void agregarPersona(Persona p) {
        filaPersonas.add(p);
    }

    public void agregarCabina(int nroCabina) {
        cabinas.add(new Cabina(nroCabina));
    }

    public Cabina getCabina(int nroCabina) {
        for (Cabina c : cabinas) {
            if (c.getNroCabina() == nroCabina) {
                return c;
            }
        }
        return null;
    }

    public boolean agregarPersonaPrimeraCabina(int nroCabina) {
        if (filaPersonas.isEmpty()) {
            return false;
        }

        Cabina c = getCabina(nroCabina);
        if (c == null) {
            return false;
        }

        Persona p = filaPersonas.get(0);
        if (c.agregarPersona(p)) {
            filaPersonas.remove(0);
            return true;
        }

        return false;
    }

    public boolean verificarReglas() {
        for (Cabina c : cabinas) {
            if (c.getPersonas().size() > 10) {
                return false;
            }
            if (c.pesoTotal() > 850) {
                return false;
            }
        }
        return true;
    }

    public float ingresoTarifaRegular() {
        float total = 0;

        for (Persona p : filaPersonas) {
            total += 1;
        }

        for (Cabina c : cabinas) {
            for (Persona p : c.getPersonas()) {
                total += 2;
            }
        }

        return total;
    }

}
