package com.insure.quote.utils;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import oracle.jdbc.OracleDriver;
	public class DataBaseConnection {
		private static Connection conn=null;
		public static Connection getConnection() {
			try {
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="System";
			String pass="Keshavshashi30";
			DriverManager.registerDriver(new OracleDriver());
				conn=DriverManager.getConnection(url,user,pass);
			}catch(SQLException   e) {
				e.printStackTrace();
			}			
			return conn;				
		}
		public static void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
