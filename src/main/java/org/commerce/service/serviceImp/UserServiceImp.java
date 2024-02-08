package org.commerce.service.serviceImp;

import org.commerce.model.User;
import org.commerce.model.dto.Request.CreateUserRequest;
import org.commerce.model.dto.Request.UpdateUserRequest;
import org.commerce.model.dto.Response.GetAllUserResponse;
import org.commerce.model.dto.Response.GetUserByIdResponse;
import org.commerce.repository.UserRepository;
import org.commerce.service.constant.Message;
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

            return new SuccessDataResult<>(Message.UserAdded.getMessage(), getUserByIdResponse);
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

            return new SuccessDataResult<>(Message.UsersListed.getMessage(), getAllUserResponseList);
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<GetUserByIdResponse> getUserByEmail(String email) {
        try {
            User user = this.findUserByEmail(email);

            GetUserByIdResponse getUserByIdResponse = this._modelMapperService
                    .forResponse()
                    .map(user, GetUserByIdResponse.class);

            return new SuccessDataResult<>(Message.UserListed.getMessage(), getUserByIdResponse);
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
            return new ErrorResult(Message.UserDeleted.getMessage());
        } catch (Exception error) {
            return new ErrorResult(error.getMessage());
        }
    }

    @Override
    public DataResult<GetUserByIdResponse> updateUser(String email, UpdateUserRequest updateUserRequest) {
        try {
            User user = this.findUserByEmail(email);
            User updatedUser = this._modelMapperService
                    .forRequest()
                    .map(updateUserRequest, User.class);
            updatedUser.setId(user.getId());
            updatedUser.setEmail(user.getEmail());
            this._userRepository.save(updatedUser);

            GetUserByIdResponse getUserByIdResponse = this._modelMapperService
                    .forResponse()
                    .map(updatedUser, GetUserByIdResponse.class);

            return new SuccessDataResult<>(Message.UserUpdated.getMessage(), getUserByIdResponse);
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    private User findUserByEmail(String email) {
        return this._userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User couldn't be found by following email: " + email));
    }
}