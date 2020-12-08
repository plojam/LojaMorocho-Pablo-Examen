package ec.edu.ups.controlador;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.modelo.Operadora;
import ec.edu.ups.modelo.TipoTelefono;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperadoraDAO opedao = DAOFactory.getFactory().getOperadoraDAO();
		Operadora o1 = new Operadora(0, "Movistar");
		Operadora o2 = new Operadora(0, "Claro");
		Operadora o3 = new Operadora(0, "CNT");
		Operadora o4 = new Operadora(0, "Etapa");
		opedao.create(o1);
		opedao.create(o2);
		opedao.create(o3);
		opedao.create(o4);
		TipoTelefonoDAO tipodao = DAOFactory.getFactory().getTipoTelefonoDAO();
		TipoTelefono t1 = new TipoTelefono(0, "Celular");
		TipoTelefono t2 = new TipoTelefono(0, "Convencional");
		tipodao.create(t1);
		tipodao.create(t2);
		
	}

}
