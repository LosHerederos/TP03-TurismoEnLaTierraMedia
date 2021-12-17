package services;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;
public class ComprarAtraccionService {
	AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();

	UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();

	public Map<String, String> comprar(int idUsuario, int idAtraccion) {
		Map<String, String> noCompra = new HashMap<String, String>();
		Usuario usuario = usuarioDao.findById(idUsuario);
		Atraccion atraccion = atraccionDao.findById(idAtraccion);
		int dinero = atraccion.getCosto();
		double tiempo = atraccion.getTiempoParaRealizarla();
		
		if (atraccion.tieneCupoCompleto()) {
			noCompra.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.poseeRecursosSuficientes(dinero, tiempo)) {
			noCompra.put("usuario", "No hay dinero y/o tiempo suficiente");
		}

		if (noCompra.isEmpty()) {

			usuarioDao.updatePresupuestoYTiempoDisponible(usuario);
			atraccionDao.updateVisitantes(atraccion);
		}

		return noCompra;
	}
}
