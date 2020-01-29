package com.laptrinhweb.repository;

import java.util.List;

public interface JpaRepository<T> {
	List<T> findAll();
	void save(String sql, Object ...objects);
	void insert(Object object);
}
