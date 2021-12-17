package controller.promocion;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import model.PromocionAbsoluta;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class ComprarPromocionServlet {
	PromocionDAO promocionDao = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDao = DAOFactory.getItinerarioDAO();
	public Map<String, String> comprar(int idUsuario, int idAtraccion, int idItinerario) {
		Map<String, String> noCompra = new HashMap<String, String>();
		Usuario usuario = usuarioDao.findById(idUsuario);
		Promocion promocion = promocionDao.findById(idAtraccion);
		Itinerario itinerario = itinerarioDao.findById(idItinerario);
		int dinero = promocion.getCosto();
		double tiempo = promocion.getTiempo();
		if (itinerario.getPromociones().contains(promocion)) {
			noCompra.put("itinerario", "Esta la atraccion en el itinerario");
		}
		if (promocion.tieneCupoCompleto()) {
			noCompra.put("promocion", "No hay cupo disponible");
		}
		if (!usuario.poseeRecursosSuficientes(dinero, tiempo)) {
			noCompra.put("usuario", "No hay dinero y/o tiempo suficiente");
		}

		if (noCompra.isEmpty()) {
			usuario.setPresupuesto(usuario.getPresupuesto()-dinero);
			usuario.setTiempoDisponible(usuario.getTiempoDisponible()-tiempo);
			promocion.agregarVisitante();
			//itinerarioDao.
			usuarioDao.updatePresupuestoYTiempoDisponible(usuario);
			
			promocionDao.update(promocion);
		}

		return noCompra;
	}
}
