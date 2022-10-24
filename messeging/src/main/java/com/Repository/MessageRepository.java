package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Modele.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	

}
