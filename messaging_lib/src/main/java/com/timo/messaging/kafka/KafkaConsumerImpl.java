package com.timo.messaging.kafka;

import org.apache.kafka.clients.consumer.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class KafkaConsumerImpl<T> {

    private List<String> topics;
    private IKafkaCallback<T> callback;

    public KafkaConsumerImpl<T> setCallback(final IKafkaCallback<T> callback) {
        this.callback = callback;

        return this;
    }

    public KafkaConsumerImpl<T> setTopics(final List<String> topics) {
        this.topics = topics;

        return this;
    }

    /**
     * Call this method once to start the ThreadedConsumer and thus the CustomKafkaConsumer.
     * Beware: Only call this method whenever the topics of this CustomKafkaConsumer have been set.
     * @return Returns the instance of CustomKafkaConsumer on which this method has been called to support method stacking.
     */
    public KafkaConsumerImpl<T> start() {
        new ThreadedConsumer<>(topics, callback).start();

        return this;
    }
}

class ThreadedConsumer<T> extends Thread {

    private final KafkaConsumer<UUID, KafkaMessage<T>> consumer;
    private final IKafkaCallback<T> callback;

    ThreadedConsumer(final List<String> topics, final IKafkaCallback<T> callback) {
        final Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER_URL + ":" + KafkaConstants.KAFKA_BROKER_PORT);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.DEFAULT_CONSUMER_GROUP_ID);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10");
        properties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "1000");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "25000");
        properties.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        if (topics == null || topics.isEmpty()) throw new IllegalArgumentException("Can't run consumer without any given topics to subscribe to.");

        this.consumer = new KafkaConsumer<>(properties);
        this.callback = callback;
        this.consumer.subscribe(topics);
    }

    @Override
    public void run() {
        while (true) {
            final ConsumerRecords<UUID, KafkaMessage<T>> records = consumer.poll(Duration.ofMillis(10));

            for (final ConsumerRecord<UUID, KafkaMessage<T>> record : records) {
                if (callback != null) {
                    callback.execute(record.value());
                }
            }
        }
    }
}
