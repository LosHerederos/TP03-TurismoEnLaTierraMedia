package controller.promocion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.TipoDeAtraccion;
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/admin/promociones/crear.do")
public class CrearPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = -3899594253759382747L;
	
	private AtraccionService atraccionService;
	private PromocionService promocionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Atraccion> atracciones = this.atraccionService.listar();
		req.setAttribute("atracciones", atracciones);
		req.setAttribute("tipoDeAtracciones", TipoDeAtraccion.values());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/promociones/crear.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		String imagen = req.getParameter("imagen");
		TipoDeAtraccion tipoDeAtraccion = TipoDeAtraccion.values()[Integer.parseInt(req.getParameter("tipoDeAtraccion"))];
		String atraccionesIds[] = req.getParameterValues("atracciones");
		String tipoDePromocion = req.getParameter("tipoDePromocion") != null ? req.getParameter("tipoDePromocion") : req.getParameter("tipoActual");
		
		List<Atraccion> atracciones = this.atraccionService.buscar(atraccionesIds);
		Object datoExtra = null;
		if (tipoDePromocion.equals("absoluta")) {
			datoExtra = Integer.parseInt(req.getParameter("costoTotal"));
		} else if (tipoDePromocion.equals("axb")) {
			String atraccionesPagasIds[] = req.getParameterValues("atraccionesPagas");
			datoExtra = this.atraccionService.buscar(atraccionesPagasIds);
		} else if (tipoDePromocion.equals("porcentual")) {
			datoExtra = Double.parseDouble(req.getParameter("porcentaje"));
		}
		System.out.println(nombre + " " + descripcion + " " + imagen + " " + tipoDeAtraccion + " " + tipoDePromocion);
		for (String atraccionId : atraccionesIds) {
			System.out.print(atraccionId + " ");
		}
		
		Promocion promocionACrear = this.promocionService.crear(nombre, descripcion, imagen, tipoDeAtraccion, atracciones, tipoDePromocion, datoExtra);
		
		if (promocionACrear.esValido()) {
			resp.sendRedirect(req.getContextPath() + "/admin/promociones/index.do");
		} else {
			req.setAttribute("promocionACrear", promocionACrear);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/promociones/crear.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
