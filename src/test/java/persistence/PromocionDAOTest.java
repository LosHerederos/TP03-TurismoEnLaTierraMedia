package persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Promocion;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class PromocionDAOTest {

	PromocionDAO promocionDAO;

	@Before
	public void setUp() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.setAutoCommit(false);
		promocionDAO = DAOFactory.getPromocionDAO();
	}

	@After
	public void tearDown() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.rollback();
		conexion.setAutoCommit(true);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void findAllTest() {
		List<Promocion> promociones = promocionDAO.findAll();

		for (Promocion promocion : promociones) {
			System.out.println(promocion);
		}
	}

	@Test
	public void findByIdTest() {
		Promocion promocion = promocionDAO.findById(1);

		System.out.println(promocion);
	}

	@Test
	public void countAllTest() {
		int cantidadDePromociones = promocionDAO.countAll();

		System.out.println(cantidadDePromociones);
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
		Promocion promocion = promocionDAO.findByNombre("Pack degustación");

		System.out.println(promocion);
	}
}
