package com.laptrinhweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.entity.CategoryEntity;
import com.laptrinhweb.repository.CategoryRepository;
import com.laptrinhweb.repository.EntityManagerFactory;

public class CategoryReposioryImpl extends JpaRepositoryImpl<CategoryEntity> implements CategoryRepository{

	@Override
	public List<CategoryEntity> findAll() {
		List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
		Connection connection = EntityManagerFactory.getConnection();
		String sql = "select * from category";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					CategoryEntity categoryEntity = new CategoryEntity();
					categoryEntity.setCode(resultSet.getString("code"));
					categoryEntity.setName(resultSet.getString("name"));
					categoryEntities.add(categoryEntity);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return new ArrayList<CategoryEntity>();
			} finally {
				try {
					if (resultSet != null) {
						resultSet.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
					return new ArrayList<CategoryEntity>();
				}
			}
		}
		return categoryEntities;
	}

	@Override
	public void save(CategoryEntity entity) {
		String sql = "insert into category (name, code, createddate) values(?, ?, ?)";
		this.save(sql, entity.getName(), entity.getCode(), new Timestamp(System.currentTimeMillis()));		
	}

}
