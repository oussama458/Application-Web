package com.webapp.robotgear.repository;

import com.webapp.robotgear.model.Robot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot, Long> {
	List<Robot> findByNameContainingIgnoreCase(String name);

}
