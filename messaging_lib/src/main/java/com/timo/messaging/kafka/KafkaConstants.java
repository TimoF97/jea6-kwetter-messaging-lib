package com.timo.messaging.kafka;

public class KafkaConstants {

    /* General configs */
    public static final String KAFKA_BROKER_URL = "localhost";
    public static final int KAFKA_BROKER_PORT = 9092;

    /* Topics */
    public static final String USER_REGISTRATION_TOPIC = "user_registration_topic";
    public static final String ACTIVATION_ENTRY_VISIT_TOPIC = "activation_entry_visit_topic";
    public static final String USER_ACTIVATED_NOTICE_TOPIC = "user_activated_notice_topic";
    public static final String USER_DELETION_TOPIC = "user_deletion_topic";

    /* Consumer Groups */
    public static final String USER_DELETION_CONSUMER_GROUP_ID = "user-deletion.consumer-group";
    public static final String ACTIVATED_USER_CONSUMER_GROUP_ID = "activated-user.consumer-group";

    private KafkaConstants() { }
}
