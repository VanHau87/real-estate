package com.laptrinhweb.repository;

import com.laptrinhweb.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity>{
	void save(NewsEntity entity);
}
