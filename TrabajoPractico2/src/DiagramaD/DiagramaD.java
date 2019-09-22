package DiagramaD;

import java.util.Scanner;

/**
 *
 * @author Georgi
 */
public class DiagramaD {

    public void cargaBarrio(Barrio barrio) {

        long id = 12345;
        barrio.setId(id);
        String nombre = "Barrio Santa Ana";
        barrio.setNombre(nombre);
        String empresaCons = "Pilares Andinos S.A";
        barrio.setEmpresaConstructora(empresaCons);
    }

    public Vivienda cargaVivienda(Barrio barrio, Vivienda vivienda) {
        String calle, nombre;
        int numero, cantidad;
        double superficie;
        long metrosCuadrados;

        System.out.println("Ingrese la calle de la vivienda");
        calle = new Scanner(System.in).next();
        System.out.println("Ingrese el numero de la calle");
        numero = new Scanner(System.in).nextInt();
        System.out.println("Ingrese la superficie de la vivienda");
        superficie = new Scanner(System.in).nextDouble();
        vivienda.setBarrio(barrio);
        vivienda.setCalle(calle);
        vivienda.setNumeroCalle(numero);
        vivienda.setSuperficieTerreno(superficie);
        vivienda.inicializaHab();

        System.out.println("Cuantas habitaciones tiene la vivienda?");
        cantidad = new Scanner(System.in).nextInt();
        do {
            Habitacion habitacion = new Habitacion();
            System.out.println("Ingrese el nombre de la habitacion");
            nombre = new Scanner(System.in).next();
            habitacion.setNombre(nombre);
            System.out.println("Ingrese los metros cuadrados de la habitacion");
            metrosCuadrados = new Scanner(System.in).nextLong();
            habitacion.setMetrosCuadrados(metrosCuadrados);
            habitacion.setVivienda(vivienda);
            vivienda.agregaHabitacion(habitacion);

            cantidad--;
        } while (cantidad > 0);

        return vivienda;
    }

    public static void main(String[] args) {

        DiagramaD diagramad = new DiagramaD();
        Barrio barrio = new Barrio();
        diagramad.cargaBarrio(barrio);
        barrio.inicializaVivienda();

        String opcion;
        do {
            System.out.println("Desea agregar una vivienda?");
            opcion = new Scanner(System.in).next();
            if (opcion.equalsIgnoreCase("si")) {
                Vivienda vivienda = new Vivienda();
                barrio.agregaVivienda(diagramad.cargaVivienda(barrio, vivienda));
            }
        } while (opcion.equalsIgnoreCase("si"));

        System.out.println("La superficie total del terreno es: " + barrio.getSuperficieTotalTerreno());
        System.out.println("La superficie total cubierta es: " + barrio.getSuperficieTotalCubierta());

    }
}
