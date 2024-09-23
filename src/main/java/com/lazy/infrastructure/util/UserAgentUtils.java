package com.lazy.infrastructure.util;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserAgentUtils {
    private static UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
            .newBuilder()
            .hideMatcherLoadStats()
            .withAllFields()
            .withCache(10000)
            .build();

    public static final Map<String, String> parse(String userAgent) {
        UserAgent.ImmutableUserAgent agent = userAgentAnalyzer.parse(userAgent);
        Map<String, String> map = new LinkedHashMap<>();
        List<String> fieldNamesSorted = agent.getCleanedAvailableFieldNamesSorted();
        for (String fieldName : fieldNamesSorted) {
            String value = agent.getValue(fieldName);
            map.put(fieldName, value);
        }
        return map;
    }
}
