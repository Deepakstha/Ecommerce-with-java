package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignupDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		SignupDao database = new SignupDao();
		boolean isValid =  database.checkLogin(email, password);
		if(isValid) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedInEmail", email);
			response.sendRedirect("views/Home.jsp");
			
//			RequestDispatcher rd = request.getRequestDispatcher('StudentProfile.jsp');
//			rd.forward(request, response);
		}else {
			response.sendRedirect("views/Login.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher('StudentProfile.jsp');
//			request.setAttribute("LoginMessage", "Fail");
//			rd.forward(request, response);
		}
		
	}
}
