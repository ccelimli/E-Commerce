package com.ecommerce.entity.request;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record UserSaveRequest(
        String firstName,
        String middleName,
        String lastName,
        String countryCode,
        String phoneNumber,
        String email,
        String username,
        String password,
        String address,
        String postCode
) {
}
