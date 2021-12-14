package services;

import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {
	AtraccionDAO atraccionDao;
	public AtraccionService() {
		this.atraccionDao = DAOFactory.getAtraccionDAO();
	}
	public Atraccion crear(String nombre, String descripcion, String imagen, int costoVisita,
			double tiempoParaRealizarla, int cupoPersonas, int visitantes, TipoDeAtraccion tipoDeAtraccion) {

		Atraccion atraccion = new Atraccion(0, nombre, descripcion, imagen, costoVisita, tiempoParaRealizarla,
				cupoPersonas, visitantes, tipoDeAtraccion);

		if (atraccion.isValid()) {
			atraccionDao = DAOFactory.getAtraccionDAO();
			atraccionDao.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion editar(int idAtraccion, String nombre, String descripcion, String imagen, int costoVisita,
			double tiempoParaRealizarla, int cupoPersonas, int visitantes, TipoDeAtraccion tipoDeAtraccion) {
		
		Atraccion atraccion = new Atraccion(idAtraccion,nombre,descripcion,imagen,costoVisita,tiempoParaRealizarla,cupoPersonas,visitantes,tipoDeAtraccion);
		if (atraccion.isValid()) {
			atraccionDao.update(atraccion);
		}
		//AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
//		Atraccion atraccion = atraccionDao.findById(idAtraccion);
//
//		atraccion.setNombre(nombre);
//		atraccion.setDescripcion(descripcion);
//		atraccion.setImagen(imagen);
//		atraccion.setCostoVisita(costoVisita);
//		atraccion.setTiempoParaRealizarla(tiempoParaRealizarla);
//		atraccion.setCupoPersonas(cupoPersonas);
//		atraccion.setVisitantes(visitantes);
//		atraccion.setTipoDeAtraccion(tipoDeAtraccion);
//		//if (atraccion.isValid()) {
//			atraccionDao.update(atraccion);
//			// XXX: si no devuelve "1", es que hubo más errores
//		//}

		return atraccion;
	}

	public void borrar(Integer idAtraccion) {
		Atraccion atraccion = new Atraccion(idAtraccion, "", "", "", 0, 0.0, 0, 0, null);
		AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
		atraccionDao.delete(atraccion);
	}

	public Atraccion buscar(Integer idAtraccion) {
		return DAOFactory.getAtraccionDAO().findById(idAtraccion);
	}

	public List<Atraccion> buscar(String[] idsAtracciones) {
		List<Atraccion> atracciones = new ArrayList<Atraccion>(); 
		for (String idAtraccion : idsAtracciones) {
			atracciones.add(this.atraccionDao.findById(Integer.parseInt(idAtraccion)));
		}
		return atracciones;
	}
	
	public List<Atraccion> listar() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

}