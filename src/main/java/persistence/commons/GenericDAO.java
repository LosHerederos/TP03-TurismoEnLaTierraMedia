package persistence.commons;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {

	List<T> findAll() throws SQLException;
	T findById(int id) throws SQLException;
	int countAll() throws SQLException;
	int insert(T t) throws SQLException;
	int update(T t) throws SQLException;
	int delete(T t) throws SQLException;
}
