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

@WebFilter(urlPatterns = "*.do")
public class LoggedFilter extends HttpFilter {

	private static final long serialVersionUID = 731075098418349171L;

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		if (usuario != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("flash", "Por favor, ingresa al sistema");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
