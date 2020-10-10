package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.service.MagazineUsersService;
import ua.lviv.lgs.service.impl.MagazineUsersServiceImpl;

@WebServlet(value = "/bucketContr")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 6L;
	private MagazineUsersService magazineUsersService = MagazineUsersServiceImpl.getMagazineUsersService();   
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("bucket post");
		
		String magazineId = request.getParameter("magazineId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");		
		MagazineUsers magazineUsers = null;		
			
		try {
			magazineUsers = new MagazineUsers(userId, Integer.parseInt(magazineId), new Date());
		} catch(Exception e) {
			
		}
		
		magazineUsersService.create(magazineUsers);
				
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
