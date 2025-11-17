package examen2;
import java.util.ArrayList;

public class Cabina {
    private int nroCabina;
    private ArrayList<Persona> personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    public int getNroCabina() {
        return nroCabina;
    }

    public ArrayList<Persona> getPersonas() {
        return personasAbordo;
    }

    public boolean agregarPersona(Persona p) {
        if (personasAbordo.size() < 10 && pesoTotal() + p.getPeso() <= 850) {
            personasAbordo.add(p);
            return true;
        }
        return false;
    }

    public float pesoTotal() {
        float total = 0;
        for (Persona p : personasAbordo) {
            total += p.getPeso();
        }
        return total;
    }
}
