package model.nullobjects;

import model.Usuario;

public class UsuarioNulo extends Usuario {

	public static Usuario build() {
		return new UsuarioNulo();
	}
	
	public UsuarioNulo() {
		super(0, false, "", 0, 0.0, null, null);
	}
	
	public boolean esNulo() {
		return true;
	}
}
