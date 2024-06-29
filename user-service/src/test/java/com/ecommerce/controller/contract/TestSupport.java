package com.ecommerce.controller.contract;

import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public class TestSupport {
    public static List<UserDTO> generateUser(){
        return IntStream.range(0,5).mapToObj(i->
            new UserDTO(
                    (long) i,
                    "firstname",
                    null,
                    "lastname",
                    "+905458952194",
                    i+"@gmail.com",
                    i+". kullanıcı",
                    "Adana",
                    "Seyhan",
                    "Address",
                    "01010",
                    Gender.MALE)
        ).collect(Collectors.toList());
    }
}
