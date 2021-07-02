package com.hms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.models.RoomService;
import com.hms.services.IroomServiceService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/roomService")
public class RoomServiceController {

	@Autowired
	private IroomServiceService roomServiceService;
	
	@PostMapping("/")
	public RoomService addRoomService(@RequestBody RoomService roomService) {
		return this.roomServiceService.addRoomService(roomService);
	}
	
}
