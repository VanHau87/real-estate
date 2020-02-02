package com.laptrinhweb.repository;

import java.util.List;

public interface JpaRepository<T> {
	List<T> findAll(Object ...where);
	List<T> findAll(String sql, Object ...where);
	void save(String sql, Object ...objects);
	void insert(Object object);
}
