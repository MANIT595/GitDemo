package com.manikanta.microservices.project.UserService.Service;

import com.manikanta.microservices.project.UserService.DTO.UserDTO;
import com.manikanta.microservices.project.UserService.Entity.User;

import java.util.List;

public interface UserService {
//    UserDTO saveEmployee(UserDTO employeeDto);
//
//    UserDTO getEmployeeById(Long employeeId);

    List<UserDTO> getUsers();

    UserDTO getUser(Long userId);

    void deleteUser(Long userId);

    void addUser(User user);
}
