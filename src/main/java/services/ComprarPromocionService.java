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

	public Map<String, String> comprar(int idUsuario, int idPromocion) {
		Map<String, String> noCompra = new HashMap<String, String>();
		Usuario usuario = usuarioDao.findById(idUsuario);
		Promocion promocion = promocionDao.findById(idPromocion);

		if (usuario.estaEnElItinerario(promocion)) {
			noCompra.put("itinerario", "Esta la promocion en el itinerario");
		}
		if (promocion.tieneCupoCompleto()) {
			noCompra.put("promocion", "No hay cupo disponible");
		}
		if (!usuario.poseeRecursosSuficientes(promocion.getCosto(), promocion.getTiempo())) {
			noCompra.put("usuario", "No hay dinero y/o tiempo suficiente");
		}

		if (noCompra.isEmpty()) {
			usuario.aceptarSugerencia(promocion);
			usuarioDao.updatePresupuestoYTiempoDisponible(usuario);
			promocionDao.updateVisitantes(promocion);
		}

		return noCompra;
	}
}
