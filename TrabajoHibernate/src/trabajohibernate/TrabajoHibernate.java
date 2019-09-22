package trabajohibernate;

import Controlador.ControladorDetalleHC;
import Controlador.ControladorDomicilio;
import Controlador.ControladorEspecialidad;
import Controlador.ControladorHistoriaClinica;
import Controlador.ControladorMedico;
import Controlador.ControladorPaciente;
import Modelo.DetalleHistoriaClinica;
import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.Especialidad;
import Modelo.HistoriaClinica;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Turno;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrabajoHibernate {

    public static void main(String[] args) {
        try {// creacion de objetos

            Date fecha = Date.from(Instant.now());
            Domicilio dom1 = new Domicilio();
            Domicilio dom2 = new Domicilio();
            Domicilio dom3 = new Domicilio();

            dom1.setCalle("Martinez de rosas");
            dom1.setLocalidad("Las Heras");
            dom1.setNumero(123);
            dom2.setCalle("San Martin");
            dom2.setLocalidad("Guaymallen");
            dom2.setNumero(234);
            dom3.setCalle("Uruguay");
            dom3.setLocalidad("Maipu");
            dom3.setNumero(654);

            Especialidad espe1 = new Especialidad();
            Especialidad espe2 = new Especialidad();
            Especialidad espe3 = new Especialidad();
            Especialidad espe4 = new Especialidad();
            espe1.setDenominacion("Traumatologia");
            espe2.setDenominacion("Alergias");
            espe3.setDenominacion("Dermatologia");
            espe4.setDenominacion("Cardiologia");
            ArrayList<Especialidad> especialidades1 = new ArrayList();
            especialidades1.add(espe1);
            especialidades1.add(espe2);
            ArrayList<Especialidad> especialidades2 = new ArrayList();
            especialidades2.add(espe3);
            especialidades2.add(espe4);

            ArrayList<Medico> medicos = new ArrayList();

            Medico medico = new Medico();
            dom1.setPersona(medico);
            medico.setDomicilio(dom1);
            medico.setApellido("Crespo");
            medico.setNombre("Mariana");
            medico.setDni(34567222);
            medico.setCelular(261322233);

            Medico medico2 = new Medico();
            dom2.setPersona(medico2);
            medico2.setDomicilio(dom2);
            medico2.setApellido("Gonzales");
            medico2.setNombre("Eliana");
            medico2.setDni(38587222);
            medico2.setCelular(261312299);
            medico2.setEspecialidades(especialidades1);
            medico2.setEspecialidades(especialidades2);
            medicos.add(medico);
            medicos.add(medico2);

            espe1.setMedicos(medicos);

            Paciente paciente = new Paciente();
            dom3.setPersona(paciente);
            paciente.setDomicilio(dom3);
            paciente.setApellido("Roca");
            paciente.setNombre("Julio");
            paciente.setDni(23456456);
            paciente.setNroSocio(1234);

            Turno turno1 = new Turno();
            Turno turno2 = new Turno();
            turno1.setFecha(fecha);
            turno1.setHora(17);
            turno1.setMinutos(30);
            turno1.setMedico(medico);
            turno1.setPaciente(paciente);
            turno2.setFecha(fecha);
            turno2.setHora(18);
            turno2.setMinutos(30);
            turno2.setMedico(medico2);
            turno2.setPaciente(paciente);

            HistoriaClinica historia = new HistoriaClinica();
            historia.setNumero(423232);
            historia.setPaciente(paciente);
            historia.setFechaAlta(fecha);
            ArrayList<DetalleHistoriaClinica> detalles = new ArrayList();
            DetalleHistoriaClinica detalle = new DetalleHistoriaClinica();
            DetalleHistoriaClinica detalle1 = new DetalleHistoriaClinica();
            detalle.setFechaAtencion(fecha);
            detalle.setObservaciones("dhsjdhsjds");
            detalle.setSintomas("fiebre");
            detalle.setDiagnostico("Gangrena");
            detalle.setHistoria(historia);
            detalle1.setFechaAtencion(fecha);
            detalle1.setObservaciones("Cambios de humor");
            detalle1.setSintomas("olor fuerte");
            detalle1.setDiagnostico("Fiebre amarilla");
            detalles.add(detalle);
            detalles.add(detalle1);
            historia.setDetalles(detalles);

            ControladorMedico cm = new ControladorMedico();
            cm.guardar(medico);
            cm.guardar(medico2);
            cm.getSesion().close();
            ControladorDomicilio cd = new ControladorDomicilio();
            cd.guardar(dom1);
            cd.guardar(dom2);
            cd.guardar(dom3);
            cd.getSesion().close();
            ControladorPaciente cp = new ControladorPaciente();
            cp.guardar(paciente);
            cp.getSesion().close();
            ControladorEspecialidad ce = new ControladorEspecialidad();
            ce.guardar(espe1);
            ce.guardar(espe2);
            ce.guardar(espe3);
            ce.guardar(espe4);
            ce.getSesion().close();
            ControladorHistoriaClinica chc = new ControladorHistoriaClinica();
            chc.guardar(historia);
            chc.guardarLista(detalles);
            chc.getSesion().close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
