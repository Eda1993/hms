package hms.admin.actions;

import java.sql.SQLException;
import java.util.List;

import hms.admin.models.RequestedRoom;
import hms.admin.models.Room;

public interface IAdminActions {
	List<Room> getAllRooms() throws SQLException; 
	int insertRoom(Room room)throws SQLException;
	int editRoom(Room room)throws SQLException;
	List<Room> getRooms() throws SQLException; 
	List<RequestedRoom> getRequests() throws SQLException;
	void requestRoom(int roomId, int userId) throws SQLException;
	int insertRoom(Room room, int requestedBy)throws SQLException;
	void acceptRequest(int roomId, int roomNr) throws SQLException;
	void freeRoom(int roomId, int roomNr) throws SQLException;
}
