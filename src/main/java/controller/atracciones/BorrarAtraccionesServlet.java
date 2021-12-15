package controller.atracciones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;
@WebServlet("/admin/atracciones/borrar.do")
public class BorrarAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private AtraccionService atraccionService;
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		this.atraccionService.buscar(id);
		Atraccion atraccion = this.atraccionService.buscar(id);
		req.setAttribute("atraccion", atraccion);
		this.atraccionService.borrar(atraccion);
		resp.sendRedirect("/TP03-TurismoEnLaTierraMedia/admin/atracciones/index.do");
	}


}