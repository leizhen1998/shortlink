package com.lazy.application.event.publish;

import com.lazy.application.event.topic.EventTopicEnum;
import com.lazy.infrastructure.util.JSONUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaEventPublisher implements EventPublisher {
    private final KafkaTemplate kafkaTemplate;

    @Async
    @Override
    public <T> void publish(EventTopicEnum eventTopicEnum, T event) {
        try {
            String topic = eventTopicEnum.getTopic();
            String value = JSONUtils.obj2json(event);
            CompletableFuture<SendResult> completableFuture = kafkaTemplate.send(topic, value);
            completableFuture.handle((result, ex) -> {
                if (ex != null) {
                    log.error("KafkaEventPublisher publish failed. topic:{}, value: {}, ex: {}", topic, value, ex);
                } else {
                    RecordMetadata recordMetadata = result.getRecordMetadata();
                    ProducerRecord producerRecord = result.getProducerRecord();
                    Integer partition = producerRecord.partition();
                    long offset = recordMetadata.offset();
                    Object key = producerRecord.key();
                    log.info("KafkaEventPublisher publish success. topic:{}, partition: {}, offset: {}, key: {}, value: {}", topic, partition, offset, key, value);
                }
                return result;
            });
        } catch (Exception e) {
            log.error("KafkaEventPublisher publish failed. event: {}", event, e);
        }
    }
}
