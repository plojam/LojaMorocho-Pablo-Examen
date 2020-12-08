package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer> {
	
	public int IdUsuarioPorNumero(String numero);
	
}
