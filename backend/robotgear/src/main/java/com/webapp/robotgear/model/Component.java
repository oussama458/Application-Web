package com.webapp.robotgear.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Components")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "robot_id")
    private Robot robot;

    @Column(name = "core", columnDefinition = "TEXT")
    private String core;

    @Column(name = "software", columnDefinition = "TEXT")
    private String software;

    @Column(name = "power", columnDefinition = "TEXT")
    private String power;

    @Column(name = "sensors", columnDefinition = "TEXT")
    private String sensors;

    @Column(name = "actuators", columnDefinition = "TEXT")
    private String actuators;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getActuators() {
        return actuators;
    }

    public void setActuators(String actuators) {
        this.actuators = actuators;
    }
}
