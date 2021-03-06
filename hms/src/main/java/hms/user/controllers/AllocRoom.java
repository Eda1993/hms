package hms.user.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.admin.actions.impl.AdminActions;
import hms.user.models.User;

public class AllocRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int id = Integer.parseInt(request.getParameter("Id"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		try {
			new AdminActions().requestRoom(id, user.getId());
			request.getRequestDispatcher("welcomeUser.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
