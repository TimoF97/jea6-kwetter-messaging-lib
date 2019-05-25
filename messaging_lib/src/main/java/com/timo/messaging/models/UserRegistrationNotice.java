package com.timo.messaging.models;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRegistrationNotice {

    private UUID userId;
    private String userEmailAddress;

    public UserRegistrationNotice() { }

    public UserRegistrationNotice(final UUID userId, final String userEmailAddress) {
        this.userId = userId;
        this.userEmailAddress = userEmailAddress;
    }
}
