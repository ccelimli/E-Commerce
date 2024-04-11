package com.ecommerce.service.mapper;

import com.ecommerce.entity.User;
import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.request.UserSaveRequest;
import com.ecommerce.entity.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target="status", constant = "ACTIVE")
    @Mapping(target = "phoneNumber", expression = "java(userSaveRequest.countryCode().getContext() + userSaveRequest.phoneNumber())")
    User convertToEntity(UserSaveRequest userSaveRequest);

    UserDTO convertToDTO(User user);
    List<UserDTO> convertToDTOs(List<User> users);

    @Mapping(target = "phoneNumber", expression = "java(userUpdateRequest.countryCode().getContext() + userUpdateRequest.phoneNumber())")
    User updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
