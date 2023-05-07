package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDao;
import model.Products;

@WebServlet("/search")
public class SearchProduct extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CategoryDao searchData = new CategoryDao();
		ArrayList<Products> searchList = new ArrayList<Products>();
		String search = (String) request.getParameter("search");
		if(search != null) {
			searchList = searchData.displaySearchProduct(search);
		}	
		
		request.setAttribute("searchList", searchList);
		request.getRequestDispatcher("views/Search.jsp").forward(request, response);
		
	}

}
