package com.ecommerce.controller.contract;

import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.request.UserSaveRequest;
import com.ecommerce.entity.request.UserUpdateRequest;
import com.ecommerce.utilities.general.entity.RestResponse;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface UserControllerContact
{
    RestResponse<UserDTO> register(UserSaveRequest userSaveRequest);
    UserDTO updateUser(UserUpdateRequest userUpdateRequest);
    String deleteUser(Long id);
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO active(Long id);
    UserDTO deactive(Long id);
    List<UserDTO> findAllOfDeactives();
}
