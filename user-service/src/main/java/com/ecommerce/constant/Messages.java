package com.ecommerce.constant;


import lombok.Getter;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */

@Getter
public enum Messages {
    USER_DELETED("Removed User from database");
    private final String message;

    Messages(String message) {
        this.message = message;
    }

}
