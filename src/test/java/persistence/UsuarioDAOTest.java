package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class UsuarioDAOTest {

	@Before
	public void setUp() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.setAutoCommit(false);
	}

	@After
	public void tearDown() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.rollback();
		conexion.setAutoCommit(true);
	}

	@Test
	public void test() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		
//		System.out.println(usuarioDAO.findAll());
//		System.out.println(usuarioDAO.findById(2));
		System.out.println(usuarioDAO.findByNombre("Gandalf"));
//		System.out.println(usuarioDAO.countAll());
	}

}
