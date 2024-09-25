package com.example.demo.controller;

import com.example.demo.DTO.Request.ApiReponse;
import com.example.demo.entity.User;
import com.example.demo.DTO.Request.UserDTO;
import com.example.demo.DTO.Reponse.UserResponse;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ApiReponse<UserResponse> create(@RequestBody @Valid UserDTO userDTO){
        ApiReponse<UserResponse> response = new ApiReponse<>();
        response.setResult(userService.createUser(userDTO));
        return response;
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO){
        return userService.updateUser(userId, userDTO);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
