/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name="HistoriaClinica")
public class HistoriaClinica implements Serializable{
    
    private int idHistoriaClinica;
    private int numero;
    private Date fechaAlta;
    private Paciente paciente;
    private List<DetalleHistoriaClinica> detalles;

    public HistoriaClinica() {
    }

    
    


    @OneToMany(mappedBy = "historia",cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<DetalleHistoriaClinica> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleHistoriaClinica> detalles) {
        this.detalles = detalles;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

  


    @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "histora_id")
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    
    
    
    
}
