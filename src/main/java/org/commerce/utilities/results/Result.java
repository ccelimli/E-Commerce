package org.commerce.utilities.results;

public class Result {
    boolean success;
    String message;

    public Result(){}
    public Result (boolean success){
        this.success=success;
    }

    public Result(String message){
        this.message=message;
    }

    public Result(boolean success, String message){
        this.success=success;
        this.message=message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}