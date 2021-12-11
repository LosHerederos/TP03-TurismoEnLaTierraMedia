package services;

import java.util.List;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {
	public List<Atraccion> getAtracciones() {
		AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
		List<Atraccion> atraccion = atraccionDao.findAll();
		return atraccion;
	}
}
