package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	public Usuario buscarPorCedula(String cedula) {
		String jpql = "SELECT u FROM Usuario u WHERE u.cedula='" + cedula + "'";
		Usuario usu = (Usuario) em.createQuery(jpql).getSingleResult();
		return usu;
	}


}
