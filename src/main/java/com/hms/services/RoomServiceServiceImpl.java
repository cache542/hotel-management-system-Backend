package com.hms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.models.RoomService;
import com.hms.repository.IbookingRepository;
import com.hms.repository.IroomServiceRepository;

@Service
public class RoomServiceServiceImpl implements IroomServiceService {
	
	@Autowired
	public IbookingRepository bookingRepository;
	
	@Autowired
	public IroomServiceRepository roomServiceRepository;

	@Override
	public RoomService addRoomService(RoomService roomService) {
		if(bookingRepository.findByBookingId(roomService.getBooking().getBookingId()) != null){
			return this.roomServiceRepository.save(roomService);
		}
		return null;
	}

}
