package com.tour.user.controller;

import com.tour.user.domain.service.UserService;
import com.tour.user.dto.UserDTO;
import com.tour.user.utility.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody UserDTO userDTO) {
        String userRegistered = userService.registerUser(userMapper.userDTOToUser(userDTO));
        return ResponseEntity.ok(userRegistered);
    }

    @GetMapping
    public String message(){
        return "Connection usuarios Azure";
    }

}
