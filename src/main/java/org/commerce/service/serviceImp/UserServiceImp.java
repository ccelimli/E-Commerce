package org.commerce.service.serviceImp;

import org.commerce.model.User;
import org.commerce.model.dto.Request.CreateUserRequest;
import org.commerce.model.dto.Request.UpdateUserRequest;
import org.commerce.model.dto.Response.GetAllUserResponse;
import org.commerce.model.dto.Response.GetUserByIdResponse;
import org.commerce.repository.UserRepository;
import org.commerce.service.constant.message;
import org.commerce.service.service.UserService;
import org.commerce.utilities.mapper.ModelMapperService;
import org.commerce.utilities.results.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository _userRepository;
    private final ModelMapperService _modelMapperService;

    public UserServiceImp(UserRepository userRepository, ModelMapperService modelMapperService) {
        this._userRepository = userRepository;
        this._modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<GetUserByIdResponse> createUser(CreateUserRequest createUserRequest) {
        return null;
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAllUsers() {
        try {
            List<GetAllUserResponse> getAllUserResponseList = this._userRepository
                    .findAll()
                    .stream()
                    .map(user -> this._modelMapperService
                            .forResponse()
                            .map(user, GetAllUserResponse.class))
                    .toList();

            return new SuccessDataResult<>(message.UsersListed.getMessage(), getAllUserResponseList);
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<GetUserByIdResponse> getUserById(Long id) {
        try {
            GetUserByIdResponse getUserByIdResponse = this._modelMapperService
                    .forResponse()
                    .map(this._userRepository.findById(id), GetUserByIdResponse.class);
            return new SuccessDataResult<>(message.UserListed.getMessage(), getUserByIdResponse);
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public Result deactiveUser(Long id) {
        return null;
    }

    @Override
    public Result deleteUser(Long id) {
        try {
            this._userRepository.deleteById(id);
            return new ErrorResult();
        }catch (Exception error){
            return new ErrorResult(error.getMessage());
        }
    }

    @Override
    public DataResult<GetUserByIdResponse> updateUser(UpdateUserRequest updateUserRequest) {
        try {
            User user=this._modelMapperService.forRequest().map(updateUserRequest,User.class);
            this._userRepository.save(user);
            GetUserByIdResponse getUserByIdResponse= this._modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
            return new SuccessDataResult<>(message.UserUpdated.getMessage(), getUserByIdResponse);
        }catch (Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }
}