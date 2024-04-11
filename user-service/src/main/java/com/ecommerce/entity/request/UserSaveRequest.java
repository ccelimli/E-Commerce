package com.ecommerce.entity.request;

import com.ecommerce.constant.CountryCode;
import com.ecommerce.entity.enums.Gender;

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
        CountryCode countryCode,
        String phoneNumber,
        String email,
        String username,
        String password,
        String city,
        String district,
        String address,
        String postCode,
        Gender gender
) {
}
