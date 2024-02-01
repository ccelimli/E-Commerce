package org.commerce.service.service;

import org.commerce.model.dto.Request.CreateUserRequest;
import org.commerce.model.dto.Request.UpdateUserRequest;
import org.commerce.model.dto.Response.GetAllUserResponse;
import org.commerce.model.dto.Response.GetUserByIdResponse;
import org.commerce.utilities.results.DataResult;
import org.commerce.utilities.results.Result;

import java.util.List;

public interface UserService {
    DataResult<GetUserByIdResponse> createUser(CreateUserRequest createUserRequest);
    DataResult<List<GetAllUserResponse>> getAllUsers();
    DataResult<GetUserByIdResponse> getUserById(Long id);
    Result deactiveUser(Long id);
    Result deleteUser(Long id);
    DataResult<GetUserByIdResponse> updateUser(UpdateUserRequest updateUserRequest);
}
