package Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turno.class)
public abstract class Turno_ {

	public static volatile SingularAttribute<Turno, Date> fecha;
	public static volatile SingularAttribute<Turno, Integer> hora;
	public static volatile SingularAttribute<Turno, Paciente> paciente;
	public static volatile SingularAttribute<Turno, Medico> medico;
	public static volatile SingularAttribute<Turno, Integer> minutos;
	public static volatile SingularAttribute<Turno, Integer> idTurno;

}

