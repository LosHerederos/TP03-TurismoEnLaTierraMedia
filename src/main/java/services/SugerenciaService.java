package services;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Sugeribles;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;
import utils.OrdenadorPorPrecioYTiempo;

public class SugerenciaService {

	private AtraccionDAO atraccionDAO;
	private PromocionDAO promocionDAO;

	public SugerenciaService() {
		this.atraccionDAO = DAOFactory.getAtraccionDAO();
		this.promocionDAO = DAOFactory.getPromocionDAO();
	}
	
	public List<Sugeribles> generarSugerencias(Usuario usuario, int[] sugeriblesIdsQuitados) {
		List<Atraccion> atracciones = atraccionDAO.findAll();
		List<Promocion> promociones = promocionDAO.findAll();
		Collections.sort(promociones, new OrdenadorPorPrecioYTiempo());
		Collections.sort(atracciones, new OrdenadorPorPrecioYTiempo());
		LinkedList<Sugeribles> sugerencias = new LinkedList<Sugeribles>();
		sugerencias.addAll(promociones);
		sugerencias.addAll(atracciones);
		return sugerencias;
	}
}
