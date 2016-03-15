package services;

import java.util.List;

import dao.ContatoDAO;
import models.Contato;

public class ContatoService {

	public static Contato getById(Long id) {
		return ContatoDAO.getById(id);
	}

	public static Contato create(Contato data) {
		return ContatoDAO.create(data);
	}

	public static Contato update(Contato data) {
		return ContatoDAO.update(data);
	}

	public static Boolean delete(Long id) {
		Contato c = ContatoDAO.getById(id);
		if (c != null) {
			ContatoDAO.delete(id);
			return true;
		} else {
			return false;
		}
	}

	public static List<Contato> listAll() {
		return ContatoDAO.listAll();
	}
	
	public static List<Contato> listByParam(String param) {
		return ContatoDAO.listByParam(param);
	}

}
