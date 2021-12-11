package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAXB;
import model.PromocionAbsoluta;
import model.PromocionPorcentual;
import model.TipoDeAtraccion;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {
	
	AtraccionDAO atraccionDAO;
	
	public PromocionDAOImpl() {
		this.atraccionDAO = DAOFactory.getAtraccionDAO();
	}

	@Override
	public List<Promocion> findAll() {
		try {
			String sql = "SELECT Promociones.*, PromocionAbsoluta.costoTotal, PromocionPorcentual.porcentaje\n"
				+ "FROM Promociones\n"
				+ "LEFT JOIN PromocionAbsoluta ON (PromocionAbsoluta.idPromocion = Promociones.idPromocion)\n"
				+ "LEFT JOIN PromocionPorcentual ON (PromocionPorcentual.idPromocion = Promociones.idPromocion)";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
	
			List<Promocion> promociones = new ArrayList<Promocion>();
	
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}
	
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Promocion findById(int id) {
		try {
			String sql = "SELECT Promociones.*, PromocionAbsoluta.costoTotal, PromocionPorcentual.porcentaje\n"
				+ "FROM Promociones\n"
				+ "LEFT JOIN PromocionAbsoluta ON (PromocionAbsoluta.idPromocion = Promociones.idPromocion)\n"
				+ "LEFT JOIN PromocionPorcentual ON (PromocionPorcentual.idPromocion = Promociones.idPromocion)"
				+ "WHERE Promociones.idPromocion = ?";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();

			Promocion promocion = null;

			while (resultado.next()) {
				promocion = toPromocion(resultado);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT count(*)\n"
				+ "FROM Promociones\n";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			resultado.next();
			int cantidadDePromociones = resultado.getInt(1);

			return cantidadDePromociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Promocion> findAll(List<Atraccion> todasLasAtracciones) {
		try {
		String sql = "SELECT Promociones.*, PromocionAbsoluta.costoTotal, PromocionPorcentual.porcentaje\n"
				+ "FROM Promociones\n"
				+ "LEFT JOIN PromocionAbsoluta ON (PromocionAbsoluta.idPromocion = Promociones.idPromocion)\n"
				+ "LEFT JOIN PromocionPorcentual ON (PromocionPorcentual.idPromocion = Promociones.idPromocion)";

		Connection conexion = ConnectionProvider.getConnection();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Promocion> promociones = new ArrayList<Promocion>();

		while (resultados.next()) {
			promociones.add(toPromocion(resultados));
		}
		
		for (Promocion promocion: promociones) {
			findAtracciones(promocion, todasLasAtracciones);
		}

		return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Promocion findByNombre(String nombre) {
		try {
			String sql = "SELECT Promociones.*, PromocionAbsoluta.costoTotal, PromocionPorcentual.porcentaje\n"
				+ "FROM Promociones\n"
				+ "LEFT JOIN PromocionAbsoluta ON (PromocionAbsoluta.idPromocion = Promociones.idPromocion)\n"
				+ "LEFT JOIN PromocionPorcentual ON (PromocionPorcentual.idPromocion = Promociones.idPromocion)"
				+ "WHERE Promociones.nombre = ?";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultado = statement.executeQuery();

			Promocion promocion = null;

			while (resultado.next()) {
				promocion = toPromocion(resultado);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Promocion> findByResultSet(ResultSet resultados) {
		try {
			List<Promocion> promociones = new ArrayList<Promocion>();
			
			while(resultados.next()) {
				promociones.add(findById(resultados.getInt("idPromocion")));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultado) {
		try {
			Promocion promocion = null;
		
			int idPromocion = resultado.getInt("idPromocion");
			String tipoDePromocion = resultado.getString("tipoDePromocion");
			String nombre = resultado.getString("nombre");
			String descripcion = resultado.getString("descripcion");
			String imagen = resultado.getString("imagen");
			int idTipoDeAtraccion = resultado.getInt("idTipoDeAtraccion");
			boolean eliminado = resultado.getBoolean("eliminado");
			
			List<Atraccion> atracciones = findAtracciones(idPromocion, false);

			if (tipoDePromocion.equals("PromocionAbsoluta")) {
				int costoTotal = resultado.getInt("costoTotal");

				promocion = new PromocionAbsoluta(
					idPromocion,
					nombre,
					descripcion,
					imagen,
					atracciones,
					TipoDeAtraccion.values()[idTipoDeAtraccion-1],
					costoTotal	
				);
			} else if (tipoDePromocion.equals("PromocionAXB")) {
				List<Atraccion> atraccionesPagas = findAtracciones(idPromocion, true);

				promocion = new PromocionAXB(
					idPromocion,
					descripcion,
					nombre,
					imagen,
					atracciones,
					TipoDeAtraccion.values()[idTipoDeAtraccion-1],
					atraccionesPagas
				);
			} else if (tipoDePromocion.equals("PromocionPorcentual")) {
				double porcentaje = resultado.getDouble("porcentaje");
				
				promocion = new PromocionPorcentual(
					idPromocion,
					nombre,
					descripcion,
					imagen,
					atracciones,
					TipoDeAtraccion.values()[idTipoDeAtraccion-1],
					porcentaje
				);
			}
			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private List<Atraccion> findAtracciones(int idPromocion, boolean promocionNoGeneral) {
		try {
			String sql;
			if (!promocionNoGeneral) {
				sql = "SELECT *\n"
					+ "FROM AtraccionesDePromociones\n"
					+ "WHERE idPromocion = ? AND NOT promocionNoGeneral;";
			} else {
				sql = "SELECT *\n"
					+ "FROM AtraccionesDePromociones\n"
					+ "WHERE idPromocion = ? AND promocionNoGeneral;";
			}
			
			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, idPromocion);
			ResultSet resultados = statement.executeQuery();
			return atraccionDAO.findByResultSet(resultados);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private void findAtracciones(Promocion promocion, List<Atraccion> todasLasAtracciones) {
		try {
			String sql = "SELECT *\n"
				+ "FROM AtraccionesDePromociones\n"
				+ "WHERE idPromocion = ? AND NOT promocionNoGeneral;";

			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, promocion.getIdPromocion());
			ResultSet resultados = statement.executeQuery();
			
			List<Integer> idsAtracciones = new ArrayList<Integer>();
			
			while (resultados.next()) {
				Integer idAtraccion = resultados.getInt("idAtraccion");
				idsAtracciones.add(idAtraccion);
			}
			
			for (Atraccion atraccion: todasLasAtracciones) {
				Integer idAtraccion = atraccion.getIdAtraccion();
				if (idsAtracciones.contains(idAtraccion)) {
					promocion.getAtracciones().add(atraccion);
				}
			}

			if (promocion.getClass().getSimpleName().equals("PromocionAXB")) {
				sql = "SELECT *\n"
					+ "FROM AtraccionesDePromociones\n"
					+ "WHERE idPromocion = ? AND promocionNoGeneral;";

				PromocionAXB promocionAXB = (PromocionAXB) promocion;

				statement = conexion.prepareStatement(sql);
				statement.setInt(1, promocionAXB.getIdPromocion());
				resultados = statement.executeQuery();

				idsAtracciones = new ArrayList<Integer>();

				while (resultados.next()) {
					Integer idAtraccion = resultados.getInt("idAtraccion");
					idsAtracciones.add(idAtraccion);
				}

				for (Atraccion atraccion: todasLasAtracciones) {
					Integer idAtraccion = atraccion.getIdAtraccion();
					if (idsAtracciones.contains(idAtraccion)) {
						promocionAXB.getAtraccionesPagas().add(atraccion);
					}
				}
			}
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
