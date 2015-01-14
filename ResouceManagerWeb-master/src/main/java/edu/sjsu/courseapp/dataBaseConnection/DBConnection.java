package edu.sjsu.courseapp.dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
	private static Connection con;
	private int QUERIES = 0;
	private static boolean conFree = true;
	private static String DatabaseURL = "jdbc:mysql://localhost:3306/mobilecloud";
	private static String  DatabaseDRIVER = "com.mysql.jdbc.Driver";
	private static String DatabaseUser = "root";
	private static String DatabasePassword = "admin";
	
	
	public  static Connection DBConnection () throws Exception{
		try  {               
			System.out.println("Before load driver");
			// Load the driver
			Class.forName(DatabaseDRIVER).newInstance();
			System.out.println("Before getConnection");
			// Get the connection
			con = DriverManager.getConnection(DatabaseURL,DatabaseUser,DatabasePassword);

			System.out.println("After getConnection");
			
		} catch (Exception ex) {
			throw new Exception("Couldn't open connection to database: " + ex.getMessage());
		}       
		return con;
	}
	
	
	public void remove () {
		try {
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	protected Connection getConnection() {
		this.QUERIES = ++QUERIES;
		return con;
	}
	
	
	protected synchronized void releaseConnection() {
		remove();
	}
	
	
	public int getNumQueries() {
		return QUERIES;
	}
	
	
	public static void main(String args[]) {
		System.out.println("MAIN ");
		try {

			Connection con1 = DBConnection.DBConnection();
		}
		catch(Exception e) {
			System.out.println("Exception in MAIN ");
			e.printStackTrace();
		}
	}
}