package com.timo.messaging.kafka;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "body")
public class KafkaMessage<T> {

    private T body;

    public KafkaMessage() { }

    public KafkaMessage(final T body) {
        this.body = body;
    }
}
