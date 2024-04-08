package com.ecommerce.service.impl;

import com.ecommerce.entity.User;
import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import com.ecommerce.utilities.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
public class UserServiceImpl extends BaseEntityService<User, UserRepository> implements UserService {
    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
