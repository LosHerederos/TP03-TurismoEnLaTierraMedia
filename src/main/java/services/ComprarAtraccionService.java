package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import model.Itinerario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.ItinerarioDAO;
import persistence.commons.DAOFactory;
public class ComprarAtraccionService {
	AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDao = DAOFactory.getItinerarioDAO();
	public Map<String, String> comprar(int idUsuario, int idAtraccion, int idItinerario) {
		Map<String, String> noCompra = new HashMap<String, String>();
		List<Atraccion> agregar;
		agregar = new ArrayList<Atraccion>();
		Usuario usuario = usuarioDao.findById(idUsuario);
		Atraccion atraccion = atraccionDao.findById(idAtraccion);
		Itinerario itinerario = itinerarioDao.findById(idItinerario);
		int dinero = atraccion.getCosto();
		double tiempo = atraccion.getTiempoParaRealizarla();
		if (itinerario.getAtracciones().contains(atraccion)) {
			noCompra.put("itinerario", "Esta la atraccion en el itinerario");
		}
		if (atraccion.tieneCupoCompleto()) {
			noCompra.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.poseeRecursosSuficientes(dinero, tiempo)) {
			noCompra.put("usuario", "No hay dinero y/o tiempo suficiente");
		}

		if (noCompra.isEmpty()) {
			agregar.add(atraccion);
			usuario.setPresupuesto(usuario.getPresupuesto()-dinero);
			usuario.setTiempoDisponible(usuario.getTiempoDisponible()-tiempo);
			atraccion.agregarVisitante();
			usuario.getItinerario();
			itinerario.setAtracciones(agregar);
			//itinerario.
			itinerarioDao.update(itinerario);
			usuarioDao.updatePresupuestoYTiempoDisponible(usuario);
			atraccionDao.updateVisitantes(atraccion);
		}

		return noCompra;
	}
}
