package examen2;

public class Main {
    public static void main(String[] args) {
        MiTeleferico mt1 = new MiTeleferico();
        mt1.agregarLinea("Rojo");
        MiTeleferico mt2 = new MiTeleferico();
        mt2.agregarLinea("Verde");
        MiTeleferico mt3 = new MiTeleferico();
        mt3.agregarLinea("Amarillo");

        Linea rojo = mt1.getLinea("Rojo");
        rojo.agregarCabina(1);
        Linea verde = mt2.getLinea("Verde");
        verde.agregarCabina(2);
        Linea amarillo = mt3.getLinea("Amarillo");
        amarillo.agregarCabina(3);

        rojo.agregarPersona(new Persona("Ana", 30, 60));
        rojo.agregarPersona(new Persona("Luis", 20, 70));

        verde.agregarPersona(new Persona("Mateo", 20, 70));
        verde.agregarPersona(new Persona("Marcos", 20, 70));

        amarillo.agregarPersona(new Persona("juan", 20, 70));
        amarillo.agregarPersona(new Persona("Sara", 20, 70));

        System.out.println("----- LINEA ROJO -----");
        System.out.println("Persona agregada a cabina 1: " + rojo.agregarPersonaPrimeraCabina(1));
        System.out.println("Reglas correctas: " + rojo.verificarReglas());
        System.out.println("Ingreso tarifa regular: " + rojo.ingresoTarifaRegular());

        System.out.println("\n----- LINEA VERDE -----");
        System.out.println("Persona agregada a cabina 2: " + verde.agregarPersonaPrimeraCabina(2));
        System.out.println("Reglas correctas: " + verde.verificarReglas());
        System.out.println("Ingreso tarifa regular: " + verde.ingresoTarifaRegular());

        System.out.println("\n----- LINEA AMARILLO -----");
        System.out.println("Persona agregada a cabina 3: " + amarillo.agregarPersonaPrimeraCabina(3));
        System.out.println("Reglas correctas: " + amarillo.verificarReglas());
        System.out.println("Ingreso tarifa regular: " + amarillo.ingresoTarifaRegular());
    }
}
