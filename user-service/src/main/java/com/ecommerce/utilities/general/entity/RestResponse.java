package com.ecommerce.utilities.general.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Getter
@Setter
public class RestResponse<T> {

    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;
    private String message;

    public RestResponse(T data,String message, boolean isSuccess){
        this.data = data;
        this.message=message;
        this.isSuccess = isSuccess;
        this.responseDate = LocalDateTime.now();
    }
    public RestResponse(T data, boolean isSuccess){
        this.data = data;
        this.isSuccess = isSuccess;
        this.responseDate = LocalDateTime.now();
    }
    public RestResponse(String message,boolean isSuccess){
        this.message=message;
        this.isSuccess=isSuccess;
        this.responseDate = LocalDateTime.now();
    }
    public RestResponse(boolean isSuccess){
        this.isSuccess=isSuccess;
        this.responseDate = LocalDateTime.now();
    }
    public RestResponse(){
        this.responseDate = LocalDateTime.now();
    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse<>(t, true);
    }

    public static <T> RestResponse<T> error(T t){
        return new RestResponse<>(t, false);
    }

    public static <T> RestResponse<T> errorWithMessage(String message, boolean isSuccess ){
        return new RestResponse<>(message,false);
    }

    public static <T> RestResponse<T> empty(){
        return new RestResponse<>(null, true);
    }
    public static <T> RestResponse<T> message(String message){
        return new RestResponse<>(message, true);
    }

    public static <T> RestResponse<T> result(T t, String message, boolean isSuccess){
        return new RestResponse<>(t, message,isSuccess);
    }
}

