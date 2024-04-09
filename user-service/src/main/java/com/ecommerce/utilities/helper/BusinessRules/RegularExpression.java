package com.ecommerce.utilities.helper.BusinessRules;


import com.ecommerce.constant.RegexConstants;
import com.ecommerce.constant.ErrorMessages;
import com.ecommerce.entity.request.UserSaveRequest;
import com.ecommerce.entity.request.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
public class RegularExpression {

    private static final String FIRST_NAME_LAST_NAME_REGEX = RegexConstants.FIRST_NAME_LAST_NAME_REGEX.getContext();
    private static final String EMAIL_REGEX = RegexConstants.EMAIL_REGEX.getContext();
    private static final String PHONE_NUMBER_REGEX = RegexConstants.PHONE_NUMBER_REGEX.getContext();

    private static boolean controlRequest(String firstName, String lastName, String email, String phoneNumber) {
        if (!Pattern.compile(FIRST_NAME_LAST_NAME_REGEX).matcher(firstName).matches()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_VALID_FIRST_NAME.getMessage());
        }

        if (!Pattern.compile(FIRST_NAME_LAST_NAME_REGEX).matcher(lastName).matches()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_VALID_LAST_NAME.getMessage());
        }

        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_VALID_EMAIL.getMessage());
        }

        if (!Pattern.compile(PHONE_NUMBER_REGEX).matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_VALID_PHONE_NUMBER.getMessage());
        }

        return true;
    }

    public static boolean controlSaveRequest(UserSaveRequest userSaveRequest) {
        return controlRequest(userSaveRequest.firstName(), userSaveRequest.lastName(), userSaveRequest.email(), userSaveRequest.phoneNumber());
    }

    public static boolean controlUpdateRequest(UserUpdateRequest userUpdateRequest) {
        return controlRequest(userUpdateRequest.firstName(), userUpdateRequest.lastName(), userUpdateRequest.email(), userUpdateRequest.phoneNumber());
    }

}
