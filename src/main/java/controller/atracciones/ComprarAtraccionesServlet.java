package controller.atracciones;
import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.ComprarAtraccionService;
import services.UsuarioService;

@WebServlet("/comprarAtraccion.do")
public class ComprarAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private ComprarAtraccionService comprarAtraccionService;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarAtraccionService = new ComprarAtraccionService();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idAtraccion = Integer.parseInt(req.getParameter("idAtraccion"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		int idUsuario = usuario.getIdUsuario();
		Map<String, String> compra = comprarAtraccionService.comprar(idUsuario, idAtraccion);
		usuario = usuarioService.buscar(usuario.getIdUsuario());
		req.getSession().setAttribute("usuario", usuario);
		
		if (compra.isEmpty()) {
			req.setAttribute("success", "Atraccion comprada");
		} else {
			req.setAttribute("compra", compra);
			req.setAttribute("flash", "No se realizo la compra de la atraccion");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/atracciones.do");
		dispatcher.forward(req, resp);
	}
}
