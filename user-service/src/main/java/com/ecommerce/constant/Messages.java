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
    //Address
    ADDRESS_DELETED("Removed Address From Database"),

    //System
    SUCCESSFULLY_DEACTIVE("Successfully Deactive."),
    SUCCESSFULLY_ACTIVE("Successfully Active."),

    //User
    USER_ADDED("User Added To Database."),
    USER_DELETED("Removed User From Database"),
    USER_LISTED("User Listed."),
    USERS_LISTED("Users Listed."),
    USER_UPDATED("Updated Infos of User.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

}
