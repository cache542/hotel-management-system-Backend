package com.hms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.models.Room;
import com.hms.services.IroomService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/room")
public class RoomController {
	Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private IroomService roomService;
	
	//add rooms
	@PostMapping("/")
	public Room addRoom(@RequestBody Room room) {
		return this.roomService.addRoom(room);
	}
	
	// get all rooms
	@GetMapping("/getAll")
	public List<Room> findAll(){
		return this.roomService.findAll();
	}
	
	//deleting room based on id
		@DeleteMapping("/deleteRoom/{id}")
		public void deleteRoom(@PathVariable("id") int roomId ) throws Exception {
			try {
			roomService.deleteRoom(roomId);
			logger.info("Room deleted successfully");
			}catch(Exception e) {
				logger.error("Exception occurred No Room found");
			}
		}
	//get list of rooms on status
	//implement here
		@GetMapping("/Active")
		public List<Room> getByRoomStatus(){
			return this.roomService.getActiveRoom();
		}
	
	//update rooms
		@PutMapping("/updateRoom/{id}")
		public Room modifyRoom(@PathVariable int id,@RequestBody Room updatedRoom) {
			return roomService.updateRoom(updatedRoom,id);
		}
		
		//get room by id
		@GetMapping("/getRoom/{id}")
		public Room find(@PathVariable int id){
			return this.roomService.find(id);
		}
}
