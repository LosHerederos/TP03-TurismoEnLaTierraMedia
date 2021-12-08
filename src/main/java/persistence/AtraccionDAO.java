package persistence;

import java.sql.SQLException;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	Atraccion findByNombre(String nombre) throws SQLException;
}
