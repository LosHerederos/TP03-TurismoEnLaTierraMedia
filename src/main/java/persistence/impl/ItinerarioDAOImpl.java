package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	private AtraccionDAO atraccionDAO;
	private PromocionDAO promocionDAO;

	public ItinerarioDAOImpl() {
		atraccionDAO = DAOFactory.getAtraccionDAO();
		promocionDAO = DAOFactory.getPromocionDAO();
	}

	@Override
	public List<Itinerario> findAll() {
		try {
			List<Itinerario> itinerarios = new ArrayList<Itinerario>();
			return itinerarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Itinerario findById(int id) {
		try {
			List<Atraccion> atracciones;
			Itinerario itinerario = new Itinerario(id);
			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			int cantidadDeItinerarios = 0;
			return cantidadDeItinerarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Itinerario itinerario) {
		try {
			int filas = 0;
			return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerario itinerario) {
		try {
			int idItinerario = itinerario.getIdItinerario();
			int idAtraccion, idPromocion;
			List<Atraccion> atracciones = itinerario.getAtracciones();
			List<Promocion> promociones = itinerario.getPromociones();

			int filas = 0;

			for (Atraccion atraccion : atracciones) {
				idAtraccion = atraccion.getIdAtraccion();
				if (!existeAtraccionDeItinerario(idItinerario, idAtraccion)) {
					filas += insertAtraccionDeItinerario(idItinerario, idAtraccion);
				}
			}

			for (Promocion promocion : promociones) {
				idPromocion = promocion.getIdPromocion();
				if (!existePromocionDeItinerario(idItinerario, idPromocion)) {
					filas += insertPromocionDeItinerario(idItinerario, idPromocion);
				}
			}

			return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Itinerario itinerario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void findAtracciones(Itinerario itinerario, List<Atraccion> todasLasAtracciones) {
		try {
		String sql = "SELECT *\n"
				+ "FROM AtraccionesDeItinerario\n"
				+ "WHERE idItinerario = ?;";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, itinerario.getIdItinerario());
		ResultSet resultados = statement.executeQuery();

		List<Integer> idsAtracciones = new ArrayList<Integer>();

		while (resultados.next()) {
			Integer idAtraccion = resultados.getInt("idAtraccion");
			idsAtracciones.add(idAtraccion);
		}

		for (Atraccion atraccion: todasLasAtracciones) {
			Integer idAtraccion = atraccion.getIdAtraccion();
			if (idsAtracciones.contains(idAtraccion)) {
				itinerario.getAtracciones().add(atraccion);
			}
		}
	} catch (Exception e) {
		throw new MissingDataException(e);
	}
	}

	@Override
	public void findPromociones(Itinerario itinerario, List<Promocion> todasLasPromociones) {
		try {
		String sql = "SELECT *\n"
				+ "FROM PromocionesDeItinerarios\n"
				+ "WHERE idItinerario = ?;";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, itinerario.getIdItinerario());
		ResultSet resultados = statement.executeQuery();

		List<Integer> idsPromociones = new ArrayList<Integer>();

		while (resultados.next()) {
			Integer idPromocion = resultados.getInt("idPromocion");
			idsPromociones.add(idPromocion);
		}

		for (Promocion promocion: todasLasPromociones) {
			Integer idPromocion = promocion.getIdPromocion();
			if (idsPromociones.contains(idPromocion)) {
				itinerario.getPromociones().add(promocion);
			}
		} 
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public boolean existeAtraccionDeItinerario(int idItinerario, int idAtraccion) {
		try {
		String sql = "SELECT count(*) AS 'cantidad'\n"
				+ "FROM AtraccionesDeItinerario\n"
				+ "WHERE idItinerario = ? AND idAtraccion = ?\n";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, idItinerario);
		statement.setInt(2, idAtraccion);
		ResultSet resultado = statement.executeQuery();

		resultado.next();
		int cantidad = resultado.getInt("cantidad");

		return cantidad > 0;
	} catch (Exception e) {
		throw new MissingDataException(e);
	}
	}

	@Override
	public boolean existePromocionDeItinerario(int idItinerario, int idPromocion) {
		try {
		String sql = "SELECT count(*) AS 'cantidad'\n"
				+ "FROM PromocionesDeItinerarios\n"
				+ "WHERE idItinerario = ? AND idPromocion = ?\n";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, idItinerario);
		statement.setInt(2, idPromocion);
		ResultSet resultado = statement.executeQuery();

		resultado.next();
		int cantidad = resultado.getInt("cantidad");

		return cantidad > 0;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private int insertAtraccionDeItinerario(int idItinerario, int idAtraccion) {
		try {
		String sql = "INSERT INTO AtraccionesDeItinerario"
				+ "(idItinerario, idAtraccion)"
				+ "VALUES (?, ?)";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, idItinerario);
		statement.setInt(2, idAtraccion);
		int filas = statement.executeUpdate();
		
		return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private int insertPromocionDeItinerario(int idItinerario, int idPromocion) {
		try {
		String sql = "INSERT INTO PromocionesDeItinerarios"
				+ "(idItinerario, idPromocion)"
				+ "VALUES (?, ?)";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, idItinerario);
		statement.setInt(2, idPromocion);
		int filas = statement.executeUpdate();
		
		return filas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
