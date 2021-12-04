package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import model.Usuario;
import model.nullobjects.UsuarioNulo;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> findAll(List<Atraccion> todasLasAtracciones, List<Promocion> todasLasPromociones) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByNombre(String nombre) {
		try {
		String sql = "SELECT *\n"
				+ "FROM Usuarios\n"
				+ "JOIN Itinerarios\n"
				+ "ON Usuarios.idUsuario = Itinerarios.idUsuario\n"
				+ "WHERE Usuarios.nombre = ?";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setString(1, nombre);
		ResultSet resultado = statement.executeQuery();

		Usuario usuario = UsuarioNulo.build();

		if (resultado.next()) {
			usuario = toUsuario(resultado);
		}

		return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultado) throws SQLException {

		return new Usuario(
			resultado.getInt("idUsuario"),
			resultado.getBoolean("esAdmin"),
			resultado.getString("nombre"),
			resultado.getInt("presupuesto"), 
			resultado.getDouble("tiempoDisponible"),
			null,
			new Itinerario(resultado.getInt("idItinerario"))
		);
	}
}
