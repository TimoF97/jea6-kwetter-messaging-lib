package com.timo.messaging.kafka;

import org.apache.kafka.clients.producer.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KafkaProducerImpl<T> {

    private static final Logger LOGGER = Logger.getLogger(KafkaProducerImpl.class.getName());

    private final KafkaProducer<UUID, KafkaMessage<T>> producer;

    public KafkaProducerImpl() {
        final Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER_URL + ":" + KafkaConstants.KAFKA_BROKER_PORT);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        this.producer = new KafkaProducer<>(properties);
    }

    public void sendMessage(final KafkaMessage<T> message, final String topic) {
        producer.send(new ProducerRecord<>(topic, message), new Callback() {

            @Override
            public void onCompletion(final RecordMetadata recordMetadata, final Exception e) {
                if (e != null) {
                    LOGGER.log(Level.SEVERE, "KafkaProducerImpl", e);
                }
            }
        });
    }
}
