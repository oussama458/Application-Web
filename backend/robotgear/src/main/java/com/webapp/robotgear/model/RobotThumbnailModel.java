package com.webapp.robotgear.model;
public class RobotThumbnailModel {

    private Long id;
    private String imageUrl;

    // Getters and setters...
    
    public void setId(Long id) {
    	this.id=id;
    }
    public Long getId() {
    	return id;
    }
    public void setImageUrl(String imageUrl) {
    	this.imageUrl=imageUrl;
    }
    public String getImageUrl() {
    	return imageUrl;
    }
}
