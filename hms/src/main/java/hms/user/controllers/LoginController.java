package hms.user.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.user.actions.impl.AdminController;
import hms.user.actions.impl.UserController;
import hms.user.models.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		User user = new User();

		String type = request.getParameter("loginSelector");

		if (type.equals("admin")) {
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			AdminController ac = new AdminController();
			try {
				String s1 = ac.login(user);
				if (s1.equals("success")) {
					HttpSession session = request.getSession();
					session.setAttribute("username", user.getUsername());

					response.sendRedirect("UserServlet");

				} else {
					out.println("Kredencialet jane gabim");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (type.equals("user")) {

			user.setUsername(request.getParameter("username"));

			user.setPassword(request.getParameter("password"));

			UserController uc = new UserController();
			try {
				String s1 = uc.login(user);
				if (s1.equals("success")) {
					HttpSession session = request.getSession();
					session.setAttribute("username", user.getUsername());
					response.sendRedirect("welcomeUser.jsp");
				} else {
					out.println("Kredencialet jane gabim");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
