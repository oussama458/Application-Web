package com.webapp.robotgear.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.robotgear.Utils.UploadUtils;
import com.webapp.robotgear.service.RobotService;
import com.webapp.robotgear.model.Robot;
import com.webapp.robotgear.repository.RobotRepository;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	
	

	
	@Autowired
	private RobotService robotService;
	
	
	@Autowired
	private RobotRepository robotRepository;
	
	
	@GetMapping({"/", "/home"})
	public String index(Model model) {
		    model.addAttribute("robots", robotService.getAllRobots());
		return "index";
	}
	@GetMapping({"/robot-form"})
	public String robotform() {
		return "robot-form";
	}
	
	@GetMapping({"/robot-details/{id}"})
	public String getRobotDetails(@PathVariable Long id, Model model) {
		robotService.getRobotById(id).ifPresent(o -> model.addAttribute("room", o));
		return "details";
		
	}
	

	
	@PostMapping({"/addRobots"})
	public String saveNewRobot(@ModelAttribute(name = "robot") Robot robot,
			RedirectAttributes ra,			
			@RequestParam(name ="file") MultipartFile multipartfile) throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartfile.getOriginalFilename());
		robot.setimagePath(fileName);
		Robot savedRobot = robotRepository.save(robot);
		
		String uploadDir = "./src/main/resources/static/assets/Robot-Images/" + savedRobot.getId();
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try(InputStream in = multipartfile.getInputStream()){
		Path filePath = uploadPath.resolve(fileName);
		Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save uploaded file" + fileName);
		}
		
		ra.addFlashAttribute("message", "the robot has been saved successfully");
		
		
		
		return "redirect:/";
	}
	
	
}	


