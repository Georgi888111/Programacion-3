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
@Table(name = "Telefonos")

public class ContactoTelefono implements Serializable {

    private Integer idContactoTelefono;
    private String codigo;
    private String numero;

    public ContactoTelefono() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTel", unique = true, nullable = false, insertable = false, updatable = false)
    public Integer getIdContactoTelefono() {
        return idContactoTelefono;
    }

    public void setIdContactoTelefono(Integer idContactoTelefono) {
        this.idContactoTelefono = idContactoTelefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}