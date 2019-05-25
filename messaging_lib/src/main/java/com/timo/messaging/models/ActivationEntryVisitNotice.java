package com.timo.messaging.models;

import lombok.Data;

import java.util.UUID;

@Data
public class ActivationEntryVisitNotice {

    private UUID entryId;

    public ActivationEntryVisitNotice() { }

    public ActivationEntryVisitNotice(final UUID entryId) {
        this.entryId = entryId;
    }
}
