package services;

import java.util.List;

import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion alta(String nombre, String descripcion, String imagen, int costoVisita, double tiempoParaRealizarla, int cupoPersonas, int visitantes, TipoDeAtraccion tipoDeAtraccion) {

		Atraccion atraccion = new Atraccion(0,nombre, descripcion, imagen, costoVisita,tiempoParaRealizarla,cupoPersonas,visitantes,tipoDeAtraccion);

		if (atraccion.isValid()) {
			AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
			atraccionDao.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion modificacion(int idatraccion,String nombre, String descripcion, String imagen, int costoVisita, double tiempoParaRealizarla, int cupoPersonas, int visitantes, TipoDeAtraccion tipoDeAtraccion) {

		AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDao.findById(idatraccion);

		atraccion.setNombre(nombre);
		atraccion.setDescripcion(descripcion);
		atraccion.setImagen(imagen);
		atraccion.setCostoVisita(costoVisita);
		atraccion.setTiempoParaRealizarla(tiempoParaRealizarla);
		atraccion.setCupoPersonas(cupoPersonas);
		atraccion.setVisitantes(visitantes);
		atraccion.setTipoDeAtraccion(tipoDeAtraccion);

		if (atraccion.isValid()) {
			atraccionDao.update(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public void delete(Integer idAtraccion) {
		Atraccion atraccion = new Atraccion(idAtraccion, "", "", "", 0, 0.0, 0, 0, null);

		AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
		atraccionDao.delete(atraccion);
	}

	public Atraccion find(Integer idAtraccion) {
		return DAOFactory.getAtraccionDAO().findById(idAtraccion);
	}

}