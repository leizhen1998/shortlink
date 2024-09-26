package com.lazy.application.event.publish;

import com.lazy.application.event.topic.EventTopicEnum;

public interface EventPublisher {
    <T> void publish(EventTopicEnum eventTopicEnum, T event) throws Exception;
}
