package com.webapp.robotgear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.webapp.robotgear.model.Robot;
import com.webapp.robotgear.repository.RobotRepository;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    @Autowired
    private RobotRepository robotRepository;

    

    @Transactional(readOnly = true)
    public List<Robot> getAllRobots() {
        return robotRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Robot> getRobotById(Long robotId) {
        return robotRepository.findById(robotId);
     
    }
    @Transactional(readOnly = true)
    public List<Robot> getRobotByName(String robotName) {
        return robotRepository.findByNameContainingIgnoreCase(robotName);
        }
    
    
    @Transactional
    public void saveRobot(MultipartFile file,
    		String name,
    		Double width,
    		Double height,
    		Double length,
    		Double weight,
    		Double speed,
    		String description,
    		String imagePath,
    		String core,
    		String software,
    		String power,
    		String sensors,
			String actuators) throws NoSuchAlgorithmException, IOException {
    	Robot r = new Robot();
    	r.setName(name);
    	r.setWidth(width);
    	r.setHeight(height);
    	r.setLength(length);
    	r.setWeight(weight);
    	r.setSpeed(speed);
    	r.setDescription(description);
    	r.setCore(core);
    	r.setSoftware(software);
    	r.setPower(power);
    	r.setSensors(sensors);
    	r.setActuators(actuators);
    	

    	robotRepository.save(r);
    	
      
    }
    @Transactional
    public void save(Robot robot) {
    	robotRepository.save(robot);
    }

}

