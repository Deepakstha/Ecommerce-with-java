package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://localhost/ecommerce";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
//	public Connection getConnection() {
//		return null;
//		
//	}
	
	public String registerUser(String fullname, String phone, String email, String gender, String password) {
		
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO user(fullname,phonenumber,email,gender,password) VALUES(?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);

			
			
			 psmt = con.prepareStatement(query);
			 psmt.setString(1, fullname);
			 psmt.setString(2, phone);
			 psmt.setString(3, email);
			 psmt.setString(4, gender);
			 psmt.setString(5, password);
			 
			 int rows = psmt.executeUpdate();
			 if(rows >= 1) {
				 message = "Thank You for Register !!";
			 }else {
				 message = "Try again";
			 }
			 
			 
			 
			
		}catch(Exception ex) {
			message = ex.getMessage();
		}
		return message;
	}
	
	
	
	public boolean checkLogin(String email, String password) {
		boolean isValid = false;
		try {
			Connection con = getConnection();
			String query = "select * from user where email = ? and password = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet table = st.executeQuery();
			
			if(table.next()) {
				isValid = true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return isValid;
	}
	
	

}
