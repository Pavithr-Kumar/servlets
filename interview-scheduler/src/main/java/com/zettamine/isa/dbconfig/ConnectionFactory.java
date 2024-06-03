package com.zettamine.isa.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	public static Connection getDBConnection() {
		Connection con=null;
		ResourceBundle rsb = ResourceBundle.getBundle("com/zettamine/isa/dbconfig/dbconfiguration");
		
		try {
			Class.forName(rsb.getString("driver"));
			con = DriverManager.getConnection(rsb.getString("url"),rsb.getString("user"),rsb.getString("pass"));
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}

}
