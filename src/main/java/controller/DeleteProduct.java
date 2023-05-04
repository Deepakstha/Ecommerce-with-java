package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import model.Products;


@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CategoryDao database = new CategoryDao();
//		database.deletingProduct(request.getParameter("id"));
		String id = request.getParameter("id");
		database.deletingProduct(id);
		System.out.println(database.deletingProduct(id));
		


		 response.sendRedirect("ViewProduct");
	}

}
