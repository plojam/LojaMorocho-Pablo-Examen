package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class BuscarPorCedula
 */
@WebServlet("/BuscarPorCedula")
public class BuscarPorCedula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UsuarioDAO usudao;
    public BuscarPorCedula() {
        super();
        usudao = DAOFactory.getFactory().getUsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/htm");
		PrintWriter out = response.getWriter();
		
		//out.println("llega");
		
		String cedula = (String) request.getParameter("cedula");
		
		try {
			Usuario usuario = usudao.buscarPorCedula(cedula);
			
			out.println("<table class='table'>" +
					"<tr><td class='titulo'><strong>Nombres</strong></td>" +
					"<td class='titulo'><strong>Apellidos</strong></td>" +
					"<td class='titulo'><strong>Cedula</strong></td>" + 
					"<td class='titulo'><strong>Correo</strong></td></tr>");
			
			out.println("<tr><td>" + usuario.getNombres() + "</td>");
	        out.println("<td>" + usuario.getApellidos() + "</td>");
	        out.println("<td>" + usuario.getCedula() + "</td>");
	        out.println("<td>" + usuario.getCorreo() + "</td></tr></table>");
	        
	        out.println("<table class='table'>" +
					"<tr><td class='titulo'><strong>Numero</strong></td>" +
					"<td class='titulo'><strong>Tipo</strong></td>" +
					"<td class='titulo'><strong>Operadora</strong></td></tr>");
	        for(int j = 0; j < usuario.getTelefonos().size(); j++){
	        	out.println("<tr><td>" + usuario.getTelefonos().get(j).getNumero() + "</td>");
	            out.println("<td>" + usuario.getTelefonos().get(j).getTipo().getTipo() + "</td>");
	            out.println("<td>" + usuario.getTelefonos().get(j).getOperadora().getNombre() + "</td></tr>");
	        }
		}catch (Exception e) {
			out.println("<p>Usuario no encontrado</p>");
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
