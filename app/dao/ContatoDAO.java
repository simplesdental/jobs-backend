package dao;

import java.util.List;

import models.Contato;
import play.db.jpa.JPA;

public class ContatoDAO {

	public static Contato getById(Long id) {
		return JPA.em().find(Contato.class, id);
	}

	public static Contato create(Contato c) {
		JPA.em().persist(c);
		JPA.em().flush();
		JPA.em().refresh(c);
		return c;
	}

	public static Contato update(Contato c) {
		return JPA.em().merge(c);
	}
	
	public static void delete(Long id){
		Contato c = JPA.em().getReference(Contato.class, id);
		JPA.em().remove(c);
	}
	
	public static List<Contato> listAll(){
		return (List<Contato>) JPA.em().createQuery("SELECT c FROM " + Contato.class.getSimpleName() + " c ORDER BY id").getResultList();	
	}
	
	public static List<Contato> listByParam(String param) {
		return (List<Contato>) JPA.em()
				.createQuery("SELECT c FROM " + Contato.class.getSimpleName() + " c WHERE lower(c.nome) LIKE lower(:param) or c.contato LIKE :param ORDER BY id")
				.setParameter("param", "%" + param + "%")
				.getResultList();	
		}

}
