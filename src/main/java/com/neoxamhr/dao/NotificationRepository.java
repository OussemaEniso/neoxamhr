package com.neoxamhr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

	@Query("select n from Notification n where n.empl.idEmpl=?1")
	List<Notification> getNotif(int id);

}
