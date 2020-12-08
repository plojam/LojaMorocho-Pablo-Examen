package ec.edu.ups.jpa;

import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.modelo.Operadora;

public class JPAOperadoraDAO extends JPAGenericDAO<Operadora, Integer> implements OperadoraDAO {
	
	public JPAOperadoraDAO() {
		super(Operadora.class);
	}
	
}
