package com.hms.services;

import java.util.List;

import com.hms.models.Room;

public interface IroomService {

	public Room addRoom(Room room);

	public void deleteRoom(int roomId) throws Exception;

	public List<Room> findAll();

	public List<Room> getActiveRoom();

	public Room updateRoom(Room updatedRoom, int id);

	public Room find(int id);

}
