package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.AESEncryption;
import model.UserDao;

@WebServlet("/Signup")
@MultipartConfig
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String fullname = request.getParameter("fullname").trim();
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String finalpassword=null;
		String relativePath = "userImage/"+fullname+".png";
//		String encryptedPassword = AESEncryption.encrypt(finalpassword);
		
		
		if(password.equals(repassword)) {
			finalpassword = AESEncryption.encrypt(password);
		}else if(password != repassword) {
			out.println("Password dosnot Match");
			return;
		}
		
		// validation
		if(email.isEmpty()) {
			session.setAttribute("message","Email field cannot be empty!!");
			response.sendRedirect("views/Signup.jsp");

			return;
		}
		if(fullname.isEmpty()) {
			session.setAttribute("message","Please Enter your Fullname!!");
			response.sendRedirect("views/Signup.jsp");

			return;
		}
		if(phone.isEmpty()) {
			session.setAttribute("message","Please Enter Phonenumber!!");
			response.sendRedirect("views/Signup.jsp");
			return;
		}
		if(gender.isEmpty()) {
			session.setAttribute("message","Choose Gender!!");
			response.sendRedirect("views/Signup.jsp");

			return;
		}
		
		
		UserDao database = new UserDao();
		String message = database.registerUser(fullname, phone, email, gender, finalpassword, relativePath);
//		session.setAttribute("message",message);
		if(message.equals("Thank You for Register !!")) {
			Part image = request.getPart("image");
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
			session.setAttribute("message","Registration Successful!!");
		}else {
			session.setAttribute("message","Not Registered!!");
		}
		
		
		
		response.sendRedirect("views/Signup.jsp");

		
		
	}

}
