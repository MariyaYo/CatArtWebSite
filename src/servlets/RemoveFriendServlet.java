package servlets;

 import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;

import DAO.UserDAO;
 import model.User;
 
 /**
  * Servlet implementation class RemoveFriendServlet
  */
 @WebServlet("/removeFriend")
 public class RemoveFriendServlet extends HttpServlet {
 	private static final long serialVersionUID = 1L;
     
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		HttpSession session = request.getSession();
 		String username =(String)session.getAttribute("user");
 		String frUsername = request.getParameter("blocked");
 		System.out.println(username + " added " + request.getParameter("blocked"));
 		User user = null;
 		User fr = null;
		try {
			user = UserDAO.getInstance().getUser(username);
	 		fr =  UserDAO.getInstance().getUser(frUsername);
		} catch (ValidationException e) {
			System.out.println("ops");
		} catch (SQLException e) {
			System.out.println("ops");
		}
 		UserDAO.getInstance().removeFromFriends(user,fr);
 		response.sendRedirect("JSP/friends.jsp");
 	}
 
 }
