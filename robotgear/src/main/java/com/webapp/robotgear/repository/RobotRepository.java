package com.webapp.robotgear.repository;

import com.webapp.robotgear.model.Robot;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot, Long> {
	List<Robot> findByNameContainingIgnoreCase(String name);
	Optional<Robot> findById(Long id);
	List<Robot> findAllById(Long id);
}
