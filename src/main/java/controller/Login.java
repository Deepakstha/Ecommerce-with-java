package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AESEncryption;
import model.UserDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = AESEncryption.encrypt(request.getParameter("password"));
		
		
		
		UserDao database = new UserDao();
		boolean isValid =  database.checkLogin(email, password);
		HttpSession session = request.getSession();
		if(isValid) {
			
			//admin
			if(database.checkUser(email, password).equals("admin")) {
				session.setAttribute("loggedInEmail", email);
				response.sendRedirect("views/Admin.jsp");
			}else if (database.checkUser(email, password).equals("normal")) {
				session.setAttribute("loggedInEmail", email);
				response.sendRedirect("Home");
			}
			
			//normal
			
			
//			response.sendRedirect("views/Admin.jsp");
			
		}else {
			session.setAttribute("message", "Login Failed");
			response.sendRedirect("views/Login.jsp");
			return;
		}
		
	}
}
