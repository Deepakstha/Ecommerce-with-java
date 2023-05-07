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
import model.Products;

@WebServlet("/DisplayOrdersList")
public class DisplayOrdersList extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CategoryDao orderData = new CategoryDao();
		
		
		ArrayList<Orders> AdminOrderList = new ArrayList<Orders>();
		String userOrders = (String) request.getParameter("userOrders");
		System.out.println("UserorderList"+userOrders);
		if(userOrders != null) {
			AdminOrderList = orderData.displayOrderList(userOrders);
			request.setAttribute("AdminOrderList", AdminOrderList);
			request.getRequestDispatcher("views/AdminOrderList.jsp").forward(request, response);
		}else {
			String user = (String) session.getAttribute("loggedInEmail");
			ArrayList<Orders> orderList = orderData.displayOrderList(user) ;
			
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("views/DisplayOrderList.jsp").forward(request, response);
		}
		
	}
}
