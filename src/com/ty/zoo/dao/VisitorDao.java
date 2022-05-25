package com.ty.zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.ConnectionObject;

public class VisitorDao {

	public int saveVisitor(Visitor visitor) {

		String sql = "insert into visitor values(?,?,?,?,?,?)" ;
		Connection connection = ConnectionObject.getConnection() ;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			
			
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, visitor.getName());
			preparedStatement.setString(3, visitor.getEmail());
			preparedStatement.setString(4, visitor.getPhone());
			preparedStatement.setString(5,visitor.getGender());
			preparedStatement.setInt(6, visitor.getAge());

			return preparedStatement.executeUpdate() ;


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Visitor getVisitorById(int id ) {
		
		String sql = "Select * from visitor where id="+id ;
		Connection connection = ConnectionObject.getConnection() ;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;

			ResultSet res = preparedStatement.executeQuery() ;
			Visitor visitor = new Visitor() ;
			while( res.next() ) {
				
				visitor.setId(res.getInt(1));
				visitor.setName(res.getString(2));
				visitor.setEmail(res.getString(3));
				visitor.setPhone(res.getString(4));
				visitor.setGender(res.getString(5));
				visitor.setAge(res.getInt(6));
			}
			return visitor ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
