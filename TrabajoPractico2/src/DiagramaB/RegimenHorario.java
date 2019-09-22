
package DiagramaB;


public class RegimenHorario {
 private long id;
 private int horaIngreso;
 private int minutoIngreso;
 private int horaEgreso;
 private int minutoEgreso;
 private Empleado empleado;

    public RegimenHorario() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getMinutoIngreso() {
        return minutoIngreso;
    }

    public void setMinutoIngreso(int minutoIngreso) {
        this.minutoIngreso = minutoIngreso;
    }

    public int getHoraEgreso() {
        return horaEgreso;
    }

    public void setHoraEgreso(int horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public int getMinutoEgreso() {
        return minutoEgreso;
    }

    public void setMinutoEgreso(int minutoEgreso) {
        this.minutoEgreso = minutoEgreso;
    }
 
 public boolean verificaSiEsTardanza(int hora, int minuto){
     boolean valida = false;
     if((this.horaIngreso>14)||(this.minutoIngreso>15)){
         valida = true;
     }
     
     return valida;
 }
 
}
