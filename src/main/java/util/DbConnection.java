package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
					
					System.out.println(DbConnection.getDb());

	}
	
	public static Connection getDb() {
								String drurl="com.mysql.cj.jdbc.Driver";
								String url="jdbc:mysql://localhost:3306/homework3";
								String username="root";
								String password="1234";
								Connection conn=null;
								
								try {
									Class.forName(drurl);
									conn=DriverManager.getConnection(url,username,password);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									System.out.println("no driver");
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								return conn;
	}
	

}
