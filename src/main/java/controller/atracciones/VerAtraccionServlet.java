package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/admin/atracciones/ver.do")
public class VerAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = -1898784593646746172L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromocion = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccionAVer = atraccionService.buscar(idPromocion);
		req.setAttribute("atraccionAVer", atraccionAVer);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/atracciones/atraccion.jsp");
		dispatcher.forward(req, resp);
	}
}
