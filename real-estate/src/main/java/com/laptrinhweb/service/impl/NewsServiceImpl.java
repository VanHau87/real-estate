package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.converter.NewsConverter;
import com.laptrinhweb.dto.NewsDTO;
import com.laptrinhweb.entity.NewsEntity;
import com.laptrinhweb.repository.NewsRepository;
import com.laptrinhweb.repository.impl.NewsRepositoryImpl;
import com.laptrinhweb.service.NewsService;

public class NewsServiceImpl implements NewsService{
	private NewsRepository newsRepository = new NewsRepositoryImpl();
	private NewsConverter newsConverter = new NewsConverter();
	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		List<NewsEntity> entities = newsRepository.findAll();
		for (NewsEntity entity : entities) {
			NewsDTO dto = newsConverter.entity2DTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public void save(NewsDTO dto) {
		NewsEntity entity = newsConverter.dto2Entity(dto);
		newsRepository.save(entity);
		
	}

}
