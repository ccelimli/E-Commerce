package org.commerce.service.constant;

public enum Message {
    //User
    UserAdded("Kullanıcı Eklendi."),
    UserDeleted("Kullanıcı Silindi."),
    UserUpdated("Kullanıcı Güncellendi."),
    UsersListed("Kullanıcılar Listelendi."),
    UserListed("Kullanıcı Listelendi.");

    //
    private final String message;
    Message(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}

