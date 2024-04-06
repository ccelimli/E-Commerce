package com.ecommerce.constant;

import lombok.Getter;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Getter
public enum RegexConstants {

    EMAIL_REGEX("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"),
    FIRST_NAME_LAST_NAME_REGEX("^[a-zA-ZçÇğĞıİöÖşŞüÜ]+$"),
    PHONE_NUMBER_REGEX("^[1-9]\\d{9,}$");

    private final String context;

    RegexConstants(String context) {
        this.context = context;
    }

}