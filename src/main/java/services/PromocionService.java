package services;

import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAXB;
import model.PromocionAbsoluta;
import model.PromocionPorcentual;
import model.TipoDeAtraccion;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {

	PromocionDAO promocionDAO;

	public PromocionService() {
		this.promocionDAO = DAOFactory.getPromocionDAO();
	}

	public Promocion buscar(int idPromocion) {
		return promocionDAO.findById(idPromocion);
	}

	public List<Promocion> listar() {
		return promocionDAO.findAll();
	}

	public void crear(int idPromocion,
		String nombre,
		String descripcion,
		String imagen,
		TipoDeAtraccion tipoDeAtraccion, 
		List<Atraccion> atracciones,
		String tipoDePromocion,
		Object datoExtra
	) {
	}

	public Promocion modificar(
		int idPromocion,
		String nombre,
		String descripcion,
		String imagen,
		TipoDeAtraccion tipoDeAtraccion, 
		List<Atraccion> atracciones,
		String tipoDePromocion,
		Object datoExtra
	) {
		Promocion promocionAModificar = null;
		if (tipoDePromocion.equals("absoluta")) {
			int costoTotal = (int) datoExtra;
			promocionAModificar = new PromocionAbsoluta(idPromocion, nombre, descripcion, imagen, atracciones, tipoDeAtraccion, costoTotal);
		} else if (tipoDePromocion.equals("axb")) {
			List<Atraccion> atraccionesPagas = (List<Atraccion>) (List) datoExtra;
			promocionAModificar = new PromocionAXB(idPromocion, nombre, descripcion, imagen, atracciones, tipoDeAtraccion, atraccionesPagas);
		} else if (tipoDePromocion.equals("porcentual")) {
			double porcentaje = (double) datoExtra;
			promocionAModificar = new PromocionPorcentual(idPromocion, nombre, descripcion, imagen, atracciones, tipoDeAtraccion, porcentaje);
		}
		System.out.println(promocionAModificar);
		if (promocionAModificar.esValido()) {
			System.out.println("Persistiendo");
			this.promocionDAO.update(promocionAModificar);
		}
		return promocionAModificar;
	}
}
