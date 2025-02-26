package com.example.demo.temp.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.temp.dto.UserDTO;
import com.example.demo.temp.entity.User;
import com.example.demo.temp.service.tempService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class tempController {

	@Autowired
	tempService tempservice;
	
	Logger log = LoggerFactory.getLogger(tempController.class);
	
	
	@GetMapping(path = "/temp")
	public Object temp() {
		log.info("this is controller");
		return tempservice.timepass();
	}
	
	@PostMapping(path = "/temp")
	public void saveUser(@RequestBody UserDTO userDto) {
		log.info("this is controller");
		tempservice.saveUser(userDto);
		return ;
	}
	
	@DeleteMapping(path ="/temp")
	public void deleteUser(@RequestParam Long id) {
		log.info("this is controller");
		tempservice.deleteUser(id);
		return ;
	}
	
	@PutMapping(path = "/temp")
	public void updateUser(@RequestParam Long id, @RequestBody(required = true) UserDTO userDto) {
		log.info("this is controller");
		tempservice.updateUser(id,userDto);
		return ;
	}
}
