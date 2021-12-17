package controller.promocion;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.ComprarPromocionService;
import services.UsuarioService;

@WebServlet("/comprarPromocion.do")
public class ComprarPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = -6458594666025267919L;
	private ComprarPromocionService comprarPromocionService;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarPromocionService = new ComprarPromocionService();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromocion = Integer.parseInt(req.getParameter("idPromocion"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		int idUsuario = usuario.getIdUsuario();
		Map<String, String> compra = comprarPromocionService.comprar(idUsuario, idPromocion);
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
