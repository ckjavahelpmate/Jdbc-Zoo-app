package com.ty.zoo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.ty.zoo.util.UC.*;


public class ConnectionObject {
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}