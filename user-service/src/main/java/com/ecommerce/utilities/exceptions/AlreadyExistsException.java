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
@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class AlreadyExistsException extends BusinessException{
    public AlreadyExistsException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
