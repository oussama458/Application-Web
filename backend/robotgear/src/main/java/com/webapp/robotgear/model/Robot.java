package com.webapp.robotgear.model;



import jakarta.persistence.*;

@Entity
@Table(name = "Robots")
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "robot_id",updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    @Column(name = "length")
    private Double length;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "speed")
    private Double speed;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "image_path")
    private String imagePath;
    

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




	public Robot() {
		super();
		
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getimagePath() {
    	return imagePath;
    }
    
    
    public void setimagePath(String imagePath) {
    	this.imagePath = imagePath;
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
    
    @Transient
    public String getRobotImagePath() {
    	if (imagePath == null || id ==null) return null;
    	return "/assets/Robot-Images/" + id + "/" + imagePath;
    }
    
 
}
