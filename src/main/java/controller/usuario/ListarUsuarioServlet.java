package controller.usuario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/admin/usuarios/index.do")
public class ListarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -4451228653617318454L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.listar();
		req.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/usuarios/index.jsp");
		dispatcher.forward(req, resp);
		
	}
}
