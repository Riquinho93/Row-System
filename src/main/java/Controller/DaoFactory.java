package Controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DaoFactory {
	
	private DaoFactory() {}
	
	//Entitade adm do Factory
	
	private static final String MODEL = "Model";
	
	private static EntityManagerFactory entityManagerFactoryInstance;
	
	public static EntityManagerFactory entityManagerFactorInstance(){
		if (entityManagerFactoryInstance == null) {
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(MODEL);
		}
		return entityManagerFactoryInstance;
	}
}
