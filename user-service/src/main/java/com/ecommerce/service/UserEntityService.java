package com.ecommerce.service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.utilities.general.service.BaseEntityService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
public class UserEntityService extends BaseEntityService<User, UserRepository>{
    protected UserEntityService(UserRepository repository) {
        super(repository);
    }

    public User findByUsernameAndEmail(String username, String email){
        return this.getRepository().findByUsernameAndEmail(username,email);
    }

    public void changeStatusToActive(Long id){
        this.getRepository().changeStatusToActive(id);
    }

    public void changeStatusToDeactive(Long id){
        this.getRepository().changeStatusToDeactive(id);
    }

}
