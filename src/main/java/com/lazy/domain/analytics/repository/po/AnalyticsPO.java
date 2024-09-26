package com.lazy.domain.analytics.repository.po;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
@Table(name = "analytics")
@Data
@Accessors(chain = true)
public class AnalyticsPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_code", nullable = false, length = 7)
    private String shortCode;

    @Column(name = "click_time", nullable = false)
    private LocalDateTime clickTime;

    @Column(name = "original_url", length = 1000)
    private String referer;

    private String clientIp;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 省/州
     */
    @Column(name = "region")
    private String region;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private float latitude;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private float longitude;

    /**
     * 邮政编码
     */
    @Column(name = "zipcode")
    private String zipcode;

    /**
     * 时区
     */
    @Column(name = "timezone")
    private String timezone;

    /**
     * 请求头
     */
    @Column(name = "user_agent", length = 5000)
    private String userAgent;

    /**
     * 设备类别
     */
    @Column(name = "device_class")
    private String deviceClass;

    /**
     * 设备名称
     */
    @Column(name = "device_name")
    private String deviceName;

    /**
     * 设备品牌
     */
    @Column(name = "device_brand")
    private String deviceBrand;

    /**
     * 操作系统类别
     */
    @Column(name = "operating_system_class")
    private String operatingSystemClass;

    /**
     * 操作系统名称
     */
    @Column(name = "operating_system_name")
    private String operatingSystemName;

    /**
     * 操作系统版本
     */
    @Column(name = "operating_system_version")
    private String operatingSystemVersion;

    /**
     * 操作系统版本主版本
     */
    @Column(name = "operating_system_version_major")
    private String operatingSystemVersionMajor;

    /**
     * 操作系统版本构建
     */
    @Column(name = "operating_system_version_build")
    private String operatingSystemVersionBuild;

    /**
     * 布局引擎类别
     */
    @Column(name = "layout_engine_class")
    private String layoutEngineClass;

    /**
     * 布局引擎名称
     */
    @Column(name = "layout_engine_name")
    private String layoutEngineName;

    /**
     * 布局引擎版本
     */
    @Column(name = "layout_engine_version")
    private String layoutEngineVersion;

    /**
     * 布局引擎版本主版本
     */
    @Column(name = "layout_engine_version_major")
    private String layoutEngineVersionMajor;

    /**
     * 代理类型
     */
    @Column(name = "agent_class")
    private String agentClass;

    /**
     * 代理名称
     */
    @Column(name = "agent_name")
    private String agentName;

    /**
     * 代理版本
     */
    @Column(name = "agent_version")
    private String agentVersion;

    /**
     * 代理版本主版本
     */
    @Column(name = "agent_version_major")
    private String agentVersionMajor;

    /**
     * 代理语言
     */
    @Column(name = "agent_language")
    private String agentLanguage;

    /**
     * 语言代码代码
     */
    @Column(name = "agent_language_code")
    private String agentLanguageCode;

    /**
     * 代理安全
     */
    @Column(name = "agent_security")
    private String agentSecurity;

    /**
     * WebView应用名称
     */
    @Column(name = "webview_app_name")
    private String webviewAppName;

    /**
     * WebView应用版本
     */
    @Column(name = "webview_app_version")
    private String webviewAppVersion;

    /**
     * WebView应用版本主版本
     */
    @Column(name = "webview_app_version_major")
    private String webviewAppVersionMajor;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
