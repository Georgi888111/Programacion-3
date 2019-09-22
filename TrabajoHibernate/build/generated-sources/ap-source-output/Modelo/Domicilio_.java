package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Domicilio.class)
public abstract class Domicilio_ {

	public static volatile SingularAttribute<Domicilio, Persona> persona;
	public static volatile SingularAttribute<Domicilio, Integer> numero;
	public static volatile SingularAttribute<Domicilio, String> calle;
	public static volatile SingularAttribute<Domicilio, String> localidad;
	public static volatile SingularAttribute<Domicilio, Integer> idDomicilio;

}

