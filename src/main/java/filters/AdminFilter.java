package filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebFilter(urlPatterns="/admin/*")
public class AdminFilter extends HttpFilter {

	private static final long serialVersionUID = 4961681585093133998L;

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		if (usuario != null && usuario.esAdmin()) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
			//dispatcher.forward(request, response);
		}
	}
}
