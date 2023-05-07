package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.CategoryDao;
import model.Products;
import model.UserDao;

@WebServlet("/UpdateProduct")
@MultipartConfig
public class UpdateProduct extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String productId = request.getParameter("productId");
		String productTitle = request.getParameter("productTitle").trim();
		String productDesc = request.getParameter("productDesc");
		int price = Integer.parseInt(request.getParameter("price"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String catId = request.getParameter("catId");
		String relativePath = "productImage/" + productTitle + ".png";
		

		Products product = new Products(productId, productTitle, productDesc, price, discount, quantity, catId,
				relativePath);

		CategoryDao database = new CategoryDao();

		String message = database.updateProduct(product);
//		String message = database.addingProduct(productTitle, productDesc, price, discount, quantity, catId, relativePath);

		if (message.equals("Successfully Updated")) {
			Part image = request.getPart("image");
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath + relativePath;
			image.write(fullPath);
			session.setAttribute("message", "Product Updated!!");
		}else {
			session.setAttribute("message", "Failed to Updated!!");
		}

		
		response.sendRedirect("ViewProduct");
	}

}
