package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contacto.class)
public abstract class Contacto_ extends Modelo.Persona_ {

	public static volatile SingularAttribute<Contacto, ContactoTipo> tipo;
	public static volatile SingularAttribute<Contacto, Integer> idContacto;
	public static volatile ListAttribute<Contacto, ContactoDomicilio> domicilios;
	public static volatile ListAttribute<Contacto, ContactoTelefono> telefonos;

	public static final String TIPO = "tipo";
	public static final String ID_CONTACTO = "idContacto";
	public static final String DOMICILIOS = "domicilios";
	public static final String TELEFONOS = "telefonos";

}

