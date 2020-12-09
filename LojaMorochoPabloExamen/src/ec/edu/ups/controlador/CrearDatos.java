package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.modelo.Operadora;
import ec.edu.ups.modelo.TipoTelefono;

/**
 * Servlet implementation class CrearDatos
 */
@WebServlet("/CrearDatos")
public class CrearDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private OperadoraDAO opedao;
	private TipoTelefonoDAO tipodao;
    public CrearDatos() {
        super();
        opedao = DAOFactory.getFactory().getOperadoraDAO();
        tipodao = DAOFactory.getFactory().getTipoTelefonoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		

		List<Operadora> operadoras = opedao.find();
		List<TipoTelefono> tipos = tipodao.find();
		
		
		if(operadoras.size()==0) {
			Operadora o1 = new Operadora(0, "Movistar");
			Operadora o2 = new Operadora(0, "Claro");
			Operadora o3 = new Operadora(0, "CNT");
			Operadora o4 = new Operadora(0, "Etapa");
			opedao.create(o1);
			opedao.create(o2);
			opedao.create(o3);
			opedao.create(o4);
			System.out.println("Se crearon operadoras");
		}else {
			System.out.println("Ya existen operadoras");
		}
		
		if(tipos.size()==0) {
			TipoTelefono t1 = new TipoTelefono(0, "Celular");
			TipoTelefono t2 = new TipoTelefono(0, "Convencional");
			tipodao.create(t1);
			tipodao.create(t2);
			System.out.println("Se crearon los tipos de telefono");
		}else {
			System.out.println("Ya existen tipos de telefonos");
		}
		
		
		url = "/HTMLs/index.html";
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
