package hms.user.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.user.actions.IUserActions;
import hms.user.actions.impl.UserActions;
import hms.user.models.User;

public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserActions actions = new UserActions();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		User user = new User();

		user.setName(request.getParameter("name"));
		user.setLastname(request.getParameter("lastname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setBirthday(Date.valueOf(request.getParameter("birthday")));
		user.setGender(request.getParameter("gender").charAt(0));

		try {
			actions.insertUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//HttpSession session = request.getSession();
		request.setAttribute("username", user.getUsername());

		response.sendRedirect("welcomeUser.jsp");
	}

}
