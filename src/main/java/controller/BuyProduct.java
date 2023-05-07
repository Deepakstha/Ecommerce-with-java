package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDao;

@WebServlet("/BuyProduct")
public class BuyProduct extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CategoryDao database = new CategoryDao();
		String id = request.getParameter("id");
		String user = (String) session.getAttribute("loggedInEmail");
		String message = database.buyProduct(id, user);
		session.setAttribute("message", message);
		response.sendRedirect("Home");
	}

}
