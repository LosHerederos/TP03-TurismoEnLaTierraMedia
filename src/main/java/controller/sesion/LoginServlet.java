package controller.sesion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1225267145716606643L;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");

		Usuario usuario = loginService.login(nombre.toUpperCase());

		if (!usuario.esNulo()) {
			req.getSession().setAttribute("usuario", usuario);
			if (usuario.esAdmin())
				resp.sendRedirect("admin/index.jsp");
			else
				resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("flash", "Nombre de usuario es incorrecto");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
