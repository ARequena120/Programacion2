package examen2;
import java.util.ArrayList;
import java.util.Objects;

public class MiTeleferico {
    private ArrayList<Linea> lineas;
    private float cantidadIngresos;

    public MiTeleferico() {
        this.lineas = new ArrayList<>();
        this.cantidadIngresos = 0;
    }

    public void agregarLinea(String color) {
        lineas.add(new Linea(color));
    }

    public Linea getLinea(String color) {
        for (Linea l : lineas) {
            if (Objects.equals(l.getColor(), color)) {
                return l;
            }
        }
        return null;
    }
}
