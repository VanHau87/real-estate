package com.laptrinhweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs, Class<T> zClass){
		List<T> list = new ArrayList<T>();
		try {
			if (zClass.isAnnotationPresent(Entity.class)) {//kiểm tra class có annotation entity không
				ResultSetMetaData metaData = rs.getMetaData();
				//resultsetMetadata cung cấp thông tin về resultset: số lượng cột, tên các cột, kiểu data của
				//cột..
				Field[] fields = zClass.getDeclaredFields();
				//lấy tất cả các fields của class=> để lấy tên và giá trị của fields
				while (rs.next()) {//rs.next() => đi vô từng row
					T object = zClass.newInstance();//Khởi tạo 1 object T để có đủ các fields
					//convert ngược lại 1 object
					for (int i = 0; i < metaData.getColumnCount(); i++) {
						//lấy tên column trong ResultSetMetaData
						String columnName = metaData.getColumnName(i+1); //do không lấy id
						//lấy giá trị của column trong ResultSetMetaData
						Object columnValue = rs.getObject(i+1);
						for (Field field : fields) {
							//lặp các field, kiểm tra @annotation Column
							if (field.isAnnotationPresent(Column.class)) {
								//lấy tên của field (thuộc tính) chứa @annotation Column
								Column column = field.getAnnotation(Column.class);
								//so sánh tên của column lấy từ class với tên của column lấy từ metadata 
								if (column.name().equals(columnName)) {
									//nếu trùng thì set data vô bằng thư viện BeanUtils
									BeanUtils.setProperty(object, columnName, columnValue);
									break;
								}
							}
						}
					}
					list.add(object);
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
