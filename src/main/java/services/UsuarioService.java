package services;

import java.util.List;

import model.TipoDeAtraccion;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {

	UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		this.usuarioDAO = DAOFactory.getUsuarioDAO();
	}

	public Usuario buscar(int idUsuario) {
		return usuarioDAO.findById(idUsuario);
	}

	public List<Usuario> listar() {
		return usuarioDAO.findAll();
	}

	public Usuario modificar(int idUsuario, boolean esAdmin, String nombre, int presupuesto, double tiempoDisponible, TipoDeAtraccion tipoFavorito) {
		Usuario usuarioAModificar = new Usuario(idUsuario, esAdmin, nombre, presupuesto, tiempoDisponible, tipoFavorito, null);

		if (usuarioAModificar.esValido()) {
			usuarioDAO.update(usuarioAModificar);
		}

		return usuarioAModificar;
	}
}
