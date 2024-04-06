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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
