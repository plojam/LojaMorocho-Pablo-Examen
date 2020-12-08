package ec.edu.ups.jpa;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {

	public JPATelefonoDAO() {
		super(Telefono.class);
	}

	public int IdUsuarioPorNumero(String numero) {
		String jpql = "SELECT t.usuario.id FROM Telefono t WHERE t.numero='" + numero + "'";
		int usuId = (int) em.createQuery(jpql).getSingleResult();
		return usuId;
	}

}
