package com.timo.messaging.kafka;

import com.timo.messaging.utils.JsonSerializer;

public class MessageBodyParser {

    private final JsonSerializer jsonSerializer;

    public MessageBodyParser() {
        jsonSerializer = new JsonSerializer();
    }

    public <T> T parseBodyFromMessage(final KafkaMessage<T> message, final Class<T> type) {
        final String json = jsonSerializer.toJson(message.getBody());

        return jsonSerializer.parse(json, type);
    }
}
