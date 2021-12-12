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

@WebServlet("/admin/atracciones/editar.do")
public class EditarAtraccionesServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int idAtraccion = Integer.parseInt(id);

		Atraccion atraccion = this.atraccionService.buscar(idAtraccion);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/admin/atracciones/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idAtraccion = Integer.parseInt(req.getParameter("idAtraccion"));
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		String imagen = req.getParameter("imagen");
		int costo = Integer.parseInt(req.getParameter("costo"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		int cupo = Integer.parseInt(req.getParameter("cupo"));
		int visitantes = Integer.parseInt(req.getParameter("visitantes"));
		//TipoDeAtraccion tipo = req.getParameter(tipo.AVENTURA.ordinal());
		Atraccion atraccion = atraccionService.editar(idAtraccion,nombre,descripcion,imagen,costo,tiempo,cupo,visitantes,TipoDeAtraccion.AVENTURA);

		if (atraccion.isValid()) {
			resp.sendRedirect("/admin/atracciones/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/admin/atracciones/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
