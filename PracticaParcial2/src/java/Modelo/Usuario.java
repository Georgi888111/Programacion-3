/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.Conexion;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author franc
 */
@Entity
@Table(name = "Usuarios")
public class Usuario extends Persona implements Serializable {

    private Integer idUsuario;
    private String usuario;
    private String password;
    private List<Contacto> contactos = new ArrayList<>();
    private Conexion conexion;
    
    public Usuario() {
          this.conexion = new Conexion();
    }

    
    public Usuario(String nombre, String apellido, Integer idPersona) {
        super(nombre, apellido, idPersona);
    }

    @Column(name = "idUsuario")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idContacto")
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
  public void cargaUsuario(Usuario usuario) throws SQLException{
        conexion.estableceConexion("localhost", "3306", "root", "", "baseagenda");
       conexion.agregar(usuario);
    }
}
