package controller.promocion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.PromocionService;

@WebServlet("/admin/promociones/ver.do")
public class VerPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 2518513071711092389L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromocion = Integer.parseInt(req.getParameter("id"));
		Promocion promocionAVer = promocionService.buscar(idPromocion);
		req.setAttribute("promocionAVer", promocionAVer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/promociones/promocion.jsp");
		dispatcher.forward(req, resp);
	}

}
