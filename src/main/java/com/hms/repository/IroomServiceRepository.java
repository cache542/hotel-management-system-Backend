package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.models.RoomService;

@Repository
public interface IroomServiceRepository extends JpaRepository<RoomService, Integer> {

}
