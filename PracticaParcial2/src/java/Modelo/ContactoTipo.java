/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author franc
 */
@Entity
@Table(name = "TiposContacto")
public class ContactoTipo implements Serializable {

    private Integer idContactoTipo;
    private String descripcion;

    public ContactoTipo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipo", unique = true, nullable = false, insertable = false, updatable = false)
    public Integer getIdContactoTipo() {
        return idContactoTipo;
    }

    public void setIdContactoTipo(Integer idContactoTipo) {
        this.idContactoTipo = idContactoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
