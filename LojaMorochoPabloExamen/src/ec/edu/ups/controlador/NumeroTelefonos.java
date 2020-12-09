package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class NumeroTelefonos
 */
@WebServlet("/NumeroTelefonos")
public class NumeroTelefonos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private OperadoraDAO opedao;
	private TipoTelefonoDAO tipodao;
    public NumeroTelefonos() {
        super();
        opedao = DAOFactory.getFactory().getOperadoraDAO();
        tipodao = DAOFactory.getFactory().getTipoTelefonoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cantidad = Integer.parseInt((String) request.getParameter("numero"));
		int contador;
		
		List<Operadora> operadoras = opedao.find();
		List<TipoTelefono> tipos = tipodao.find();
		
		response.setContentType("text/htm");
		PrintWriter out = response.getWriter();
		
		for(int i=0; i<cantidad; i++) {
			contador = i+1;
			out.println("<h3>Telefono "+contador+"</h3>");
			out.println("<input class='tel' type='text' name='numerotel"+i+"'>");
			
			String selTipo="";
			for(int j=0;j<tipos.size();j++) {
				selTipo = selTipo + "<option value=" + tipos.get(j).getId() + ">" + tipos.get(j).getTipo() + "</option> ";
			}
			out.println("<select name='tipotel"+i+"'>"
					+ selTipo
					+ "</select>");
			
			String selOperadoras="";
			for(int j=0;j<operadoras.size();j++) {
				selOperadoras = selOperadoras + "<option value=" + operadoras.get(j).getId() + ">" + operadoras.get(j).getNombre() + "</option> ";
			}
			out.println("<select name='operadoratel"+i+"'>"
					+ selOperadoras
					+ "</select>");
		}

		out.println("<br><input type='submit' value='Generar Operadora y Tipos'>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
