package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SignupDao;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		SignupDao database = new SignupDao();
		String message = database.registerUser(fullname, phone, email, gender, password);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(" <h1>"+message+"</h1>");
		
	}

}
