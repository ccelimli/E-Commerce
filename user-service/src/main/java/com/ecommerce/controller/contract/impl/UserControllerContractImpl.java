package com.ecommerce.controller.contract.impl;

import com.ecommerce.controller.contract.UserControllerContact;
import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.request.UserSaveRequest;
import com.ecommerce.entity.request.UserUpdateRequest;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContact {

    private final UserService userService;

    @Override
    public UserDTO register(UserSaveRequest userSaveRequest) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        return "";
    }

    @Override
    public List<UserDTO> findAll() {
        return List.of();
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO active(Long id) {
        return null;
    }

    @Override
    public UserDTO deactive(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> findAllOfDeactives() {
        return List.of();
    }
}
