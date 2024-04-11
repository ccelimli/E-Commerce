package com.ecommerce.controller.contract.impl;

import com.ecommerce.constant.ErrorMessages;
import com.ecommerce.constant.Messages;
import com.ecommerce.controller.contract.UserControllerContact;
import com.ecommerce.entity.User;
import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.enums.Status;
import com.ecommerce.entity.request.UserSaveRequest;
import com.ecommerce.entity.request.UserUpdateRequest;
import com.ecommerce.service.UserEntityService;
import com.ecommerce.service.mapper.UserMapper;
import com.ecommerce.utilities.exceptions.AlreadyExistsException;
import com.ecommerce.utilities.exceptions.ItemNotFoundException;
import com.ecommerce.utilities.helper.BusinessRules.RegularExpression;
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

    private final UserEntityService userEntityService;

    @Override
    public UserDTO register(UserSaveRequest userSaveRequest) {
        RegularExpression.controlSaveRequest(userSaveRequest);
        this.checkExistUser(userSaveRequest.username(),userSaveRequest.email());
        User user= UserMapper.INSTANCE.convertToEntity(userSaveRequest);
        user=this.userEntityService.save(user);
        return UserMapper.INSTANCE.convertToDTO(user);
    }

    @Override
    public UserDTO updateUser(UserUpdateRequest userUpdateRequest) {
        User user=this.userEntityService.findByIdWithControl(userUpdateRequest.id());
        RegularExpression.controlUpdateRequest(userUpdateRequest);
        UserMapper.INSTANCE.updateUser(user,userUpdateRequest);
        return UserMapper.INSTANCE.convertToDTO(user);
    }

    @Override
    public String deleteUser(Long id) {
        User user= this.userEntityService.findByIdWithControl(id);
        this.userEntityService.delete(user);
        return Messages.USER_DELETED.getMessage();
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> userList= this.userEntityService.findAll()
                .stream()
                .filter(user -> user.getStatus() == Status.ACTIVE)
                .toList();
        return UserMapper.INSTANCE.convertToDTOs(userList);
    }

    @Override
    public UserDTO findById(Long id) {
        User user=this.userEntityService.findByIdWithControl(id);
        if (user.getStatus()==Status.DEACTIVE){
            throw new ItemNotFoundException(ErrorMessages.NOT_FOUND_USER);
        }
        return UserMapper.INSTANCE.convertToDTO(user);
    }

    @Override
    public UserDTO active(Long id) {
        User user= this.userEntityService.findByIdWithControl(id);
        this.userEntityService.changeStatusToActive(user.getId());
        return UserMapper.INSTANCE.convertToDTO(user);
    }

    @Override
    public UserDTO deactive(Long id) {
        User user= this.userEntityService.findByIdWithControl(id);
        this.userEntityService.changeStatusToDeactive(user.getId());
        return UserMapper.INSTANCE.convertToDTO(user);
    }

    @Override
    public List<UserDTO> findAllOfDeactives() {
        List<User> userList= this.userEntityService.findAll()
                .stream()
                .filter(user -> user.getStatus() == Status.DEACTIVE)
                .toList();
        return UserMapper.INSTANCE.convertToDTOs(userList);
    }

    private void checkExistUser(String username, String email){
        User user= this.userEntityService.findByUsernameAndEmail(username, email);
        if (user!=null){
            throw new AlreadyExistsException(ErrorMessages.ALREADY_EXCEPTION_USER);
        }
    }
}
