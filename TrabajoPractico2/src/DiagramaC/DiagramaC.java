/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaC;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class DiagramaC {

    public static void main(String[] args) {

        TipoActividad tipo = new TipoActividad(100, "Administrativo", 0.5);
        TipoActividad tipo2 = new TipoActividad(101, "Cosecha", 1);
        TipoActividad tipo3 = new TipoActividad(103, "Limpieza", 0.3);

        Persona persona = new Persona("Mariana Perez", "DNI", 34234123, 4231233, "mariana213@gmail.com", "2613234123");
        Persona persona1 = new Persona("Marcelo Gonzales", "DNI", 33235123, 4221233, "marcelo213@gmail.com", "2615237123");

        Sector sector = new Sector(1, "Azul", "Prioritario");
        Sector sector1 = new Sector(2, "Verde", "Secundario");
        Sector sector2 = new Sector(3,"Violeta", "Secundario");
        Sector sector3 = new Sector(4,"Rojo", "Terciario");
        Sector sector4 = new Sector(4, "Fluor", "Terciario");
        sector.inicializaSector();
        //sector.addSector(sector);
        sector.addSector(sector1);
        sector.addSector(sector2);
        sector.inicializaPersona();
        sector.addPersona(persona);
        sector.addPersona(persona1);
        sector1.inicializaSector();
        sector1.addSector(sector3);
        sector4.inicializaSector();
   
        sector3.inicializaSector();
        sector3.addSector(sector4);

        persona.setSector(sector);
        persona1.setSector(sector);
        persona.inicializaArrayAct();
        persona1.inicializaArrayAct();

        LocalDate fechaInicio = LocalDate.of(2018, 11, 11);
        LocalDate fechaFin = LocalDate.of(2019, 4, 10);

        Actividad actividad = new Actividad(fechaInicio, fechaFin, "Auxiliar", "Ayuda administrativa");
        actividad.setTipoActividad(tipo);
        actividad.setPersona(persona);
        persona.addActividad(actividad);
        

        Actividad actividad1 = new Actividad(fechaInicio, fechaFin, "Mantenimiento", "Revisa todos los sectores");
        actividad1.setTipoActividad(tipo3);
        actividad1.setPersona(persona1);
        persona1.addActividad(actividad1);
        persona.addActividad(actividad1);

        tipo.inicializaActividades();
        tipo.addActividad(actividad);
        tipo3.inicializaActividades();
        tipo3.addActividad(actividad1);

        System.out.println("Los puntos de cada persona son los siguientes: ");
        System.out.println("Mariana: " + persona.totalPuntosAsignados());
        System.out.println("Marcelo: " + persona1.totalPuntosAsignados());
        
        System.out.println("Los puntos de cada una actividad: ");
        System.out.println("Mariana" + persona.totalPuntosAsignados(100));
        
        
        System.out.println("Puntos por tiempo y actividad");
        System.out.println(persona1.totalPuntosAsignados(103, 2019));
        ArrayList<Sector>sectoresFiltrados = new ArrayList();
        sectoresFiltrados = sector.obtenerTotalSubsectores();
        for (int i = 0; i < sectoresFiltrados.size(); i++) {
            System.out.println(sectoresFiltrados.get(i).getDenominacion());   
        }

    }
}
