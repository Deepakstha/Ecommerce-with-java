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
import model.UserDetails;

@WebServlet("/UpdateProfile")
@MultipartConfig
public class UpdateProfile extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userId");
		String fullname = request.getParameter("fullname").trim();
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = AESEncryption.encrypt(request.getParameter("password"));
		String userType = request.getParameter("userType");
		String relativePath = "userImage/"+fullname+".png";
		
		UserDetails userDetails =  new UserDetails(id,fullname,phone,email,gender,password,userType, relativePath);
		UserDao uDao = new UserDao();
		String message =  uDao.updateProfile(userDetails);
		
		if (message.equals("Successfully Updated")) {
			Part image = request.getPart("image");
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath + relativePath;
			image.write(fullPath);
			session.setAttribute("message", "Profile Updated!!");
		}else {
			session.setAttribute("message", "Failed to Updated!!");
		}
		response.sendRedirect("Home");
	}
	
}
