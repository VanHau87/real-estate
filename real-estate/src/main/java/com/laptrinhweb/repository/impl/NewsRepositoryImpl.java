package com.laptrinhweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.laptrinhweb.entity.NewsEntity;
import com.laptrinhweb.repository.EntityManagerFactory;
import com.laptrinhweb.repository.NewsRepository;

public class NewsRepositoryImpl extends JpaRepositoryImpl<NewsEntity> implements NewsRepository {

	@Override
	public void save(NewsEntity entity) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "insert into news (title, thumbnail, shortDescription, content, categoryId) " + 
		"values (?, ?, ?, ?, ?)";
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getTitle());
			statement.setString(2, entity.getThumbnail());
			statement.setString(3, entity.getShortDescription());
			statement.setString(4, entity.getContent());
			statement.setLong(5, entity.getCategoryId());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}
	}
	/*
		return this.findAll();
		//this.methodCall => cú pháp gọi lại hàm của class cha		
	*/
}
