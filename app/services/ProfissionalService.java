package services;

import java.util.List;

import dao.ProfissionalDAO;
import models.Profissional;

public class ProfissionalService {

	public static Profissional getById(Long id) {
		return ProfissionalDAO.getById(id);
	}

	public static Profissional create(Profissional data) {
		return ProfissionalDAO.create(data);
	}

	public static Profissional update(Profissional data) {
		return ProfissionalDAO.update(data);
	}

	public static Boolean delete(Long id) {
		Profissional p = ProfissionalDAO.getById(id);
		if (p != null) {
			ProfissionalDAO.delete(id);
			return true;
		} else {
			return false;
		}
	}

	public static List<Profissional> listAll() {
		return ProfissionalDAO.listAll();
	}
	
	public static List<Profissional> listByParam(String param){
		return ProfissionalDAO.listByParam(param);
	}
}
