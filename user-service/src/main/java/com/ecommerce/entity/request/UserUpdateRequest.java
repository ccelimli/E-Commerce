package com.ecommerce.entity.request;

import com.ecommerce.entity.enums.Gender;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record UserUpdateRequest(
        Long id,
        String firstName,
        String middleName,
        String lastName,
        String countryCode,
        String phoneNumber,
        String email,
        String username,
        String password,
        String address,
        String postCode,
        Gender gender
) {
}
