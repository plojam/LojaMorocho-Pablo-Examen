package ec.edu.ups.jpa;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	public TipoTelefonoDAO getTipoTelefonoDAO() {
		return new JPATipoTelefonoDAO();
	}

	public OperadoraDAO getOperadoraDAO() {
		return new JPAOperadoraDAO();
	}

	public TelefonoDAO getTelefonoDAO() {
		return new JPATelefonoDAO();
	}

}
