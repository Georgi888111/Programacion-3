package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ extends Modelo.Persona_ {

	public static volatile SingularAttribute<Paciente, Integer> idPaciente;
	public static volatile SingularAttribute<Paciente, HistoriaClinica> historia;
	public static volatile SingularAttribute<Paciente, Integer> nroSocio;
	public static volatile ListAttribute<Paciente, Turno> turnos;

}

