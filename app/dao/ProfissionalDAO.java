package dao;

import java.util.List;

import models.Contato;
import models.Profissional;
import play.db.jpa.JPA;

public class ProfissionalDAO {

	public static Profissional getById(Long id) {
		return JPA.em().find(Profissional.class, id);
	}

	public static Profissional create(Profissional p) {
		JPA.em().persist(p);
		JPA.em().flush();
		JPA.em().refresh(p);
		return p;
	}

	public static Profissional update(Profissional p) {
		return JPA.em().merge(p);
	}

	public static void delete(Long id) {
		Profissional p = JPA.em().getReference(Profissional.class, id);
		JPA.em().remove(p);
	}

	public static List<Profissional> listAll() {
		return (List<Profissional>) JPA.em()
				.createQuery("SELECT p FROM " + Profissional.class.getSimpleName() + " p ORDER BY id").getResultList();
	}

	public static List<Profissional> listByParam(String param) {
		return (List<Profissional>) JPA.em()
				.createQuery("SELECT p FROM " + Profissional.class.getSimpleName() + " p WHERE lower(p.nome) LIKE lower(:param) ORDER BY id")
				.setParameter("param", "%" + param + "%")
				.getResultList();
	}
}
