package com.ecommerce.controller;

import com.ecommerce.controller.contract.UserControllerContact;
import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.request.UserSaveRequest;
import com.ecommerce.entity.request.UserUpdateRequest;
import com.ecommerce.utilities.general.entity.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserControllerContact userControllerContact;

    public UserController(UserControllerContact userControllerContact) {
        this.userControllerContact = userControllerContact;
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> register(@RequestBody UserSaveRequest userSaveRequest) {
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.register(userSaveRequest)));
    }

    @PutMapping
    public ResponseEntity<RestResponse<UserDTO>> updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.updateUser(userUpdateRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.deleteUser(id)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll(){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.findById(id)));
    }

    @PatchMapping("/active/{id}")
    public ResponseEntity<RestResponse<UserDTO>> active(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.active(id)));
    }

    @PatchMapping("/deactive/{id}")
    public ResponseEntity<RestResponse<UserDTO>> deactive(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.deactive(id)));
    }

    @GetMapping("/deactives")
    public ResponseEntity<RestResponse<List<UserDTO>>> findAllOfDeactives(){
        return ResponseEntity.ok(RestResponse.of(this.userControllerContact.findAllOfDeactives()));
    }
}
