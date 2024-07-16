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
    RestResponse<UserDTO> register(UserSaveRequest userSaveRequest) throws Exception;
    RestResponse<UserDTO> updateUser(UserUpdateRequest userUpdateRequest) throws Exception;
    RestResponse<String> deleteUser(Long id) throws Exception;
    RestResponse<List<UserDTO>> findAll() throws Exception;
    RestResponse<UserDTO> findById(Long id) throws Exception;
    RestResponse<UserDTO> active(Long id) throws Exception;
    RestResponse<UserDTO> deactive(Long id) throws Exception;
    RestResponse<List<UserDTO>> findAllOfDeactives() throws Exception;
}
