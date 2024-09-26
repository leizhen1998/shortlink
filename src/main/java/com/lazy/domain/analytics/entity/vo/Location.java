package com.lazy.domain.analytics.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    /**
     * 客户端 IP
     */
    private String clientIp;

    /**
     * 国家
     */
    private String country;

    /**
     * 省/州
     */
    private String region;

    /**
     * 城市
     */
    private String city;

    /**
     * 纬度
     */
    private float latitude;

    /**
     * 经度
     */
    private float longitude;

    /**
     * 邮政编码
     */
    private String zipcode;

    /**
     * 时区
     */
    private String timezone;
}
