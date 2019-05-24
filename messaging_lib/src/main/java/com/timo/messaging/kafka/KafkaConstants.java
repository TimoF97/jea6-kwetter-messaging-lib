package com.timo.messaging.kafka;

public class KafkaConstants {

    /* General configs */
    public static final String KAFKA_BROKER_URL = "localhost";
    public static final int KAFKA_BROKER_PORT = 9092;

    /* Consumer configs */
    public static final String DEFAULT_CONSUMER_GROUP_ID = "default.consumer-group";

    /* Topics */
    public static final String CALAMITY_NOTICE_TOPIC = "alarm_center_calamity_notice_topic";

    private KafkaConstants() { }
}
