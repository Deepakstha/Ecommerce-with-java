package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Products;
import model.CategoryDao;

@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CategoryDao productData = new CategoryDao();
			ArrayList<Products> productList = productData.fetchProductList();
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("views/viewProductList.jsp").forward(request, response);
			
		}

}
