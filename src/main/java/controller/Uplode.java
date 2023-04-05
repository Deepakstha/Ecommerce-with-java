package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.UplodeFileDao;
import model.UplodeTest;

@WebServlet("/Uplode")
public class Uplode extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String relativePath = "userImage/"+fullname+".png";
		UplodeTest uplodeTest = new UplodeTest(fullname, password, relativePath);
		new UplodeFileDao().uplodeFile(uplodeTest);
		
		Part image = request.getPart("image");
		
		String imagePath = getServletContext().getInitParameter("imagePath");
		
		String fullPath = imagePath+relativePath;
		
		
		
		image.write(fullPath);

		
		
	}

}
