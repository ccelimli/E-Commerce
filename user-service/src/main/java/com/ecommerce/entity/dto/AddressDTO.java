package com.ecommerce.entity.dto;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record AddressDTO(
        Long userId,
        String address,
        String district,
        String city,
        String country,
        String postCode
) {}
