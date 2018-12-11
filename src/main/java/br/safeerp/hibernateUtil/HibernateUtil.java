package br.safeerp.hibernateUtil;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static void criarSessionFactory(){
		try {
			Configuration configuracao =  new Configuration().configure();
			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			SessionFactory session = configuracao.buildSessionFactory(registro);
		} catch (Throwable e) {
            System.err.println("Erro ao inicializar o SessionFactory." + e);
            throw new ExceptionInInitializerError(e);
		}
	}

}
