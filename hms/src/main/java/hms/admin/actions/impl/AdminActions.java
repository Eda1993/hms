package hms.admin.actions.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hms.admin.actions.IAdminActions;
import hms.admin.models.Room;
import hms.commons.AbstractTable;

public class AdminActions extends AbstractTable implements IAdminActions {

	@Override
	public List<Room> getAllRooms() throws SQLException {
		List<Room> rooms = new ArrayList<>();

		String sql = "Select * from room";

		Statement statement = getPreparedStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			Room room = createRoom(resultSet);
			rooms.add(room);
		}

		return rooms;
	}

	private Room createRoom(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("Id");
		int kati = resultSet.getInt("KATI");
		int nrPeople = resultSet.getInt("NR_PEOPLE");
		int cmimi = resultSet.getInt("CMIMI");
		int airConditioner = Integer.parseInt(resultSet.getString("AIR_CONDITIONER"));
		int internet = Integer.parseInt(resultSet.getString("INTERNET"));
		int occupied = resultSet.getInt("OCCUPIED");

		return new Room(id, kati, nrPeople, cmimi, airConditioner, internet, occupied);
	}

	@Override
	public int insertRoom(Room room) throws SQLException {
		String sql = "insert into room (Id, KATI, NR_PEOPLE, CMIMI, AIR_CONDITIONER, INTERNET, OCCUPIED) values "
				+ "(?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pst1 = getPreparedStatement("select max(id)+1 from room");
		ResultSet rs = pst1.executeQuery();
		String user_id = "";
		while (rs.next()) {
			user_id = rs.getString(1);
		}

		PreparedStatement statement = getPreparedStatement(sql);

		statement.setString(1, user_id.toString());
		statement.setInt(2, room.getKati());
		statement.setInt(3, room.getNrPeople());
		statement.setInt(4, room.getCmimi());
		statement.setInt(5, room.getAirConditioner());
		statement.setInt(6, room.getInternet());
		statement.setInt(7, 0);

		return statement.executeUpdate();
	}

	@Override
	public int editRoom(Room room) throws SQLException {
		String sql = "UPDATE room SET KATI=?, NR_PEOPLE=?, CMIMI=?, AIR_CONDITIONER=?, INTERNET=?, OCCUPIED=? WHERE Id = ?";

		PreparedStatement statement = getPreparedStatement(sql);

		// statement.setString(1, user_id.toString());
		statement.setInt(1, room.getKati());
		statement.setInt(2, room.getNrPeople());
		statement.setInt(3, room.getCmimi());
		statement.setInt(4, room.getAirConditioner());
		statement.setInt(5, room.getInternet());
		statement.setInt(6, 0);
		statement.setInt(7, room.getId());

		return statement.executeUpdate();
	}

}
