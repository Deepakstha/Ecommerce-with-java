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
import model.Orders;

@WebServlet("/DisplayCart")
public class DisplayCart extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CategoryDao cartData = new CategoryDao();
		String user = (String) session.getAttribute("loggedInEmail");
		ArrayList<Orders> cartList = cartData.displayCart(user);
		
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("views/DisplayCart.jsp").forward(request, response);
		
	}
}
