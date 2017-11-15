package com.tc23.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
		private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		private final static String NAME = "C##abc";
		private final static String PWD = "123456";
		
		public static Connection getConnection() {
			Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, NAME, PWD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
}
