package org.commerce.service.constant;

public enum message {
    //User
    UserAdded("Kullanıcı Eklendi."),
    UserDeleted("Kullanıcı Silindi."),
    UserUpdated("Kullanıcı Güncellendi."),
    UsersListed("Kullanıcılar Listelendi."),
    UserListed("Kullanıcı Listelendi.");

    //
    private final String message;
    message(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}

