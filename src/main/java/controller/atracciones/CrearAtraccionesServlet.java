package controller.atracciones;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoDeAtraccion;
import services.AtraccionService;

@WebServlet("/admin/atracciones/crear.do")
public class CrearAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("tipoDeAtraccion", TipoDeAtraccion.values());
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/admin/atracciones/crear.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		String imagen = req.getParameter("imagen");
		int costoVisita = Integer.parseInt(req.getParameter("costoVisita"));
		double tiempoParaRealizarla = Double.parseDouble(req.getParameter("tiempoParaRealizarla"));
		int cupoPersonas = Integer.parseInt(req.getParameter("cupoPersonas"));
		int visitantes = Integer.parseInt(req.getParameter("visitantes"));
		TipoDeAtraccion tipoDeAtraccion = TipoDeAtraccion.values()[Integer.parseInt(req.getParameter("tipoDeAtraccion"))];
		Atraccion atraccion = atraccionService.crear(nombre,descripcion,imagen, costoVisita, tiempoParaRealizarla, cupoPersonas,visitantes,tipoDeAtraccion);
		
		if (atraccion.isValid()) {
			resp.sendRedirect("/TP03-TurismoEnLaTierraMedia/admin/atracciones/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/TP03-TurismoEnLaTierraMedia/admin/atracciones/index.do");
			dispatcher.forward(req, resp);
		}

	}

}