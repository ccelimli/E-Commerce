package com.ecommerce.utilities.exceptions;

import com.ecommerce.utilities.general.messageService.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIsNotActiveException extends BusinessException {

    public UserIsNotActiveException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}