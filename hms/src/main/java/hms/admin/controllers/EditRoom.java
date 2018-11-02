package hms.admin.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.admin.actions.IAdminActions;
import hms.admin.actions.impl.AdminActions;
import hms.admin.models.Room;

public class EditRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IAdminActions actions = new AdminActions();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		Room room = new Room();
		room.setId(Integer.parseInt(request.getParameter("id")));
		room.setKati(Integer.parseInt(request.getParameter("kati")));
		room.setNrPeople(Integer.parseInt(request.getParameter("nrPeople")));
		room.setCmimi(Integer.parseInt(request.getParameter("cmimi")));
		room.setAirConditioner(Integer.parseInt(request.getParameter("ac")));
		room.setInternet(Integer.parseInt(request.getParameter("net")));

		try {
			actions.editRoom(room);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("AdminController");

	}

}
