package by.artur.filmStudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/ClientRegistration")
public class ClientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}


	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		System.out.println("service");
		
		HttpSession session= request.getSession();
		if(session.isNew()) {
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("password", request.getParameter("password"));
			out.println("new User");
			out.println("новый пользователь");
		}
		else {
			RequestDispatcher disp=request.getRequestDispatcher("login");
			disp.forward(request, response);
		}

		
	}

	   
	@Override
	public void destroy() {
	System.out.println("destroy");
	}

}
