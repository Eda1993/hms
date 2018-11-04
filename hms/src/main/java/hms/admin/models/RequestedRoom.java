package hms.admin.models;

public class RequestedRoom extends Room {
	private String userName;
	private String userSurname;
	
	public RequestedRoom() {
		super();
	}

	public RequestedRoom(String userName, String userSurname) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
	}
	
	public RequestedRoom(Room room) {
		super(room.getId(), room.getRoomNumber(), room.getKati(), room.getNrPeople(), room.getCmimi(), room.getAirConditioner(), 
				room.getInternet(), room.getOccupied(), room.getRequestedBy());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
}