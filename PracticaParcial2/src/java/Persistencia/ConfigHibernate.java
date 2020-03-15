/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;
import Modelo.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author juan
 */
public class ConfigHibernate {

    private static SessionFactory sessionFactory;

    public static SessionFactory load() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/baseagenda");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");//
                settings.put(Environment.C3P0_MIN_SIZE, "0");
                settings.put(Environment.C3P0_MAX_SIZE, "7");
                settings.put(Environment.C3P0_TIMEOUT, "100");
                settings.put(Environment.C3P0_IDLE_TEST_PERIOD, "100");
                settings.put(Environment.AUTOCOMMIT, "true");
                settings.put(Environment.C3P0_MAX_STATEMENTS, "100");
                settings.put(Environment.TRANSACTION_COORDINATOR_STRATEGY, "jdbc");

                configuration.setProperties(settings);
                configuration.addPackage("Modelo");
                configuration.addAnnotatedClass(Persona.class);
                configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Contacto.class);
                configuration.addAnnotatedClass(ContactoTelefono.class);
                configuration.addAnnotatedClass(ContactoDomicilio.class);
                configuration.addAnnotatedClass(ContactoTipo.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }//getSession

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
