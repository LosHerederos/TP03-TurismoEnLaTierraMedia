package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {

	List<Promocion> findAll(List<Atraccion> todasLasAtracciones) throws SQLException;
	Promocion findByNombre(String nombre);
}
