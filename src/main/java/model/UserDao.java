package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://localhost/ecommerce";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
//Registering User	
	public String registerUser(String fullname, String phone, String email, String gender, String password, String image) {
		
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO user(fullname,phonenumber,email,gender,password,image) VALUES(?,?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);

			
			
			 psmt = con.prepareStatement(query);
			 psmt.setString(1, fullname);
			 psmt.setString(2, phone);
			 psmt.setString(3, email);
			 psmt.setString(4, gender);
			 psmt.setString(5, password);
			 psmt.setString(6, image);
			 
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
	
	
//LoginUser	
	public boolean checkLogin(String email, String password) {
		boolean isValid = false;
		try {
			Connection con = getConnection();
			String query = "select * from user where email = ? and password = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet table = st.executeQuery();
			System.out.println(table);
			
//			while(table.next()) {
//				System.out.println(table.getString(1)+table.getString(2)+table.getString(3)+table.getString(4)+table.getString(5)+table.getString(6)+table.getString(7));
//			}
			if(table.next()) {
				isValid = true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return isValid;
	}
	
//Checking UserType
	public String checkUser(String email, String password) {
		ResultSet userType = null;
		String userTypeCheck = "normal";
		try {
			Connection con = getConnection();
			String query = "select userType from user where email = ? and password = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			userType = st.executeQuery();
			
			if(userType.next()) {
				userTypeCheck = userType.getString(1);
			}
			
					
//			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return userTypeCheck;
	}
	
	
// user Profile
	public UserDetails getUserDetails(String email) {
		Connection con = null;
		UserDetails userDetails = null;
		try {
			con = getConnection();
			String query = "select * from user where email=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,email);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id = table.getString(1);
				String fullname = table.getString(2);
				String phonenumber = table.getString(3);
				String email2 = table.getString(4);
				String gender = table.getString(5);
				String password = AESEncryption.decrypt(table.getString(6)) ;
				String userType = table.getString(7);
				String image = table.getString(8);

				userDetails = new UserDetails(id, fullname, phonenumber, email2, gender, password, userType,
						image);

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return userDetails;
		
	}
// Update Profile	
	public String updateProfile(UserDetails userDetails) {
		String message = "";
		
		try {

			Connection con = getConnection();
			String query = "UPDATE user SET fullname=?, phonenumber=?,email=?,gender=?,password=?,userType=?,image=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userDetails.getFullname() );
			pst.setString(2, userDetails.getPhonenumber());
			pst.setString(3, userDetails.getEmail() );
			pst.setString(4, userDetails.getGender());
			pst.setString(5, userDetails.getPassword());
			pst.setString(6, userDetails.getUserType());
			pst.setString(7, userDetails.getImage());
			pst.setString(8, userDetails.getUserId() );

			int rows = pst.executeUpdate();
			if (rows >= 1) {
				message = "Successfully Updated";
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;
	}
	
}
