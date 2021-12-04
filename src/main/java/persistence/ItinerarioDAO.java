package persistence;

import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	void findAtracciones(Itinerario itinerario, List<Atraccion> todasLasAtracciones);
	void findPromociones(Itinerario itinerario, List<Promocion> todasLasPromociones);
}
