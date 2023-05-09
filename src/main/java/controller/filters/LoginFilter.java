package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AESEncryption;
import model.UserDao;

@WebFilter(urlPatterns= {"/views/Admin.jsp",""})
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session =((HttpServletRequest)request).getSession();
		System.out.println("test");
		if(session.getAttribute("loggedInEmail") != null) {
				chain.doFilter(request, response);
			
		}else {
			((HttpServletResponse)response).sendRedirect("Login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}