package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/ecommerce";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

//Adding Category
	public String addingCategory(String categoryTitle, String categoryDesc) {
		String message = "";

		try {
			Connection con = getConnection();
			String query = "INSERT INTO category(title,description) VALUES(?,?)";
			PreparedStatement psmt = con.prepareStatement(query);

			psmt = con.prepareStatement(query);
			psmt.setString(1, categoryTitle);
			psmt.setString(2, categoryDesc);

			int rows = psmt.executeUpdate();
			if (rows >= 1) {
				message = "Category added !!";
			} else {
				message = "Try again";
			}
			con.close();

		} catch (Exception ex) {
			message = ex.getMessage();
		}
		return message;
	}

//Adding Product
	public String addingProduct(String productTitle, String productDesc, String price, String discount, String quantity,
			String category, String image) {
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO products(productTitle,productDescription,price,discount,quantity,category,image) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, productTitle);
			pst.setString(2, productDesc);
			pst.setString(3, price);
			pst.setString(4, discount);
			pst.setString(5, quantity);
			pst.setString(6, category);
			pst.setString(7, image);

			int rows = pst.executeUpdate();
			if (rows >= 1) {
				message = "Successfully Added";
			}
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;
	}

//Fetching Products from database		
	public ArrayList<Products> fetchProductList() {
		ArrayList<Products> productList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from products";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id = table.getString(1);
				String productTitle = table.getString(2);
				String productDescription = table.getString(3);
				int price = table.getInt(4);
				int discount = table.getInt(5);
				int quantity = table.getInt(6);
				String category = table.getString(7);
				String image = table.getString(8);

				Products product = new Products(id, productTitle, productDescription, price, discount, quantity,
						category, image);
				productList.add(product);
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
		return productList;

	}

//Getting Product by id
	public Products getProductRecordById(String id) {
		Connection con = null;
		Products products = null;
		try {
			con = getConnection();
			String query = "select * from products where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String id2 = table.getString(1);
				String productTitle = table.getString(2);
				String productDescription = table.getString(3);
				int price = table.getInt(4);				
				int discount = table.getInt(5);
				int quantity = table.getInt(6);
				String category = table.getString(7);
				String image = table.getString(8);

				products = new Products(id2, productTitle, productDescription, price, discount, quantity, category,
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
		return products;

	}

//Updating Products		
	public String updateProduct(Products product) {
		String message = "";
		try {

			Connection con = getConnection();
			String query = "UPDATE products SET productTitle=?, productDescription=?,price=?,discount=?,quantity=?,category=?,image=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getProductTitle());
			pst.setString(2, product.getProductDescription());
			pst.setInt(3, product.getPrice());
			pst.setInt(4, product.getDiscount());
			pst.setInt(5, product.getQuantity());
			pst.setString(6, product.getCategory());
			pst.setString(7, product.getImage());
			pst.setString(8, product.getProductId());

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

// Deleting Products
	public String deletingProduct(String id) {
		Connection con = null;
//		Products products = null;
			try {
				 con = getConnection();
				String query = "DELETE FROM products WHERE id=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, id);
				int table = pst.executeUpdate();
				
			}catch (ClassNotFoundException | SQLException e) {
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
			return id;
	}

}
