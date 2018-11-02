package hms.admin.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.admin.actions.IAdminActions;
import hms.admin.actions.impl.AdminActions;


public class ShowRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IAdminActions adminActions = new AdminActions();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			request.setAttribute("rooms", adminActions.getRooms());
			
			RequestDispatcher rd = request.getRequestDispatcher("roomAlloc.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
