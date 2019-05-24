package com.timo.messaging.kafka;

public interface IKafkaCallback<T> {

    void execute(final KafkaMessage<T> message);
}
