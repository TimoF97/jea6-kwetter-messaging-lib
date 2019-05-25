package com.timo.messaging.kafka;

public class KafkaConstants {

    /* General configs */
    public static final String KAFKA_BROKER_URL = "localhost";
    public static final int KAFKA_BROKER_PORT = 9092;

    /* Topics */
    public static final String USER_REGISTRATION_TOPIC = "user_registration_topic";
    public static final String USER_DELETION_TOPIC = "user_deletion_topic";

    private KafkaConstants() { }
}
