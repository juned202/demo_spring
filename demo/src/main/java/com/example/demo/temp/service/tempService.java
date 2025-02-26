package com.example.demo.temp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.temp.dto.UserDTO;
import com.example.demo.temp.entity.User;
import com.example.demo.temp.reposetries.UserRepository;


@Service
public class tempService {
	
	

	Logger log = LoggerFactory.getLogger(tempService.class);
	
	public List<UserDTO> timepass() {
	    List<User> users = userRepository.findAll();
	    
	    return users.stream()
	                .map(user -> modelMapper.map(user, UserDTO.class)) // Convert User → UserDTO
	                .collect(Collectors.toList()); // Collect as List
	}

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private ModelMapper modelMapper;

    public void saveUser(UserDTO userDto) {
    	// Convert DTO to Entity
        User user = modelMapper.map(userDto, User.class);
         userRepository.save(user);
         return;
    }
    
    public void deleteUser(Long id) {
    	// Convert DTO to Entity
        Optional<User> user = userRepository.findById(id);
         userRepository.delete(user.get());
         return;
    }
    
    public void updateUser(Long id,UserDTO userDto) {
    	// Convert DTO to Entity
        Optional<User> users = userRepository.findById(id);
        User user = modelMapper.map(userDto, User.class);
         userRepository.save(user);
         return;
    }
}
