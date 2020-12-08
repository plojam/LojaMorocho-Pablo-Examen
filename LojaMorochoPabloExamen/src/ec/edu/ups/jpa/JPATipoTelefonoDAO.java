package ec.edu.ups.jpa;

import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.modelo.TipoTelefono;

public class JPATipoTelefonoDAO extends JPAGenericDAO<TipoTelefono, Integer> implements TipoTelefonoDAO {

	public JPATipoTelefonoDAO() {
		super(TipoTelefono.class);
	}

}
