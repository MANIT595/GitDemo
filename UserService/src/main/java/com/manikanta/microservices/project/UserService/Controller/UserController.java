package com.manikanta.microservices.project.UserService.Controller;

import com.manikanta.microservices.project.UserService.DTO.UserResponse;
import com.manikanta.microservices.project.UserService.DTO.UserDTO;
import com.manikanta.microservices.project.UserService.Entity.User;
import com.manikanta.microservices.project.UserService.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "User REST API",
        description = "User REST API to implement the CRUD operations"
)
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Get ALL Users",
            description = "Get all the Users Found in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Got All Users 200"
    )
    @GetMapping()
    public UserResponse getUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "pageSortBy", defaultValue = "userId", required = false) String pageSortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        return userService.getUsers(pageNo,pageSize,pageSortBy,sortDir);

    }

    @Operation(
            summary = "Get User By Id",
            description = "Get the User By Id Found in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Got User with id 200"
    )
    @GetMapping("{user-id}")
    public UserDTO getUserById(@PathVariable("user-id") Long id) throws Exception {
        return userService.getUser(id);
    }

    @Operation(
            summary = "Delete User",
            description = "Delete the User From the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Deleted the User 200"
    )
    @DeleteMapping("{user-id}")
    public void deleteUserById(@PathVariable("user-id") Long id) {
        userService.deleteUser(id);
    }

    @Operation(
            summary = "Add the User",
            description = "Add the User into the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Added the User 200"
    )
    @PostMapping
    public void addUser(@RequestBody @Valid User user){
        userService.addUser(user);
    }


}