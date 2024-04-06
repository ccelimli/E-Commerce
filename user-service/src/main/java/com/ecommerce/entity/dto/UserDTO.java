package com.ecommerce.entity.dto;

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
    String address,
    String postCode
){
}
