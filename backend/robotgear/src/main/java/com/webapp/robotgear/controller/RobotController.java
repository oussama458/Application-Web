package com.webapp.robotgear.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.webapp.robotgear.model.Robot;
import com.webapp.robotgear.repository.RobotRepository;
import com.webapp.robotgear.service.RobotService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RobotController {

	@Autowired
	RobotService robotService;
	RobotRepository robotRepository;

	@GetMapping("/robots")
	public ResponseEntity<List<Robot>> getAllRobots(@RequestParam(required = false) String name) {
		try {
			List<Robot> robots = new ArrayList<Robot>();

			if (name == null)
				robotService.getAllRobots().forEach(robots::add);
			else
				robotService.getRobotByName(name).forEach(robots::add);

			if (robots.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(robots, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/robots/{id}")
	public ResponseEntity<Robot>getRobotById(@PathVariable("id") long id) {
		Optional<Robot> robotData = robotService.getRobotById(id);

		if (robotData.isPresent()) {
			return new ResponseEntity<>(robotData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/robots")
	public ResponseEntity<Robot> createRobot(@RequestBody Robot robot) {
		try {
			Robot _robot = robotRepository
					.save(new Robot(robot.getName(), robot.getWidth(), robot.getHeight(), 
							robot.getLength(), robot.getWeight(),robot.getSpeed(), robot.getDescription(), robot.getimagePath() ));
			return new ResponseEntity<>(_robot, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/*@PutMapping("/robots/{id}")
	public ResponseEntity<Robot> updateRobot(@PathVariable("id") long id, @RequestBody Robot robot) {
		Optional<Robot> robotData = robotRepository.findById(id);

		if (robotData.isPresent()) {
			Robot _robot = robotData.get();
			_robot.setName(robot.getName());
			_robot.setDescription(robot.getDescription());
			/*_robot.setPublished(robot.isPublished());
			return new ResponseEntity<>(robotRepository.save(_robot), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/robots/{id}")
	public ResponseEntity<HttpStatus> deleteRobot(@PathVariable("id") long id) {
		try {
			robotRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/robots")
	public ResponseEntity<HttpStatus> deleteAllRobots() {
		try {
			robotRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}*/

	/*@GetMapping("/robots/published")
	public ResponseEntity<List<Robot>> findByPublished() {
		try {
			List<Robot> robots = robotRepository.findByPublished(true);

			if (robots.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(robots, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

}