package com.webapp.robotgear.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		Path assetsDir = Paths.get("./src/main/resources/static/assets");
		String assetsPath = assetsDir.toFile().getAbsolutePath();
	    registry.addResourceHandler("/assets/**").addResourceLocations("file:/" + assetsPath + "/");
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");


	}

}
