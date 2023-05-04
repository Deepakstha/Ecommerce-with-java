package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryDao;
import model.Products;
import model.UserDao;

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		Products pd = new CategoryDao().getProductRecordById(id);
		System.out.println("id "+id + "pd "+pd);
//		System.out.println("pd "+pd);
		request.setAttribute("product", pd);
		RequestDispatcher rd = request.getRequestDispatcher("views/UpdateProduct.jsp");
		rd.forward(request, response);

	}
} 
