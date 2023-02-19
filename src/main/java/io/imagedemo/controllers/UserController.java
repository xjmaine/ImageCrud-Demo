package io.imagedemo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.imagedemo.models.FileUploadUtil;
import io.imagedemo.models.User;
import io.imagedemo.services.UserService;
//import jakarta.validation.Valid;
import org.springframework.util.StringUtils;


  

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users/new")
	public String userRegister(Model model) {
		User user = new User();
		model.addAttribute("user", user);
	    return "user_form";
	}

	
	@PostMapping("/users/save")
	public String saveUser(User user, @RequestParam("image")MultipartFile multipartFile) throws IOException {
	    if (!multipartFile.isEmpty()) {
	    	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	    	user.setPhotos(fileName);
	    	User savedUser = service.save(user);
	    	String upload = "images/"+user.getId();
	    	
	    	FileUploadUtil.saveFle(upload, fileName, multipartFile);
//	        return "user_form";
	        
	    }else {
	    	if(user.getPhotos().isEmpty()) {
	    		user.setPhotos(null);
	    		service.save(user);
	    	}
	    }
	    
	    // Save the user object to the database
	    service.save(user);
	    
	    return "redirect:/index";
	}


}
