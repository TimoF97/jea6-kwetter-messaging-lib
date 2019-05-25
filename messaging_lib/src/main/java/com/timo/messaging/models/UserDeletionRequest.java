package com.timo.messaging.models;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDeletionRequest {

    private UUID userId;

    public UserDeletionRequest() { }

    public UserDeletionRequest(final UUID userId) {
        this.userId = userId;
    }
}
