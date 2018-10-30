package hms.user.controllers;

import static hms.commons.UserType.ADMIN;
import static hms.commons.UserType.USER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.commons.UserType;
import hms.user.actions.IUserActions;
import hms.user.actions.impl.AdminController;
import hms.user.actions.impl.UserActions;
import hms.user.actions.impl.UserController;
import hms.user.models.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
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
		doGet(request, response);

		PrintWriter out = response.getWriter();

		String type = request.getParameter("loginSelector");
		String username = request.getParameter("username");
		String password = request.getParameter("password");


		try {

			User user = actions.login(username, password, type);

			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				if (type.equals(ADMIN.toString())) {
					response.sendRedirect("UserServlet");
				} else {
					response.sendRedirect("welcomeUser.jsp");
				}

			} else {
				out.println("Kredencialet jane gabim");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
