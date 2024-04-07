package com.ecommerce.utilities.helper.friendlyMessage;

import com.ecommerce.entity.enums.Language;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Slf4j
@UtilityClass
public class FriendlyMessageUtils {
    private static final String RESOURCE_BUNDLE_NAME="FriendlyMessage";
    private static final String SPECIAL_CHARACTER="__";

    public static String getFriendlyMessage(Language language, FriendlyMessageCode friendlyMessageCode){
        String messageKey=null;
        try {
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            messageKey = friendlyMessageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + friendlyMessageCode;
            return resourceBundle.getString(messageKey);
        }catch (MissingResourceException missingResourceException){
            log.error("Friendly message not found for key: {}", messageKey);
            return null;
        }
    }
}
