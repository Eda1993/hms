package hms.admin.models;

public class Room {

	private int id;
	private int roomNumber;
	private int kati;
	private int nrPeople;
	private int cmimi;
	private int airConditioner;
	private int internet;
	private int occupied;
	private int requestedBy;

	public Room() {

	}

	public Room(int id, int roomNumber, int kati, int nrPeople, int cmimi, int airConditioner, int internet) {
		this.id = id;
		this.roomNumber = roomNumber;
		this.kati = kati;
		this.nrPeople = nrPeople;
		this.cmimi = cmimi;
		this.airConditioner = airConditioner;
		this.internet = internet;
	}

	public Room(int id, int roomNumber, int kati, int nrPeople, int cmimi, int airConditioner, int internet,
			int occupied, int requestedBy) {
		this(id, roomNumber, kati, nrPeople, cmimi, airConditioner, internet);
		this.occupied = occupied;
		this.requestedBy = requestedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getKati() {
		return kati;
	}

	public void setKati(int kati) {
		this.kati = kati;
	}

	public int getNrPeople() {
		return nrPeople;
	}

	public void setNrPeople(int nrPeople) {
		this.nrPeople = nrPeople;
	}

	public int getCmimi() {
		return cmimi;
	}

	public void setCmimi(int cmimi) {
		this.cmimi = cmimi;
	}

	public int getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(int airConditioner) {
		this.airConditioner = airConditioner;
	}

	public int getInternet() {
		return internet;
	}

	public void setInternet(int internet) {
		this.internet = internet;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public int getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(int requestedBy) {
		this.requestedBy = requestedBy;
	}

	@Override
	public String toString() {
		return "Room [kati=" + kati + ", nrPeople=" + nrPeople + ", cmimi=" + cmimi + ", airConditioner="
				+ airConditioner + ", internet=" + internet + "]";
	}
}
