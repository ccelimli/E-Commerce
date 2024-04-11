package com.ecommerce.entity.dto;

import com.ecommerce.constant.CountryCode;
import com.ecommerce.entity.enums.Gender;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record UserDTO (
        Long id,
        String firstName,
        String middleName,
        String lastName,
        String phoneNumber,
        String email,
        String username,
        String password,
        String city,
        String district,
        String address,
        String postCode,
        Gender gender
){
}
