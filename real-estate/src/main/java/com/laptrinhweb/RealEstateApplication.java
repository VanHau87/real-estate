package com.laptrinhweb;

import java.util.List;

import com.laptrinhweb.dto.NewsDTO;
import com.laptrinhweb.service.NewsService;
import com.laptrinhweb.service.impl.NewsServiceImpl;

public class RealEstateApplication {
	
	public static void main(String[] args) {
		/*
		TestException testException = new TestException();
		try {
			testException.calculate(0, 0);
		} catch (InvalidNumber e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		*/
		NewsService newsService = new NewsServiceImpl();
		List<NewsDTO> results = newsService.findAll();
		for(NewsDTO item: results) {
			System.out.println(item);
		}
//		NewsDTO dto = new NewsDTO();
//		dto.setContent("Gia đình là tế bào của xã hội");
//		dto.setShortDescription("Vai trò của gia đình");
//		dto.setTitle("Gia đình");
//		dto.setThumbnail("thumbnail_1");
//		dto.setCategoryId(2L);
//		newsService.save(dto);
	}
}
