/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Modelo.ContactoTelefono;

/**
 *
 * @author franc
 */
@Entity
@Table(name = "Contactos")
public class Contacto extends Persona implements Serializable {

    private Integer idContacto;
    private ContactoTipo tipo;
    private List<ContactoDomicilio> domicilios = new ArrayList<>();
    private List<ContactoTelefono> telefonos = new ArrayList<>();

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, Integer idPersona) {
        super(nombre, apellido, idPersona);
    }

    @Column(name = "idContacto")
    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipo")
    public ContactoTipo getTipo() {
        return tipo;
    }

    public void setTipo(ContactoTipo tipo) {
        this.tipo = tipo;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idDomi")
    public List<ContactoDomicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<ContactoDomicilio> domicilios) {
        this.domicilios = domicilios;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idTel")
    public List<ContactoTelefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<ContactoTelefono>telefonos) {
        this.telefonos = telefonos;
    }


}
