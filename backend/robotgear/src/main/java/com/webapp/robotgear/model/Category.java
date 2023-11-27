package com.webapp.robotgear.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;


    // Getters and Setters
    public Category() {
    	
    }

    public Category(Long id, String name, String description) {
    	this.id = id;
    	this.name = name;

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


}
