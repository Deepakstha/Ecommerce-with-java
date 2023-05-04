package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.CategoryDao;
import model.UserDao;

@WebServlet("/ProductOperationServlet")
@MultipartConfig
public class ProductOperationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
//		ArrayList<CategoryList> categoryList = new CategoryDao().fetchCategory();
//		request.setAttribute("categoryList", categoryList);
//		request.getRequestDispatcher("views/AddProduct.jsp").forward(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		try(PrintWriter out = response.getWriter()){

			String operation = request.getParameter("operation");
			if(operation.trim().equals("addcategory")) {
				//Adding Category
				String title = request.getParameter("categoryTitle");
				String desc = request.getParameter("categoryDesc");
				
				CategoryDao database = new CategoryDao();

				database.addingCategory(title, desc);
				
				
				session.setAttribute("message","Category Added!!");				
				response.sendRedirect("views/AddCategory.jsp");
				
			}else if(operation.trim().equals("addproduct")) {
				//Adding Product
				String productTitle = request.getParameter("productTitle");
				String productDesc = request.getParameter("productDesc");
				String price = request.getParameter("price");
				String discount = request.getParameter("discount");
				String quantity = request.getParameter("quantity");
				String catId = request.getParameter("catId");
				String relativePath = "productImage/"+productTitle+".png";
				
				
				CategoryDao database = new CategoryDao();

				String message = database.addingProduct(productTitle, productDesc, price, discount, quantity, catId, relativePath);
				
				if(message.equals("Successfully Added")) {
					Part image = request.getPart("image");
					String imagePath = getServletContext().getInitParameter("imagePath");
					String fullPath = imagePath+relativePath;
					image.write(fullPath);
				}
				
				session.setAttribute("message","Product Added!!");
				response.sendRedirect("views/AddProduct.jsp");
				
			}
			
		}
	}
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		CategoryDao database = new CategoryDao();
//		HttpSession session = request.getSession();
//		session.setAttribute("message","Product Added!!");
//		ArrayList<Category> categoryList = database.fetchCategory();
////		System.out.println(categoryList);
//		request.setAttribute("categoryList", categoryList);
//		request.getRequestDispatcher("views/AddProduct.jsp").forward(request, response);
////		response.sendRedirect("views/AddProduct.jsp");
//	}
}
