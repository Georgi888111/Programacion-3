package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medico.class)
public abstract class Medico_ extends Modelo.Persona_ {

	public static volatile ListAttribute<Medico, Especialidad> especialidades;
	public static volatile SingularAttribute<Medico, Integer> matricula;
	public static volatile ListAttribute<Medico, Turno> turnos;
	public static volatile SingularAttribute<Medico, Long> celular;
	public static volatile SingularAttribute<Medico, Integer> idMedico;

}

