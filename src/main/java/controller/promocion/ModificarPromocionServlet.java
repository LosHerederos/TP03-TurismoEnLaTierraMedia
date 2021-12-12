package controller.promocion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import model.TipoDeAtraccion;
import services.PromocionService;

@WebServlet("/admin/promociones/editar.do")
public class ModificarPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 2740205205640274929L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromocion = Integer.parseInt(req.getParameter("id"));
		Promocion promocionAEditar = this.promocionService.buscar(idPromocion);
		req.setAttribute("promocionAEditar", promocionAEditar);
		req.setAttribute("tipoDeAtracciones", TipoDeAtraccion.values());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/promociones/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
