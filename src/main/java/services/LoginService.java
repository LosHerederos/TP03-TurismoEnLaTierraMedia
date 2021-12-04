package services;

import model.Usuario;
import model.nullobjects.UsuarioNulo;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String nombre) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDao.findByNombre(nombre);

		if (usuario.esNulo()) {
			usuario = UsuarioNulo.build();
		}
		return usuario;
	}
}
