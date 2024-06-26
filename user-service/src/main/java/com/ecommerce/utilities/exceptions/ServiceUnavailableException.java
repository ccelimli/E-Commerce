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
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends BusinessException {
    public ServiceUnavailableException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }

}
