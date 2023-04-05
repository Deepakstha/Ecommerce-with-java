package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AESEncryption;
import model.SignupDao;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String finalpassword=null;
		String encryptedPassword = AESEncryption.encrypt(finalpassword);
		
		
		if(password.equals(repassword)) {
			finalpassword = password;
		}else if(password != repassword) {
			out.println("Password dosnot Match");
			return;
		}
		
		// validation
		if(email.isEmpty()) {
			out.println("Email field cannot be empty");
			return;
		}
		if(fullname.isEmpty()) {
			out.println("Please Enter your Fullname");
			return;
		}
		if(phone.isEmpty()) {
			out.println("Please Enter Phonenumber");
			return;
		}
		if(gender.isEmpty()) {
			out.println("Please Enter Phonenumber");
			return;
		}
		
		
		SignupDao database = new SignupDao();
		String message = database.registerUser(fullname, phone, email, gender, encryptedPassword);
		
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("message","Registration Successful!!");
		response.sendRedirect("views/Signup.jsp");

		
		
	}

}
