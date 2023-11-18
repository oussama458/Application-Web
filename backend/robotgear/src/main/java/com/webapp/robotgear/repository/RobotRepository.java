package com.webapp.robotgear.repository;

import com.webapp.robotgear.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RobotRepository extends JpaRepository<Robot, Long> {

    List<Robot> findByCategoryNameIgnoreCaseOrderByNameAsc(String categoryName);
    List<Robot> findAllByOrderByNameAsc();
    List<Robot> findByDescriptionIgnoreCaseContaining(String description);


}
