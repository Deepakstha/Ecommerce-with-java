package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import model.CategoryDao;
import model.Products;

@WebServlet("/Home")
public class Home extends HttpServlet {
	int addedCartProduct = 0;
	Cookie c = null;	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isLoggedIn = (session.getAttribute("loggedInEmail") != null);
		CategoryDao productData = new CategoryDao();
		ArrayList<Products> productList = new ArrayList<Products>();
		String catagory = (String) request.getParameter("catagory");
		if(catagory != null) {
			productList = productData.fetchProductWithCategory(catagory);
		}else {
			productList = productData.fetchProductList();			
		}
		
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("views/Home.jsp").forward(request, response);
		
	}
}
