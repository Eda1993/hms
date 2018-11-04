package hms.user.controllers;

import static hms.user.actions.impl.UserActions.ACCEPTED;
import static hms.user.actions.impl.UserActions.PENDING;
import static hms.user.actions.impl.UserActions.REJECTED;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.user.actions.impl.UserActions;
import hms.user.models.User;

public class ResponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		try {
			Map<String, List<String>> messages = new UserActions().getResposes(user.getId());
			
			request.setAttribute("pendingRequests", messages.get(PENDING));
			request.setAttribute("acceptedRequests", messages.get(ACCEPTED));
			request.setAttribute("rejectedRequests", messages.get(REJECTED));
			
			RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
			rd.forward(request, response);
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
