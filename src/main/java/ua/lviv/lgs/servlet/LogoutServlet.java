package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/logOut")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("logout servlet get");
		HttpSession session = request.getSession();
		if(session == null) {
			session.invalidate();
		}
		//request.getRequestDispatcher("index.jsp").forward(request, response);	
		
		  response.setContentType("text");
		  response.setCharacterEncoding("UTF-8");
		  response.getWriter().write("index.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout servlet post");
	}
	

}
