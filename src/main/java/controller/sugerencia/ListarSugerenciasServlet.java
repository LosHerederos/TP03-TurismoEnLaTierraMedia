package controller.sugerencia;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sugeribles;
import model.Usuario;
import services.SugerenciaService;

@WebServlet("/sugerencias.do")
public class ListarSugerenciasServlet extends HttpServlet {

	private static final long serialVersionUID = 1129489135126147394L;
	private SugerenciaService sugerenciaService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.sugerenciaService = new SugerenciaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Sugeribles> sugerencias = sugerenciaService.generarSugerencias((Usuario) req.getSession().getAttribute("usuario"), new int[1]);
		req.setAttribute("sugerencias", sugerencias);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/publico/sugerencias.jsp");
		dispatcher.forward(req, resp);
	}
}
