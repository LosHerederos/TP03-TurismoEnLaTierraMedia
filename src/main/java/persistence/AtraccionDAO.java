package persistence;

import java.sql.ResultSet;
import java.util.List;

import model.Atraccion;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	Atraccion findByNombre(String nombre);
	List<Atraccion> findByResultSet(ResultSet resultados);
	int updateVisitantes(Atraccion atraccion);
}
