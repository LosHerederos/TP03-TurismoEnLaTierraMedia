package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.Atraccion;
import model.Promocion;
import persistence.PromocionDAO;
import model.PromocionAXB;
import model.PromocionAbsoluta;
import model.PromocionPorcentual;
import model.TipoDeAtraccion;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public List<Promocion> findAll() {
		try {
		String sql = "SELECT *\n"
				+ "FROM Promociones\n"
				+ "LEFT JOIN PromocionAbsoluta ON (PromocionAbsoluta.idPromocion = Promociones.idPromocion)\n"
				+ "LEFT JOIN PromocionAXB ON (PromocionAXB.idPromocion = Promociones.idPromocion)\n"
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
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
	public List<Promocion> findAll(List<Atraccion> todasLasAtracciones) throws SQLException {
		try {
		String sql = "SELECT\n"
				+ "	Promociones.*,\n"
				+ "	PromocionAbsoluta.idPromocionAbsoluta,\n"
				+ "	PromocionAbsoluta.descuento,\n"
				+ "	PromocionAXB.idPromocionAXB,\n"
				+ "	PromocionPorcentual.idPromocionPorcentual,\n"
				+ "	PromocionPorcentual.porcentuajeDeDescuento\n"
				+ "FROM Promociones\n"
				+ "LEFT JOIN PromocionAbsoluta ON (PromocionAbsoluta.idPromocion = Promociones.idPromocion)\n"
				+ "LEFT JOIN PromocionAXB ON (PromocionAXB.idPromocion = Promociones.idPromocion)\n"
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
		// TODO Auto-generated method stub
		return null;
	}
	
	private Promocion toPromocion(ResultSet resultado) throws SQLException {
		try {
		Promocion promocion = null;
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		
		int idPromocion = resultado.getInt("idPromocion");
		String nombre = resultado.getString("nombre");
		String tipoDePromocion = resultado.getString("tipoDePromocion");
		String imagen = resultado.getString("imagen");
		int costoTotal = resultado.getInt("costoTotal");
		
		
		
		if (tipoDePromocion.equals("PromocionAbsoluta")) {
			int idPromocionAbsoluta = resultado.getInt("idPromocionAbsoluta");
			int descuento = resultado.getInt("descuento");
			
			promocion = new PromocionAbsoluta(
				idPromocion,
				nombre,
				descripcion,
				imagen,
				atracciones,
				tipoDeAtraccion,
				costoTotal	
			);
		} else if (tipoDePromocion.equals("PromocionAXB")) {
			int idPromocionAXB = resultado.getInt("idPromocionAXB");
			List<Atraccion> atraccionesPagas = new ArrayList<Atraccion>();
//			atraccionesPagas
			
			promocion = new PromocionAXB(
				idPromocion,
				idPromocionAXB,
				nombre,
				atracciones,
				atraccionesPagas
			);
		} else if (tipoDePromocion.equals("PromocionPorcentual")) {
			int idPromocionPorcentual = resultado.getInt("idPromocionPorcentual");
			double porcentaje = resultado.getDouble("porcentuajeDeDescuento");
			
			promocion = new PromocionPorcentual(
				idPromocion,
				idPromocionPorcentual,
				nombre,
				atracciones,
				porcentaje
			);
		}
		
		return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private void findAtracciones(Promocion promocion, List<Atraccion> todasLasAtracciones) throws SQLException {
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
		
		if (!promocion.getAtracciones().isEmpty()) {
			promocion.setTipoDeAtraccion();
		}
		
		if (promocion.getClass().getSimpleName().equals("PromocionAXB")) {
			sql = "SELECT *\n"
				+ "FROM AtraccionesDePromociones\n"
				+ "WHERE idPromocion = ? AND promocionNoGeneral;";
			
			PromocionAXB promocionAXB = (PromocionAXB) promocion;
			
			statement = conexion.prepareStatement(sql);
			statement.setInt(1, promocionAXB.getIdPromocionAXB());
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
