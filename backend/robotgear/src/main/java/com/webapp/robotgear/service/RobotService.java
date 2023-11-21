package com.webapp.robotgear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.robotgear.model.Category;
import com.webapp.robotgear.model.Robot;
import com.webapp.robotgear.repository.CategoryRepository;
import com.webapp.robotgear.repository.RobotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    @Autowired
    private RobotRepository robotRepository;

    @Autowired
  private CategoryRepository categoryRepository;


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
    public Robot updateRobot(Long robotId, String name, Long categoryId) {
        Robot existingRobot = robotRepository.findById(robotId)
                .orElseThrow(() -> new RuntimeException("Robot not found"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingRobot.setName(name);
        existingRobot.setCategory(category);

        // Additional business logic...

        return robotRepository.save(existingRobot);
    }
   /* @Transactional
    public void deleteRobot(Long robotId) {
        Robot robot = robotRepository.findById(robotId)
                .orElseThrow(() -> new RuntimeException("Robot not found"));

        robotRepository.delete(robot);
    }
    public List<Robot> getRobotsByCategory(String categoryName) {
        return robotRepository.findByCategoryNameIgnoreCaseOrderByName(categoryName);
    }
    @Transactional(readOnly = true)
    public List<Robot> searchRobots(String keyword) {
        return robotRepository.findByNameIgnoreCaseContaining(keyword, keyword);
    }*/

    /*@Transactional(readOnly = true)
    public List<Robot> filterRobotsByCategory(String categoryName) {
        return robotRepository.findByCategoryNameIgnoreCase(categoryName);
    }*/

    /*public List<RobotThumbnailModel> getAllRobotThumbnails() {
        // Implement logic to retrieve thumbnail information from the repository
        return null;
    }*/
    public Robot saveRobot(Robot robot) {
        return robotRepository.save(robot);
    }
}

