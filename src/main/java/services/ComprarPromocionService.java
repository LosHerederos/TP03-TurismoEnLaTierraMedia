package services;

import java.util.HashMap;
import java.util.Map;
import model.Itinerario;
import model.Promocion;
import model.Usuario;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class ComprarPromocionService {
	PromocionDAO promocionDao = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDao = DAOFactory.getItinerarioDAO();
	public Map<String, String> comprar(int idUsuario, int idPromocion, int idItinerario) {
		Map<String, String> noCompra = new HashMap<String, String>();
		Usuario usuario = usuarioDao.findById(idUsuario);
		Promocion promocion = promocionDao.findById(idPromocion);
		Itinerario itinerario = itinerarioDao.findById(idItinerario);
		int dinero = promocion.getCosto();
		double tiempo = promocion.getTiempo();
		if (itinerario.getPromociones().contains(promocion)) {
			noCompra.put("itinerario", "Esta la promocion en el itinerario");
		}
		if (promocion.tieneCupoCompleto()) {
			noCompra.put("atraccion", "No hay cupo disponible");
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
