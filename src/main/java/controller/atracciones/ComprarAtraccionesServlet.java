package controller.atracciones;
import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.ComprarAtraccionService;

@WebServlet("/comprar.do")
public class ComprarAtraccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 3455721046062278592L;
	private ComprarAtraccionService comprarAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarAtraccionService = new ComprarAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("entro");
		int idAtraccion = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		int idUsuario = usuario.getIdUsuario();
		Itinerario itinerario = usuario.getItinerario();
		System.out.println(usuario.getItinerario().getIdItinerario());
		//Itinerario itinerario = (Itinerario) req.getSession().getAttribute("itinerario");
		//int idItinerario = itinerario.getIdItinerario();
		Map<String, String> compra = comprarAtraccionService.comprar(idUsuario, idAtraccion, itinerario.getIdItinerario());
		Usuario buscarUsuario = DAOFactory.getUsuarioDAO().findById(usuario.getIdUsuario());
		req.getSession().setAttribute("usuario", buscarUsuario);
		
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
