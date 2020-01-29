package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.dto.NewsDTO;

public class NewsMapper implements RowMapper<NewsDTO>{

	@Override
	public NewsDTO mapRow(ResultSet resultSet) {
		NewsDTO newsDTO = new NewsDTO();
		try {
			newsDTO.setContent(resultSet.getString("content"));
			newsDTO.setShortDescription(resultSet.getString("shortDescription"));
			newsDTO.setThumbnail(resultSet.getString("thumbnail"));
			newsDTO.setTitle(resultSet.getString("title"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return newsDTO;
	}

}
