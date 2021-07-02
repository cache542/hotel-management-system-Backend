package com.hms.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "room_generator")
	private int roomId;
	private String roomtype;
	private String bedType;
	private int noOfBeds;
	private int roomRate;
	private boolean isActive;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int roomId, String roomtype, String bedType, int noOfBeds, int roomRate, boolean isActive,
			List<Booking> booking) {
		super();
		this.roomId = roomId;
		this.roomtype = roomtype;
		this.bedType = bedType;
		this.noOfBeds = noOfBeds;
		this.roomRate = roomRate;
		this.isActive = isActive;
		this.booking = booking;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public int getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(int roomRate) {
		this.roomRate = roomRate;
	}

	public boolean getisActive() {
		return isActive;
	}

	public void setisActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

}
