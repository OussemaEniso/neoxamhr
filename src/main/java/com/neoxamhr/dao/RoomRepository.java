package com.neoxamhr.dao;

import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Room;

public interface RoomRepository extends CrudRepository<Room, Integer>  {

	Room findByName(String room);

}
