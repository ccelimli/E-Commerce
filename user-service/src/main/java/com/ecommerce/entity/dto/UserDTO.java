package com.ecommerce.entity.dto;

import com.ecommerce.constant.CountryCode;
import com.ecommerce.entity.enums.Gender;

import java.util.List;

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
        List<AddressDTO> addressDTOList
        Gender gender
){
}
