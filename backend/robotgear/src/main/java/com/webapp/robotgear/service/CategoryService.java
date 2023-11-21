package com.webapp.robotgear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.webapp.robotgear.model.Category;
import com.webapp.robotgear.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {

	 static {
	        //Initialize Data
	        Category categoryOne = new Category(1, "Medical", "Contains All Medical Robots");

	        Category categoryTwo = new Category(2, "Spring MVC", "10 Examples");

	        Category categoryThree = new Category(3, "Spring Boot", "6K Students");

	        Category categoryFour = new Category(1, "Maven", "Most popular maven course on internet!");
	        }

}
