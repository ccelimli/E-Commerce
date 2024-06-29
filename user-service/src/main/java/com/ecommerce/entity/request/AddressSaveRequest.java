package com.ecommerce.entity.request;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record AddressSaveRequest(
        Long userId,
        String address,
        String district,
        String city,
        String country,
        String postCode
){}
