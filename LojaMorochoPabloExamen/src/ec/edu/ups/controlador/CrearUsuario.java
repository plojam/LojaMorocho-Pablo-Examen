package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Operadora;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.TipoTelefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private OperadoraDAO opedao;
	private TipoTelefonoDAO tipodao;
	private UsuarioDAO usudao;
    public CrearUsuario() {
        super();
        opedao = DAOFactory.getFactory().getOperadoraDAO();
        tipodao = DAOFactory.getFactory().getTipoTelefonoDAO();
        usudao = DAOFactory.getFactory().getUsuarioDAO();
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
		
		try {

			String nombres = (String) request.getParameter("nombres");
			String apellidos = (String) request.getParameter("apellidos");
			String cedula = (String) request.getParameter("cedula");
			String correo = (String) request.getParameter("correo");
			String contrasena = (String) request.getParameter("contrasena");
			
			Usuario usuario = new Usuario(0, cedula, nombres, apellidos, correo, contrasena);
			
			int cantidad = Integer.parseInt((String) request.getParameter("numero"));
			
			
			for(int i=0; i<cantidad; i++) {
				String numero = (String) request.getParameter("numerotel"+i);
				int tipoId = Integer.valueOf(request.getParameter("tipotel"+i));
				TipoTelefono tipo = tipodao.read(tipoId);
				
				int operadoraId = Integer.valueOf(request.getParameter("operadoratel"+i));
				Operadora operadora = opedao.read(operadoraId);
				
				Telefono telefono = new Telefono(0, numero, tipo, operadora, usuario);
				
				usuario.addTelefono(telefono);
			}
			
			usudao.create(usuario);
			
			url = "/HTMLs/index.html";
			
		} catch (Exception e) {
			System.out.print("Error Registrar: " + e);
			url = "/HTMLs/index.html";
		}
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
