package services;

import java.util.List;

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
	
	public Usuario modificar() {
		return null;
	}
}
