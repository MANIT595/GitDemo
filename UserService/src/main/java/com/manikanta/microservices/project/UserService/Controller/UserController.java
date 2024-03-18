package com.manikanta.microservices.project.UserService.Controller;

import com.manikanta.microservices.project.UserService.DTO.UserDTO;
import com.manikanta.microservices.project.UserService.Entity.User;
import com.manikanta.microservices.project.UserService.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDTO> getUsers() {
        return userService.getUsers();

    }

    @GetMapping("{user-id}")
    public UserDTO getUserById(@PathVariable("user-id") Long id) {
    return userService.getUser(id);
    }

    @DeleteMapping("{user-id}")
    public void deleteUserById(@PathVariable("user-id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}