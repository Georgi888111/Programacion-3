package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ extends Modelo.Persona_ {

	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> usuario;
	public static volatile ListAttribute<Usuario, Contacto> contactos;

	public static final String PASSWORD = "password";
	public static final String ID_USUARIO = "idUsuario";
	public static final String USUARIO = "usuario";
	public static final String CONTACTOS = "contactos";

}

