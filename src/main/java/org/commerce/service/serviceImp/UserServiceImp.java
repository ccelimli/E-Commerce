package org.commerce.service.serviceImp;

import org.commerce.model.User;
import org.commerce.model.dto.Request.CreateUserRequest;
import org.commerce.model.dto.Request.UpdateUserRequest;
import org.commerce.model.dto.Response.GetAllUserResponse;
import org.commerce.model.dto.Response.GetUserByIdResponse;
import org.commerce.repository.UserRepository;
import org.commerce.service.constant.message;
import org.commerce.service.service.UserService;
import org.commerce.utilities.exception.userException.UserNotFoundException;
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
        try {
            User user = this._modelMapperService
                    .forRequest()
                    .map(createUserRequest, User.class);
            this._userRepository.save(user);

            GetUserByIdResponse getUserByIdResponse = this._modelMapperService
                    .forResponse()
                    .map(user, GetUserByIdResponse.class);

            return new SuccessDataResult<>(message.UserAdded.getMessage(), getUserByIdResponse);
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
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
            User user=this.findUserById(id);

            GetUserByIdResponse getUserByIdResponse = this._modelMapperService
                    .forResponse()
                    .map(user, GetUserByIdResponse.class);

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
            return new ErrorResult(message.UserDeleted.getMessage());
        } catch (Exception error) {
            return new ErrorResult(error.getMessage());
        }
    }

    @Override
    public DataResult<GetUserByIdResponse> updateUser(Long id,UpdateUserRequest updateUserRequest) {
        try {
            User user=this.findUserById(id);
            User updatedUser = this._modelMapperService
                    .forRequest()
                    .map(updateUserRequest, User.class);
            updatedUser.setId(user.getId());
            updatedUser.setEmail(user.getEmail());
            this._userRepository.save(updatedUser);

            GetUserByIdResponse getUserByIdResponse = this._modelMapperService
                    .forResponse()
                    .map(updatedUser, GetUserByIdResponse.class);

            return new SuccessDataResult<>(message.UserUpdated.getMessage(), getUserByIdResponse);
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    private User findUserById(Long id){
        return this._userRepository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException("User could not be found by following id: "+id));
    }
}