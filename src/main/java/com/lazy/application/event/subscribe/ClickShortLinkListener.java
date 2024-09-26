package com.lazy.application.event.subscribe;

import com.lazy.domain.analytics.event.ClickShortLinkEvent;
import com.lazy.domain.analytics.service.AnalyticsDomainService;
import com.lazy.infrastructure.util.JSONUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ClickShortLinkListener {
    private final AnalyticsDomainService analyticsDomainService;

    @KafkaListener(topics = "#{T(com.lazy.application.event.topic.EventTopicEnum).CLICK_SHORT_LINK.topic}")
    public void onEvent(ConsumerRecord<String, String> consumerRecord, Acknowledgment ack) throws Exception {
        try {
            log.info("consume topic: {}, partition: {}, offset: {}, key: {}, value: {}",
                    consumerRecord.topic(),
                    consumerRecord.partition(),
                    consumerRecord.offset(),
                    consumerRecord.key(),
                    consumerRecord.value());

            ClickShortLinkEvent clickShortLinkEvent = JSONUtils.json2pojo(consumerRecord.value(), ClickShortLinkEvent.class);
            analyticsDomainService.handleEvent(clickShortLinkEvent);
        } finally {
            ack.acknowledge();
        }
    }
}
