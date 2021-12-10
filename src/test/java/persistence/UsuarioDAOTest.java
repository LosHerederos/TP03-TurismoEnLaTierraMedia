package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class UsuarioDAOTest {
	
	UsuarioDAO usuarioDAO;

	@Before
	public void setUp() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.setAutoCommit(false);
		usuarioDAO = DAOFactory.getUsuarioDAO();
	}

	@After
	public void tearDown() throws SQLException {
		Connection conexion = ConnectionProvider.getConnection();
		conexion.rollback();
		conexion.setAutoCommit(true);
	}

	@Test
	public void test() {
//		System.out.println(usuarioDAO.findAll());
//		System.out.println(usuarioDAO.findById(2));
		System.out.println(usuarioDAO.findByNombre("Gandalf"));
//		System.out.println(usuarioDAO.countAll());
	}
	
	@Test
	public void findAllTest() {
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}
	
	@Test
	public void findByIdTest() {
		Usuario usuario = usuarioDAO.findById(2);
		
		System.out.println(usuario);
	}
	
	@Test
	public void countAllTest() {
		int cantidadDeUsuarios = usuarioDAO.countAll();
		
		System.out.println(cantidadDeUsuarios);
	}

	@Test
	public void findByNombre() {
		Usuario usuario = usuarioDAO.findByNombre("Admin");
		
		System.out.println(usuario);
	}
	
	@Test
	public void updatePresupuestoYTiempoDisponibleTest() {
		
	}
}
