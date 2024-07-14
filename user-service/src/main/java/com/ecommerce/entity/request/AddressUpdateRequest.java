package com.ecommerce.entity.request;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record AddressUpdateRequest(
        Long id,
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
