package Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalleHistoriaClinica.class)
public abstract class DetalleHistoriaClinica_ {

	public static volatile SingularAttribute<DetalleHistoriaClinica, HistoriaClinica> historia;
	public static volatile SingularAttribute<DetalleHistoriaClinica, String> diagnostico;
	public static volatile SingularAttribute<DetalleHistoriaClinica, Integer> idDetalleHC;
	public static volatile SingularAttribute<DetalleHistoriaClinica, String> observaciones;
	public static volatile SingularAttribute<DetalleHistoriaClinica, Date> fechaAtencion;
	public static volatile SingularAttribute<DetalleHistoriaClinica, String> sintomas;

}

