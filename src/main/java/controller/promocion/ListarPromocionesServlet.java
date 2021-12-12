package controller.promocion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.PromocionService;

@WebServlet("/admin/promociones/index.do")
public class ListarPromocionesServlet extends HttpServlet {

	private static final long serialVersionUID = 403834231674561110L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Promocion> promociones = promocionService.listar();
		req.setAttribute("promociones", promociones);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/promociones/index.jsp");
		dispatcher.forward(req, resp);
	}
}
