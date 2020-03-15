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
@Table(name = "Domicilios")
public class ContactoDomicilio implements Serializable {

    private Integer idContactoDomicilio;
    private String descripcion;

    public ContactoDomicilio() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDomi", unique = true, nullable = false, insertable = false, updatable = false)
    public Integer getIdContactoDomicilio() {
        return idContactoDomicilio;
    }

    public void setIdContactoDomicilio(Integer idContactoDomicilio) {
        this.idContactoDomicilio = idContactoDomicilio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}