package problema3;

public class Estadisticas {
    private double[] numeros;

    public Estadisticas(double[] numeros) {
        this.numeros = numeros;
    }

    public double promedio() {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public double desviacion() {
        double media = promedio();
        double sumaDesviacion = 0;
        for (double num : numeros) {
            sumaDesviacion += Math.pow(num - media, 2);
        }
        return Math.sqrt(sumaDesviacion / (numeros.length - 1));
    }
}

