package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Atraccion;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class AtraccionDAOTest {
	
	AtraccionDAO atraccionDAO;

	@Before
	public void setUp() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.setAutoCommit(false);
		atraccionDAO = DAOFactory.getAtraccionDAO();
	}

	@After
	public void tearDown() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.rollback();
		conexion.setAutoCommit(true);
	}

	@Test
	public void findAllTest() {
		List<Atraccion> atracciones = atraccionDAO.findAll();

		for (Atraccion atraccion : atracciones) {
			System.out.println(atraccion);
		}
	}
	
	@Test
	public void findByIdTest() {
		Atraccion atraccion = atraccionDAO.findById(4);

		System.out.println(atraccion);
	}
	
	@Test
	public void countAllTest() {
		int cantidadDeAtracciones = atraccionDAO.countAll();

		System.out.println(cantidadDeAtracciones);
	}
	
	@Test
	public void insertTest() {
		
	}
	
	@Test
	public void updateTest() {
		
	}
	
	@Test
	public void deleteTest() {
		
	}

	@Test
	public void findByNombreTest() {
		Atraccion atraccion = atraccionDAO.findByNombre("Erebor");

		System.out.println(atraccion);
	}
}
