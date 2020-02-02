package com.laptrinhweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Table;
import com.laptrinhweb.mapper.ResultSetMapper;
import com.laptrinhweb.repository.EntityManagerFactory;
import com.laptrinhweb.repository.JpaRepository;

public class JpaRepositoryImpl<T> implements JpaRepository<T> {
	
	private Class<T> zClass;//khai báo 1 class T
	
	@SuppressWarnings("unchecked")
	public JpaRepositoryImpl() {
		zClass = (Class<T>) getClass();
		System.out.println(zClass);
		Type type = zClass.getGenericSuperclass();
		System.out.println(type);
		ParameterizedType parameterizedType = (ParameterizedType) type;
		System.out.println(parameterizedType);
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		System.out.println(zClass);
	}	
	@Override
	public List<T> findAll(Object ...where) {
		// tạo connection
		Connection connection = EntityManagerFactory.getConnection();
		// tạo preparestatement
		PreparedStatement statement = null;
		// tạo resultset
		ResultSet resultSet = null;
		String tableName = "";
		//List<T> list = new ArrayList<T>(); ==>tạo list để chứa data lấy ra
		ResultSetMapper<T> results = new ResultSetMapper<T>();
		if (connection != null) {// kiểm tra connection có tồn tại không
			try {
				if (zClass.isAnnotationPresent(Table.class)) {
					//Kiểm tra class có chứa @annotation table không
					Table table = zClass.getAnnotation(Table.class);
					//lấy table
					tableName = table.name();//=>lấy tên của table
				}
				StringBuilder sql = new StringBuilder("select * from ");
				sql.append(tableName).append(" ");
				if (where != null && where.length == 1) {
					sql.append(where[0]);
				}
				statement = connection.prepareStatement(sql.toString());
				resultSet = statement.executeQuery();
				return results.mapRow(resultSet, this.zClass);
			} catch (SQLException e) {
				e.printStackTrace();
				return new ArrayList<T>();
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
					return new ArrayList<T>();
				}
			}
		}
		return new ArrayList<>();
	}
	@Override
	public void save(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			int index = 1;
			for (Object object : objects) {
				statement.setObject(index, object);
				index++;
			}
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
	@Override
	public void insert(Object object) {
		String sql = createSQLInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			//convert object -> object class
			Class<?> aClass = object.getClass();
			Field[] fields = aClass.getDeclaredFields();
			int index = 1;
			for (Field field : fields) {
				field.setAccessible(true);
				statement.setObject(index, field.get(object));
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException | IllegalAccessException e) {
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
	private String createSQLInsert() {
		String tableName = "";
		StringBuilder fieldSql = new StringBuilder("");
		StringBuilder paramSql = new StringBuilder("");
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		Field[] fields = zClass.getDeclaredFields();
		for (Field field : fields) {
			if (fieldSql.length() >= 1) {
				fieldSql.append(",");
				paramSql.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fieldSql.append(column.name());
				paramSql.append("?");
			}	
		}
		String sql = "INSERT INTO " + tableName + " (" + fieldSql.toString() + ") VALUES (" + paramSql +")";
		return sql;
	}
	@Override
	public List<T> findAll(String sql, Object... where) {
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMapper<T> results = new ResultSetMapper<T>();
		if (connection != null) {// kiểm tra connection có tồn tại không
			try {
				
				StringBuilder buildSQL = new StringBuilder(sql);
				if (where != null && where.length == 1) {
					buildSQL.append(where[0]);
				}
				//statement = connection.prepareStatement(sql.toString());
				statement = connection.createStatement();
				//resultSet = statement.executeQuery();
				resultSet = statement.executeQuery(buildSQL.toString());
				return results.mapRow(resultSet, this.zClass);
			} catch (SQLException e) {
				e.printStackTrace();
				return new ArrayList<T>();
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
					return new ArrayList<T>();
				}
			}
		}
		return new ArrayList<>();
	}

}
