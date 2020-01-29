package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.NewsDTO;

public interface NewsService {
	List<NewsDTO> findAll();
	void save(NewsDTO dto);
}
