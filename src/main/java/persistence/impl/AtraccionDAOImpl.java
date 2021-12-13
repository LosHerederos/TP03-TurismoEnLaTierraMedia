package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AtraccionDAOImpl implements AtraccionDAO {

	public List<Atraccion> findAll()  {
		try {
			String sql = "SELECT * FROM Atracciones";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> atracciones = new ArrayList<Atraccion>();

			while(resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Atraccion findById(int id) {
		try {
			String sql = "SELECT *\n"
				+ "FROM Atracciones\n"
				+ "WHERE idAtraccion = ?";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();

			Atraccion atraccion = null;

			if (resultado.next() ) {    
				atraccion = toAtraccion(resultado); 
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT count(*)\n"
				+ "FROM Atracciones\n";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			resultado.next();
			int cantidadDeAtracciones = resultado.getInt(1);

			return cantidadDeAtracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO\n"
				+ "Atracciones (nombre, costoVisita, tiempoParaRealizarla, cupoPersonas, visitantes, idTipoDeAtraccion)\n"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getTiempo());
			statement.setInt(4, atraccion.getCupoPersonas());
			statement.setInt(5, atraccion.getVisitantes());
			statement.setInt(6, atraccion.getTipoDeAtraccion().ordinal());
			int filas = statement.executeUpdate();
		
			return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE Atracciones\n"
				+ "SET nombre = ?\n"
				+ "descripcion = ?\n"
				+ "costoVisita = ?\n"
				+ "tiempoParaRealizarla = ?\n"
				+ "cupoPersonas = ?\n"
				+ "visitantes = ?\n"
				+ "idTipoDeAtraccion = ?\n"
				+ "WHERE idAtraccion = ?;";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setString(2, atraccion.getDescripcion());
			statement.setInt(3, atraccion.getCosto());
			statement.setDouble(4, atraccion.getTiempo());
			statement.setInt(5, atraccion.getCupoPersonas());
			statement.setInt(6, atraccion.getCupoPersonas());
			statement.setInt(7, atraccion.getTipoDeAtraccion().ordinal());
			statement.setInt(8, atraccion.getIdAtraccion());
			int filas = statement.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int delete(Atraccion atraccion) {
		try {
			String sql = "DELETE FROM USERS WHERE USERNAME = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public Atraccion findByNombre(String nombre) {
		try {
			String sql = "SELECT *\n"
				+ "FROM Atracciones\n"
				+ "WHERE nombre = ?";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultado = statement.executeQuery();

			Atraccion atraccion = null;

			if (resultado.next()) {
				atraccion = toAtraccion(resultado);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int updateVisitantes(Atraccion atraccion) {
		try {
			String sql = "UPDATE Atracciones\n"
				+ "SET visitantes = ?\n"
				+ "WHERE idAtraccion = ?;";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, atraccion.getVisitantes());
			statement.setInt(2, atraccion.getIdAtraccion());
			int filas = statement.executeUpdate();

			return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Atraccion> findByResultSet(ResultSet resultados) {
		try {
			List<Atraccion> atracciones = new ArrayList<Atraccion>();
			
			while(resultados.next()) {
				atracciones.add(findById(resultados.getInt("idAtraccion")));
			}
			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultado) {
		try {
			return new Atraccion(
				resultado.getInt("idAtraccion"),
				resultado.getString("nombre"),
				resultado.getString("descripcion"),
				resultado.getString("imagen"),
				resultado.getInt("costoVisita"),
				resultado.getDouble("tiempoParaRealizarla"),
				resultado.getInt("cupoPersonas"),
				resultado.getInt("visitantes"),
				TipoDeAtraccion.values()[resultado.getInt("idTipoDeAtraccion")-1]
			);
		}  catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
