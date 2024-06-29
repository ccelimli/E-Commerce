package com.ecommerce.controller.contract.impl;

import com.ecommerce.service.UserEntityService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@ExtendWith(MockitoExtension.class)
class UserControllerContractImplTest {
    @Mock
    private UserEntityService userEntityService;
    @InjectMocks
    private UserControllerContractImpl userControllerContractImp;

    @Test
    public void shouldUserFindAll(){
        //Given

    }

}