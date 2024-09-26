package com.lazy.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Slf4j
@Configuration
public class KafkaConfig {
//    /**
//     * 消费异常处理：重试尝试用尽后写入死信队列
//     * @param template
//     * @return
//     */
//    @Bean
//    public CommonErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
//        return new DefaultErrorHandler(
//                new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
//    }

    /**
     * 消费异常处理：重试尝试用尽后写错误日志
     * @return
     */
    @Bean
    public DefaultErrorHandler errorHandler() {
        DefaultErrorHandler errorHandler = new DefaultErrorHandler((consumerRecord, exception) -> {
            // 当所有重试尝试都用尽时执行的逻辑
            log.error("consume exception topic: {}, partition: {}, offset: {}, key: {}, value: {}, e: {}", consumerRecord.topic(), consumerRecord.partition(), consumerRecord.offset(), consumerRecord.key(), consumerRecord.value(), exception.getMessage(), exception);
        }, new FixedBackOff(1000L, 2));
        return errorHandler;
    }
}
