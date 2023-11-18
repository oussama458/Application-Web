package com.webapp.robotgear.repository;

import com.webapp.robotgear.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByRobotNameIgnoreCase(String robotName);
    List<Component> findByPowerIgnoreCase(String powerType);


}
