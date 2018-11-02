package hms.commons;

public class UserRoom {
	private int id;
	private int userId;
	private int roomId;

	public UserRoom(int id, int userId, int roomId) {

		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "UserRoom [id=" + id + ", userId=" + userId + ", roomId=" + roomId + "]";
	}

}
