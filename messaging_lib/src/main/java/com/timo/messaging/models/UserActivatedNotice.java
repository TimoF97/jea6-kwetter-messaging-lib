package com.timo.messaging.models;

import lombok.Data;

import java.util.UUID;

@Data
public class UserActivatedNotice {

    private UUID userId;

    public UserActivatedNotice() { }

    public UserActivatedNotice(final UUID userId) {
        this.userId = userId;
    }
}
