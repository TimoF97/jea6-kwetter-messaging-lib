package com.timo.messaging.models;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRegistration {

    private UUID userId;
    private String userEmailAddress;

    public UserRegistration() { }

    public UserRegistration(final UUID userId, final String userEmailAddress) {
        this.userId = userId;
        this.userEmailAddress = userEmailAddress;
    }
}
