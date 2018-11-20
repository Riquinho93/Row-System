//package TesteUnit;
//
//import java.awt.List;
//
//import org.apache.log4j.Logger;
//
//import Controller.DaoFactory;
//import Dao.ColecaoDao;
//import Model.ColecaoModel;
//
//public class ColecaoRepositoryTest {
//	private static final Logger LOGGER = Logger.getLogger(ColecaoRepositoryTest.class);
//	
//	private ColecaoDao colecaoDao = DaoFactory.entityManagerFactorInstance();
//	
//	public void testFindAll(){
//		List<ColecaoModel> colecao = this.colecaoDao.findAll();
//		
//		LOGGER.info(colecao);
//	}
//}
