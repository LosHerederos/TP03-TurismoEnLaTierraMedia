package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.commons.DAOFactory;
import persistence.ItinerarioDAO;
import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import model.Usuario;
import model.nullobjects.UsuarioNulo;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private persistence.ItinerarioDAO itinerarioDAO;
	
	UsuarioDAOImpl () {
		itinerarioDAO = persistence.commons.DAOFactory.getItinerarioDAO();
	}

	public List<Usuario> findAll() throws SQLException {
		String sql = "SELECT *\n"
				+ "FROM Usuarios\n"
				+ "JOIN Itinerarios\n"
				+ "ON Usuarios.idUsuario = Itinerarios.idUsuario";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		while(resultados.next()) {
			usuarios.add(toUsuario(resultados));
		}

		return usuarios;
	}

	public Usuario findById(int id) throws SQLException {
		String sql = "SELECT *\n"
				+ "FROM Usuarios\n"
				+ "JOIN Itinerarios\n"
				+ "ON  Usuarios.idUsuario = Itinerarios.idUsuario\n"
				+ "WHERE Usuarios.idUsuario = ?";
		
		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultado = statement.executeQuery();
		
		Usuario usuario = null;
		
		if (resultado.next() ) {    
			usuario = toUsuario(resultado); 
		}

		return usuario;
	}

	public int countAll() throws SQLException {
		String sql = "SELECT count(*)\n"
				+ "FROM Usuarios\n";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		resultado.next();
		int cantidadDeUsuarios = resultado.getInt(1);

		return cantidadDeUsuarios;
	}

	public int insert(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO\n"
				+ "Usuarios (nombre, presupuesto, tiempoDisponible, idTipoDeAtraccion)\n"
				+ "VALUES (?, ?, ?, ?)";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setInt(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempoDisponible());
		statement.setInt(4, usuario.getTipoFavorito().ordinal());
		int filas = statement.executeUpdate();

		return filas;
	}

	public int update(Usuario usuario) throws SQLException {
		String sql = "UPDATE Usuarios\n"
				+ "SET presupuesto = ?,\n"
				+ "tiempoDisponible = ?\n"
				+ "WHERE idUsuario = ?;";
		
		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setInt(3, usuario.getIdUsuario());
		int filas = statement.executeUpdate();
		
		this.itinerarioDAO.update(usuario.getItinerario());

		return filas;
	}

	public int delete(Usuario usuario) throws SQLException {
		String sql = "DELETE FROM USERS WHERE USERNAME = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		int rows = statement.executeUpdate();

		return rows;
	}
	
	public List<Usuario> findAll(List<Atraccion> todasLasAtracciones, List<Promocion> todasLasPromociones) throws SQLException {
		List<Usuario> usuarios = this.findAll();

		for (Usuario usuario: usuarios) {
			this.itinerarioDAO.findAtracciones(usuario.getItinerario(), todasLasAtracciones);
			this.itinerarioDAO.findPromociones(usuario.getItinerario(), todasLasPromociones);
		}
		
		return usuarios;
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
