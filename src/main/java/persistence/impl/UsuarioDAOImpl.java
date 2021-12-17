package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import model.TipoDeAtraccion;
import model.Usuario;
import model.nullobjects.UsuarioNulo;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	private ItinerarioDAO itinerarioDAO;

	public UsuarioDAOImpl () {
		itinerarioDAO = DAOFactory.getItinerarioDAO();
	}

	public List<Usuario> findAll() {
		try {
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
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario findById(int id) {
		try {
			String sql = "SELECT Usuarios.*, Itinerarios.idItinerario\n"
				+ "FROM Usuarios\n"
				+ "JOIN Itinerarios\n"
				+ "ON  Usuarios.idUsuario = Itinerarios.idUsuario\n"
				+ "WHERE Usuarios.idUsuario = ?";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();

			Usuario usuario = UsuarioNulo.build();

			if (resultado.next() ) {
				usuario = toUsuario(resultado); 
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT count(*)\n"
				+ "FROM Usuarios\n";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			resultado.next();
			int cantidadDeUsuarios = resultado.getInt(1);

			return cantidadDeUsuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insert(Usuario usuario) {
		try {
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
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE Usuarios\n"
				+ "SET presupuesto = ?,\n"
				+ "tiempoDisponible = ?,\n"
				+ "idTipoDeAtraccion = ?,\n"
				+ "esAdmin = ?\n"
				+ "WHERE idUsuario = ?;";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, usuario.getPresupuesto());
			statement.setDouble(2, usuario.getTiempoDisponible());
			statement.setInt(3, usuario.getTipoFavorito().ordinal()+1);
			statement.setInt(4, usuario.esAdmin()? 1 : 0);
			statement.setInt(5, usuario.getIdUsuario());

			int filas = statement.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Usuario usuario) {
		try {
		String sql = "DELETE FROM USERS WHERE USERNAME = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		int rows = statement.executeUpdate();

		return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public List<Usuario> findAll(List<Atraccion> todasLasAtracciones, List<Promocion> todasLasPromociones)  {
		try {
		List<Usuario> usuarios = this.findAll();

		for (Usuario usuario: usuarios) {
			this.itinerarioDAO.findAtracciones(usuario.getItinerario(), todasLasAtracciones);
			this.itinerarioDAO.findPromociones(usuario.getItinerario(), todasLasPromociones);
		}
		
		return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	@Override
	public Usuario findByNombre(String nombre) {
		try {
		String sql = "SELECT *\n"
				+ "FROM Usuarios\n"
				+ "JOIN Itinerarios\n"
				+ "ON Usuarios.idUsuario = Itinerarios.idUsuario\n"
				+ "WHERE upper(Usuarios.nombre) = ?";

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
	
	public int updatePresupuestoYTiempoDisponible(Usuario usuario) {
		try {
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
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultado) {		
		try {
			Itinerario itinerario = itinerarioDAO.findById(resultado.getInt("idItinerario"));
			return new Usuario(
				resultado.getInt("idUsuario"),
				resultado.getBoolean("esAdmin"),
				resultado.getString("nombre"),
				resultado.getInt("presupuesto"), 
				resultado.getDouble("tiempoDisponible"),
				TipoDeAtraccion.values()[resultado.getInt("idTipoDeAtraccion")-1],
				itinerario
			);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
