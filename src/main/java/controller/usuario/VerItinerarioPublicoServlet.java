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

@WebServlet("/itinerario.do")
public class VerItinerarioPublicoServlet extends HttpServlet {

	private static final long serialVersionUID = -4821519633127757061L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String id = req.getParameter("id");
		//int idUsuario = Integer.parseInt(id);
		//Usuario usuarioAVer = this.usuarioService.buscar(idUsuario);
		//req.setAttribute("usuarioAVer", usuarioAVer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/publico/itinerario.jsp");
		dispatcher.forward(req, resp);
	}
}
