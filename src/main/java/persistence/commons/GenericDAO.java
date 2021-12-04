package persistence.commons;

import java.util.List;

public interface GenericDAO<T> {

	List<T> findAll();
	T findById(int id);
	int countAll();
	int insert(T t);
	int update(T t);
	int delete(T t);
}
