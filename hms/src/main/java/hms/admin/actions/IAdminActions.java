package hms.admin.actions;

import java.sql.SQLException;
import java.util.List;

import hms.admin.models.Room;

public interface IAdminActions {
	List<Room> getAllRooms() throws SQLException; 
	int insertRoom(Room room)throws SQLException;
	int editRoom(Room room)throws SQLException;
}
