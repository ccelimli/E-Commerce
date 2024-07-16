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
import com.ecommerce.utilities.exceptions.UserIsNotActiveException;
import com.ecommerce.utilities.general.entity.RestResponse;
import com.ecommerce.utilities.helper.BusinessRules.RegularExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserControllerContractImpl implements UserControllerContact {

   private final UserEntityService userEntityService;
   private static final Logger logger = LoggerFactory.getLogger(UserControllerContractImpl.class);

   @Override
   public RestResponse<UserDTO> register(UserSaveRequest userSaveRequest) throws Exception {
       try {
           RegularExpression.controlSaveRequest(userSaveRequest);
           this.checkExistUser(userSaveRequest.username(), userSaveRequest.email());
           User user = UserMapper.INSTANCE.convertToEntity(userSaveRequest);
           user = this.userEntityService.save(user);
           return RestResponse.result(UserMapper.INSTANCE.convertToDTO(user), Messages.USER_ADDED.getMessage(), true);
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
   }

   @Override
   public RestResponse<UserDTO> updateUser(UserUpdateRequest userUpdateRequest) throws Exception {
      try {
         User user = this.userEntityService.findByIdWithControl(userUpdateRequest.id());
         if (user.getStatus() == Status.DEACTIVE) {
            logger.warn("The user wanted update is not active! email: {}", userUpdateRequest.email());
            throw new UserIsNotActiveException(ErrorMessages.USER_IS_NOT_ACTIVE);
         }
         RegularExpression.controlUpdateRequest(userUpdateRequest);
         UserMapper.INSTANCE.updateUser(user, userUpdateRequest);
         return RestResponse.result(UserMapper.INSTANCE.convertToDTO(user), Messages.USER_UPDATED.getMessage(), true);
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public RestResponse<String> deleteUser(Long id) throws Exception {
      try {
         User user = this.userEntityService.findByIdWithControl(id);
         this.userEntityService.delete(user);
         return RestResponse.message(Messages.USER_DELETED.getMessage());
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public RestResponse<List<UserDTO>> findAll() throws Exception {
       try {
           List<User> userList = this.userEntityService.findAll()
                   .stream()
                   .filter(user -> user.getStatus() == Status.ACTIVE)
                   .toList();
           return RestResponse.result(UserMapper.INSTANCE.convertToDTOs(userList), Messages.USERS_LISTED.getMessage(), true);
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
   }

   @Override
   public RestResponse<UserDTO> findById(Long id) throws Exception {
      try {
         User user = this.userEntityService.findByIdWithControl(id);
         if (user.getStatus() == Status.DEACTIVE) {
            logger.warn("User not active or do not found id: {}", id);
            throw new ItemNotFoundException(ErrorMessages.NOT_FOUND_USER);
         }
         return RestResponse.result(UserMapper.INSTANCE.convertToDTO(user), Messages.USER_LISTED.getMessage(), true);
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public RestResponse<UserDTO> active(Long id) throws Exception {
       try {
           User user = this.userEntityService.findByIdWithControl(id);
           this.userEntityService.changeStatusToActive(user.getId());
           return RestResponse.result(UserMapper.INSTANCE.convertToDTO(user), Messages.SUCCESSFULLY_ACTIVE.getMessage(), true);
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
   }

   @Override
   public RestResponse<UserDTO> deactive(Long id) throws Exception {
       try {
           User user = this.userEntityService.findByIdWithControl(id);
           this.userEntityService.changeStatusToDeactive(user.getId());
           return RestResponse.result(UserMapper.INSTANCE.convertToDTO(user), Messages.SUCCESSFULLY_DEACTIVE.getMessage(), true);
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
   }

   @Override
   public RestResponse<List<UserDTO>> findAllOfDeactives() throws Exception {
       try {
           List<User> userList = this.userEntityService.findAll()
                   .stream()
                   .filter(user -> user.getStatus() == Status.DEACTIVE)
                   .toList();
           return RestResponse.result(UserMapper.INSTANCE.convertToDTOs(userList), Messages.USERS_LISTED.getMessage(), true);
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
   }

   private void checkExistUser(String username, String email) {
      User user = this.userEntityService.findByUsernameAndEmail(username, email);
      if (user != null) {
          logger.warn(ErrorMessages.ALREADY_EXCEPTION_USER.getMessage());
         throw new AlreadyExistsException(ErrorMessages.ALREADY_EXCEPTION_USER);
      }
   }
}
