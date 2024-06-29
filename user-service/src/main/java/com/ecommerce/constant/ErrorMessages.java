package com.ecommerce.constant;


import com.ecommerce.utilities.general.messageService.BaseErrorMessage;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public enum ErrorMessages implements BaseErrorMessage {

    //USER
    NOT_FOUND_USER("Not Found User!"),
    NOT_VALID_FIRST_NAME("Not Valid User First Name!"),
    NOT_VALID_LAST_NAME("Not Valid User Last Name!"),
    NOT_VALID_PHONE_NUMBER("Not Valid Phone Number!"),
    NOT_VALID_EMAIL("Not Valid Email!"),
    NOT_START_ZERO_PHONE_NUMBER("Phone number does not start 0(zero)!"),
    NOT_NULL_PHONE_NUMBER("Phone number cannot be null "),
    ALREADY_EXCEPTION_USER("User already exists!"),
    USER_IS_NOT_ACTIVE("User is not active!"),


    //ADDRESS
    NOT_FOUND_ADDRESS("Not Found Address");

    private final String context;

    ErrorMessages(String context) {
        this.context = context;
    }


    @Override
    public String getMessage() {
        return this.context;
    }
}
