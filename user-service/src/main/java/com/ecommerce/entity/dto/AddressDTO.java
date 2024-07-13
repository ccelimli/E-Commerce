package com.ecommerce.entity.dto;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record AddressDTO(
        Long id,
        Long userId,
        String doorNo,
        String floorNo,
        String buildingNo,
        String street,
        String district,
        String city,
        String country,
        String postCode,
        String description
) {}
