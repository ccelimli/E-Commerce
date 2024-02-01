package org.commerce.controller;

import org.commerce.model.dto.Request.CreateUserRequest;
import org.commerce.model.dto.Request.UpdateUserRequest;
import org.commerce.model.dto.Response.GetAllUserResponse;
import org.commerce.model.dto.Response.GetUserByIdResponse;
import org.commerce.service.service.UserService;
import org.commerce.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserService _userService;

    @Autowired
    public UserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<GetAllUserResponse>>> getAllUser(){
        return ResponseEntity.ok(_userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<GetUserByIdResponse>> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(_userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<DataResult<GetUserByIdResponse>> createUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(_userService.createUser(createUserRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<GetUserByIdResponse>> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(_userService.updateUser(updateUserRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deactiveUser(@PathVariable("id") Long id){
        _userService.deactiveUser(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        _userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
