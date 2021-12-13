package controller.usuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoDeAtraccion;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/admin/usuarios/editar.do")
public class ModificarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -3219845920568287825L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int idUsuario = Integer.parseInt(id);
		Usuario usuarioAEditar = this.usuarioService.buscar(idUsuario);
		req.setAttribute("usuarioAEditar", usuarioAEditar);
		req.setAttribute("tipoDeAtracciones", TipoDeAtraccion.values());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/usuarios/editar.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		int presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		TipoDeAtraccion tipoFavorito = TipoDeAtraccion.values()[Integer.parseInt(req.getParameter("tipoFavorito"))];
		boolean esAdmin = "on".equals(req.getParameter("esAdmin")) ? true : false;
		int idUsuario = Integer.parseInt(req.getParameter("id"));
		
		Usuario usuarioAEditar = usuarioService.modificar(idUsuario, esAdmin, nombre, presupuesto, tiempoDisponible, tipoFavorito);
		
		if (usuarioAEditar.esValido()) {
			resp.sendRedirect(req.getContextPath() + "/admin/usuarios/index.do");
		} else {
			req.setAttribute("usuarioAEditar", usuarioAEditar);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/usuarios/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
