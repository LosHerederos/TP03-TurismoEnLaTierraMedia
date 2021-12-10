package persistence;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	List<Usuario> findAll(List<Atraccion> todasLasAtracciones, List<Promocion> todasLasPromociones);
	Usuario findByNombre(String nombre);
}
