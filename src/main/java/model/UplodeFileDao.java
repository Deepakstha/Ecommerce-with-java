package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UplodeFileDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://localhost/ecommerce";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
public String uplodeFile(UplodeTest uplodeTest) {
		
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO uplode(fullname,image,password) VALUES(?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);

			 psmt = con.prepareStatement(query);
			 psmt.setString(1, uplodeTest.getFullname());
			 psmt.setString(2, uplodeTest.getImgaePath());
			 psmt.setString(2, uplodeTest.getPassword());
	
			 
			 int rows = psmt.executeUpdate();
			 if(rows >= 1) {
				 message = "Thank You for Register !!";
			 }else {
				 message = "Try again";
			 }
			 
			 
			 
			con.close();
		}catch(Exception ex) {
			message = ex.getMessage();
		}
		return message;
	}
	
}
