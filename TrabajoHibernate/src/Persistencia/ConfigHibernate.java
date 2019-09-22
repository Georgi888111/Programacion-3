/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.DetalleHistoriaClinica;
import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.Especialidad;
import Modelo.HistoriaClinica;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Persona;
import Modelo.Turno;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ConfigHibernate {

    private static SessionFactory sessionFactory;

    //El metodo load() hace todas las conexiones pertinentes
    public static void load() {

        try {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/practicahibernate");
            config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "");
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            config.setProperty("hibernate.show_sql", "true");
            config.setProperty("hibernate.hbm2ddl.auto", "update");
            config.setProperty("hibernate.c3p0.min_size", "0");
            config.setProperty("hibernate.c3p0.max_size", "7");
            config.setProperty("hibernate.c3p0.timeout", "100");
            config.setProperty("hibernate.c3p0.max_elements", "100");
            config.setProperty("hibernate.c3p0.idle_test_period", "100");
            config.setProperty("hibernate.c3p0.autoCommitOnClose", "true");
            config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

            config.addPackage("Modelo");
            config.addAnnotatedClass(Persona.class);
            config.addAnnotatedClass(Domicilio.class);
            config.addAnnotatedClass(Medico.class);
            config.addAnnotatedClass(Empleado.class);
            config.addAnnotatedClass(Paciente.class);
            config.addAnnotatedClass(HistoriaClinica.class);
            config.addAnnotatedClass(DetalleHistoriaClinica.class);
            config.addAnnotatedClass(Especialidad.class);
            config.addAnnotatedClass(Turno.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Error: HibernateUtil.HibernateException: " + e.getMessage());
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    //Metodo al que llaman los controladores, retorna la sesion.
    public synchronized static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }
//Metodo invocado por openSession, si la conexion es null llama al metodo load()
    public synchronized static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            load();
        }

        return sessionFactory;
    }

    public synchronized static void closeSessionFactory() {
        try {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory = null;
        }
    }

    public boolean save(Session sezion, Object object) {
        Transaction tx = null;

        if (!sezion.getTransaction().isActive()) {
            tx = sezion.beginTransaction();
        }

        sezion.saveOrUpdate(object);

        if (tx != null) {
            tx.commit();
        }

        return true;
    }

    public boolean deleteObject(Session sezion, Object object) {
        Transaction tx = sezion.beginTransaction();

        sezion.delete(object);

        tx.commit();

        return true;
    }

    public boolean update(Session sezion, Object object) {
        Transaction tx = null;

        if (!sezion.getTransaction().isActive()) {
            tx = sezion.beginTransaction();
        }

        sezion.update(object);

        if (tx != null) {
            tx.commit();
        }

        return true;
    }

    public boolean delete(Session sezion, List entities) {

        for (Iterator i = entities.iterator(); i.hasNext();) {
            Object object = (Object) i.next();

            sezion.delete(object);
        }

        return true;
    }

    public void destroy() {
        closeSessionFactory();
    }

}
