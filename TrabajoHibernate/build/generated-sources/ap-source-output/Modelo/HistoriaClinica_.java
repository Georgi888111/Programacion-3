package Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistoriaClinica.class)
public abstract class HistoriaClinica_ {

	public static volatile SingularAttribute<HistoriaClinica, Integer> numero;
	public static volatile SingularAttribute<HistoriaClinica, Date> fechaAlta;
	public static volatile SingularAttribute<HistoriaClinica, Paciente> paciente;
	public static volatile SingularAttribute<HistoriaClinica, Integer> idHistoriaClinica;
	public static volatile ListAttribute<HistoriaClinica, DetalleHistoriaClinica> detalles;

}

