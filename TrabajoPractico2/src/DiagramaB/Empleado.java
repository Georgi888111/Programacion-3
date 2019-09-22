
package DiagramaB;

import java.util.ArrayList;

public class Empleado {

    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;
    private ArrayList<Tardanza> tardanzas = new ArrayList();
    private ArrayList<Asistencia> asistencias = new ArrayList();
    private RegimenHorario regimen;

    public Empleado() {
    }

    public RegimenHorario getRegimen() {
        return regimen;
    }

    public void setRegimen(RegimenHorario regimen) {
        this.regimen = regimen;
    }

    public void addTardanza(Tardanza tardanza) {
        this.tardanzas.add(tardanza);
    }

    public void addAsistencia(Asistencia asistencia) {
        this.asistencias.add(asistencia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Asistencia> getAsistenciaXmesXanio(int mes, int año) {
        ArrayList<Asistencia> asistenciasFiltradas = new ArrayList();
        for (int i = 0; i < this.asistencias.size(); i++) {
            if ((this.asistencias.get(i).getFecha().getYear() == año) && (this.asistencias.get(i).getFecha().getMonthValue() == mes)) {
                asistenciasFiltradas.add(this.asistencias.get(i));
            }
        }
        return asistenciasFiltradas;
    }

    public ArrayList<Tardanza> getTardanzaXmesXanio(int mes, int año) {
        ArrayList<Tardanza> tardanzasFiltradas = new ArrayList();
        for (int i = 0; i < this.tardanzas.size(); i++) {
            if ((this.tardanzas.get(i).getFecha().getYear() == año) && (this.tardanzas.get(i).getFecha().getMonthValue() == mes)) {
                tardanzasFiltradas.add(this.tardanzas.get(i));
            }
        }
        return tardanzasFiltradas;
    }

}
