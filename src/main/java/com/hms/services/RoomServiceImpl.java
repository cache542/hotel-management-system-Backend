package com.hms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.models.Room;
import com.hms.repository.IroomRepository;


@Service
public class RoomServiceImpl implements IroomService {
	@Autowired
	private IroomRepository roomRepository;

	// add room
	@Override
	public Room addRoom(Room room) {
		Room local = this.roomRepository.findByRoomId(room.getRoomId());

		if (local != null) {
			System.out.println("Room is already There!!");
		} else {
			System.out.println("Room is not There!!");
			// create room
			local = this.roomRepository.save(room);
		}

		return local;
	}

//delete room
	@Override
	public void deleteRoom(int roomId) throws Exception {
		if (roomRepository.findById(roomId) != null) {
			roomRepository.deleteById(roomId);

		} else {
			throw new Exception("Room is not present!!");
		}
	}

	// get list of all rooms
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	// get room by status
	@Override
	public List<Room> getActiveRoom() {
		// TODO Auto-generated method stub
		return this.roomRepository.findByIsActive(true);
	}

	//update room
	@Override
	public Room updateRoom(Room updatedRoom, int id) {
		Optional<Room> findRoom = roomRepository.findById(id);
		if (findRoom .isPresent()) {
			Room reqRoom= findRoom.get();
			reqRoom.setBedType(updatedRoom.getBedType());
			reqRoom.setRoomRate(updatedRoom.getRoomRate());
			reqRoom.setRoomtype(updatedRoom.getRoomtype());
			reqRoom.setisActive(updatedRoom.getisActive());
		
			return roomRepository.save(reqRoom);
		} else {
			System.out.println("This room doesnot exist!!");
			return null;
		}
		
	}
	
	
	//find by id
	@Override
	public Room find(int id) {
		Optional<Room> findRoom = roomRepository.findById(id);
		if (findRoom .isPresent()) {
			Room reqRoom= findRoom.get();
			return roomRepository.save(reqRoom);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
