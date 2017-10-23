package by.artur.filmStudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out= response.getWriter();
		
		HttpSession session = request.getSession();
		Object emailob=session.getAttribute("email");
		String email;
		Object passwordob=session.getAttribute("password");
		String password;
		if(emailob!=null && passwordob!=null) {
			email=String.valueOf(emailob);
			out.println("email");
			password=String.valueOf(passwordob);
			out.println("password");
			if( email.equals(request.getParameter("email")) &&  password.equals(request.getParameter("password"))) {
				RequestDispatcher disp=request.getRequestDispatcher("Manager.html");
				disp.forward(request, response);
			}
		}
		else {
			out.println("No register yet");
		}
		
	}
       




}
