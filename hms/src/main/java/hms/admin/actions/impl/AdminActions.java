package hms.admin.actions.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hms.admin.actions.IAdminActions;
import hms.admin.models.RequestedRoom;
import hms.admin.models.Room;
import hms.commons.AbstractTable;

public class AdminActions extends AbstractTable implements IAdminActions {

	@Override
	public List<Room> getAllRooms() throws SQLException {
		List<Room> rooms = new ArrayList<>();

		String sql = "Select * from room  where occupied <> -1 group by room_number";

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
		int roomNumber = resultSet.getInt("ROOM_NUMBER");
		int kati = resultSet.getInt("KATI");
		int nrPeople = resultSet.getInt("NR_PEOPLE");
		int cmimi = resultSet.getInt("CMIMI");
		int airConditioner = Integer.parseInt(resultSet.getString("AIR_CONDITIONER"));
		int internet = Integer.parseInt(resultSet.getString("INTERNET"));
		int occupied = resultSet.getInt("OCCUPIED");
		int requestedBy = resultSet.getInt("REQUESTED_BY");

		return new Room(id, roomNumber, kati, nrPeople, cmimi, airConditioner, internet, occupied, requestedBy);
	}

	@Override
	public int insertRoom(Room room) throws SQLException {
		String sql = "insert into room (KATI, ROOM_NUMBER, NR_PEOPLE, CMIMI, AIR_CONDITIONER, INTERNET, OCCUPIED) values "
				+ "(?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = createStatementToInsertRoom(room, sql);
		return statement.executeUpdate();
	}

	@Override
	public int editRoom(Room room) throws SQLException {
		String sql = "UPDATE room SET KATI=?, NR_PEOPLE=?, CMIMI=?, AIR_CONDITIONER=?, INTERNET=?, OCCUPIED=? WHERE Id = ?";

		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, room.getKati());
		statement.setInt(2, room.getNrPeople());
		statement.setInt(3, room.getCmimi());
		statement.setInt(4, room.getAirConditioner());
		statement.setInt(5, room.getInternet());
		statement.setInt(6, 0);
		statement.setInt(7, room.getId());

		return statement.executeUpdate();
	}

	@Override
	public List<Room> getRooms() throws SQLException {
		List<Room> rooms = new ArrayList<>();

		String sql = "Select * from room WHERE OCCUPIED = 0 group by room_number";

		Statement statement = getPreparedStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			Room room = createRoom(resultSet);
			rooms.add(room);
		}

		return rooms;
	}

	@Override
	public List<RequestedRoom> getRequests() throws SQLException {
		List<RequestedRoom> rooms = new ArrayList<>();

		String sql = "select * " + "from room r, user u "
				+ "where r.OCCUPIED = 0 and r.REQUESTED_BY is not null and r.REQUESTED_BY = u.ID "
				+ "order by room_number";

		Statement statement = getPreparedStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String userName = resultSet.getString("NAME");
			String userSurname = resultSet.getString("LASTNAME");
			RequestedRoom room = new RequestedRoom(createRoom(resultSet));
			room.setUserName(userName);
			room.setUserSurname(userSurname);
			rooms.add(room);
		}

		return rooms;
	}

	@Override
	public void requestRoom(int roomId, int userId) throws SQLException {
		Room room = isRoomRequested(roomId);
		if (room != null) {
			insertRoom(room, userId);
		} else {
			String sql = "UPDATE room SET REQUESTED_BY = ? WHERE Id = ?";

			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, userId);
			statement.setInt(2, roomId);
			statement.executeUpdate();
		}
	}

	@Override
	public int insertRoom(Room room, int requestedBy) throws SQLException {
		String sql = "insert into room (KATI, ROOM_NUMBER, NR_PEOPLE, CMIMI, AIR_CONDITIONER, INTERNET, OCCUPIED, REQUESTED_BY) values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = createStatementToInsertRoom(room, sql, requestedBy);
		return statement.executeUpdate();
	}

	@Override
	public void acceptRequest(int roomId, int roomNr) throws SQLException {
		String updateRejected = "update room set OCCUPIED = -1 where ROOM_NUMBER = ?";
		PreparedStatement statement = getPreparedStatement(updateRejected);
		statement.setInt(1, roomNr);
		statement.executeUpdate();

		String updateAccepted = "update room set OCCUPIED = 1 where Id = ?";
		PreparedStatement statementAccepted = getPreparedStatement(updateAccepted);
		statementAccepted.setInt(1, roomId);
		statementAccepted.executeUpdate();

	}

	@Override
	public void freeRoom(int roomId, int roomNr) throws SQLException {
		String updateOcc = "update room set OCCUPIED = 0, REQUESTED_BY = NULL where ROOM_NUMBER = ?";
		PreparedStatement statement = getPreparedStatement(updateOcc);
		statement.setInt(1, roomNr);
		statement.executeUpdate();

		String sqlDel = "delete from room where ROOM_NUMBER = ? and Id <> ?";
		PreparedStatement statementAccepted = getPreparedStatement(sqlDel);
		statementAccepted.setInt(1, roomNr);
		statementAccepted.setInt(2, roomId);
		statementAccepted.executeUpdate();

	}

	private Room isRoomRequested(int roomId) throws SQLException {
		String sql = "select * from room where id = ? and REQUESTED_BY is not null";
		PreparedStatement statement = getPreparedStatement(sql);
		statement.setInt(1, roomId);
		statement.executeQuery();

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return createRoom(resultSet);
		}
		return null;
	}

	private PreparedStatement createStatementToInsertRoom(Room room, String sql) throws SQLException {
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, room.getKati());
		statement.setInt(2, room.getRoomNumber());
		statement.setInt(3, room.getNrPeople());
		statement.setInt(4, room.getCmimi());
		statement.setInt(5, room.getAirConditioner());
		statement.setInt(6, room.getInternet());
		statement.setInt(7, 0);

		return statement;
	}

	private PreparedStatement createStatementToInsertRoom(Room room, String sql, int requesteBy) throws SQLException {
		PreparedStatement statement = createStatementToInsertRoom(room, sql);
		statement.setInt(8, requesteBy);
		return statement;
	}

}
