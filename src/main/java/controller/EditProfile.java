package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDao;
import model.Products;
import model.UserDetails;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("loggedInEmail");

		UserDetails ud = new UserDao().getUserDetails(email);
		System.out.println("Email "+email + "User "+ud);
		request.setAttribute("userDetails", ud);
		RequestDispatcher rd = request.getRequestDispatcher("views/EditProfile.jsp");
		rd.forward(request, response);

	}
}
