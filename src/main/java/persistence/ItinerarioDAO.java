package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	void findAtracciones(Itinerario itinerario, List<Atraccion> todasLasAtracciones) throws SQLException;
	void findPromociones(Itinerario itinerario, List<Promocion> todasLasPromociones) throws SQLException;
	boolean existePromocionDeItinerario(int idItinerario, int idPromocion) throws SQLException;
	boolean existeAtraccionDeItinerario(int idItinerario, int idAtraccion) throws SQLException;
}
