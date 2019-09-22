package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Especialidad.class)
public abstract class Especialidad_ {

	public static volatile SingularAttribute<Especialidad, String> denominacion;
	public static volatile ListAttribute<Especialidad, Medico> medicos;
	public static volatile SingularAttribute<Especialidad, Integer> idEspecialidad;

}

