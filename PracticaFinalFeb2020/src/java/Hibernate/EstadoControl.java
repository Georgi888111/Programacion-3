/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "EstadoControl")
public class EstadoControl implements Serializable {
    private long id;
    private boolean aprobado;
    private Expediente expediente;
    private Control control;

      @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_expediente")
    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_control")
    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }
    
    
     @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
    
    
}
