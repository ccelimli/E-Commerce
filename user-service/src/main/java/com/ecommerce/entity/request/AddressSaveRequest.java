package com.ecommerce.entity.request;

import jakarta.persistence.Column;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record AddressSaveRequest(
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
) {
}
