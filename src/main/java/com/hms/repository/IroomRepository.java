package com.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hms.models.Room;

@Repository
public interface IroomRepository extends JpaRepository<Room, Integer> {
	public Room findByRoomId(int i);

	public List<Room> findByIsActive(boolean b);
}