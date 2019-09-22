package DiagramaB;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;

public class DiagramaB {

    public void cargaEmpleado(Empleado empleado) {

        String nombre = "Carlos Fuentes";
        long cuit = 23456122;
        String domicilio = "San Martin 1322 - Godoy Cruz";
        String email = "carlosFuentes98@gmail.com";
        empleado.setNombre(nombre);
        empleado.setCuit(cuit);
        empleado.setDomicilio(domicilio);
        empleado.setEmail(email);

    }

    public void cargaRegimenHorario(RegimenHorario regimen) {

        long id = 12345;
        int horaIngreso = 8;
        int minutoIngreso = 0;
        int horaEgreso = 14;
        int minutoEgreso = 0;
        regimen.setId(id);
        regimen.setHoraIngreso(horaIngreso);
        regimen.setMinutoIngreso(minutoIngreso);
        regimen.setHoraEgreso(horaEgreso);
        regimen.setMinutoEgreso(minutoEgreso);

    }

    public void cargaAsistencia(RegimenHorario regimen, Empleado empleado) {
        String tipo;
        int dia, mes, anio, hora, minuto;

        Asistencia asistencia = new Asistencia();
        asistencia.setId(regimen.getId());
        do {
            System.out.println("Ingrese el tipo: si es entrada ingrese E, si es salida ingrese S");
            tipo = new Scanner(System.in).next();
        } while (!asistencia.validaTipo(tipo));
        asistencia.setTipo(tipo);
        System.out.println("Ingrese el dia: ");
        dia = new Scanner(System.in).nextInt();
        System.out.println("Ingrese el mes: ");
        mes = new Scanner(System.in).nextInt();
        System.out.println("Ingrese año: ");
        anio = new Scanner(System.in).nextInt();
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        asistencia.setFecha(fecha);

        do {
            System.out.println("Ingrese la hora de ingreso");
            hora = new Scanner(System.in).nextInt();
        } while (!asistencia.validaHora(hora));
        asistencia.setHora(hora);
        do {
            System.out.println("Ingrese minuto de ingreso");
            minuto = new Scanner(System.in).nextInt();
        } while (!asistencia.validaMinuto(minuto));
        asistencia.setMinuto(minuto);
        if (regimen.verificaSiEsTardanza(hora, minuto)) {
            Tardanza tardanza = new Tardanza(regimen.getId(), tipo, fecha, hora, minuto, empleado);
            empleado.addTardanza(tardanza);
            tardanza.setEmpleado(empleado);
        }
        asistencia.setEmpleado(empleado);
        empleado.addAsistencia(asistencia);
    }

    public void muestraAsistenciasFiltradas(Empleado empleado) {
        int mes, anio;
        System.out.println("Mes: ");
        mes = new Scanner(System.in).nextInt();
        System.out.println("Año: ");
        anio = new Scanner(System.in).nextInt();
        ArrayList<Asistencia> asistenciasFiltradas = new ArrayList();
        asistenciasFiltradas = empleado.getAsistenciaXmesXanio(mes, anio);
        System.out.println("Las asistencias del empleado son: ");
        System.out.println("Cantidad: " + asistenciasFiltradas.size());

    }

    public void muestraTardanzasFiltradas(Empleado empleado) {
        int mes, anio;
        System.out.println("Mes: ");
        mes = new Scanner(System.in).nextInt();
        System.out.println("Año: ");
        anio = new Scanner(System.in).nextInt();
        ArrayList<Tardanza> tardanzasFiltradas = new ArrayList();
        tardanzasFiltradas = empleado.getTardanzaXmesXanio(mes, anio);
        System.out.println("Las tardanzas del empleado son: ");
        System.out.println("Cantidad: " + tardanzasFiltradas.size());

    }

    public static void main(String[] args) {

        DiagramaB diagramab = new DiagramaB();
        Empleado empleado = new Empleado();
        diagramab.cargaEmpleado(empleado);
        RegimenHorario regimen = new RegimenHorario();
        regimen.setEmpleado(empleado);
        diagramab.cargaRegimenHorario(regimen);
        regimen.setEmpleado(empleado);

        String opcion;

        do {
            System.out.println("Desea agregar asistencia?");
            opcion = new Scanner(System.in).next();
            if (opcion.equalsIgnoreCase("si")) {
                diagramab.cargaAsistencia(regimen, empleado);
            }
        } while (opcion.equalsIgnoreCase("si"));

        System.out.println("Desea ver las asistencias del empleado en un mes y año especifico?");
        opcion = new Scanner(System.in).next();
        if (opcion.equalsIgnoreCase("si")) {
            diagramab.muestraAsistenciasFiltradas(empleado);
        }
        System.out.println("Desea ver las tardanzas?");
        opcion = new Scanner(System.in).next();
        if (opcion.equalsIgnoreCase("si")) {
            diagramab.muestraTardanzasFiltradas(empleado);
        } else {
            System.out.println("Fin del programa");
        }
    }

}
