package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ColecaoDao;

@Service
public class ColecaoService {

	private ColecaoDao colecaoDao;

	@Autowired
	public void setColecaoDao(ColecaoDao colecaoDao) {
		this.colecaoDao = colecaoDao;
	}
}
