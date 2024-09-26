package com.lazy.application.event.topic;

public enum EventTopicEnum {
    CLICK_SHORT_LINK("shortLink_clickShortLink");

    private final String topic;

    EventTopicEnum(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
