package com.lazy.domain.analytics.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class UserAgent {
    /**
     * 请求头
     */
    private String userAgent;

    /**
     * 设备类别
     */
    private String deviceClass;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备品牌
     */
    private String deviceBrand;

    /**
     * 操作系统类别
     */
    private String operatingSystemClass;

    /**
     * 操作系统名称
     */
    private String operatingSystemName;

    /**
     * 操作系统版本
     */
    private String operatingSystemVersion;

    /**
     * 操作系统版本主版本
     */
    private String operatingSystemVersionMajor;

    /**
     * 操作系统版本构建
     */
    private String operatingSystemVersionBuild;

    /**
     * 布局引擎类别
     */
    private String layoutEngineClass;

    /**
     * 布局引擎名称
     */
    private String layoutEngineName;

    /**
     * 布局引擎版本
     */
    private String layoutEngineVersion;

    /**
     * 布局引擎版本主版本
     */
    private String layoutEngineVersionMajor;

    /**
     * 代理类型
     */
    private String agentClass;

    /**
     * 代理名称
     */
    private String agentName;

    /**
     * 代理版本
     */
    private String agentVersion;

    /**
     * 代理版本主版本
     */
    private String agentVersionMajor;

    /**
     * 代理语言
     */
    private String agentLanguage;

    /**
     * 语言代码代码
     */
    private String agentLanguageCode;

    /**
     * 代理安全
     */
    private String agentSecurity;

    /**
     * WebView应用名称
     */
    private String webviewAppName;

    /**
     * WebView应用版本
     */
    private String webviewAppVersion;

    /**
     * WebView应用版本主版本
     */
    private String webviewAppVersionMajor;

    public UserAgent(String userAgent, Map<String, String> parsedUserAgent) {
        this(
                userAgent,
                parsedUserAgent.get("DeviceClass"),
                parsedUserAgent.get("DeviceName"),
                parsedUserAgent.get("DeviceBrand"),
                parsedUserAgent.get("OperatingSystemClass"),
                parsedUserAgent.get("OperatingSystemName"),
                parsedUserAgent.get("OperatingSystemVersion"),
                parsedUserAgent.get("OperatingSystemVersionMajor"),
                parsedUserAgent.get("OperatingSystemVersionBuild"),
                parsedUserAgent.get("LayoutEngineClass"),
                parsedUserAgent.get("LayoutEngineName"),
                parsedUserAgent.get("LayoutEngineVersion"),
                parsedUserAgent.get("LayoutEngineVersionMajor"),
                parsedUserAgent.get("AgentClass"),
                parsedUserAgent.get("AgentName"),
                parsedUserAgent.get("AgentVersion"),
                parsedUserAgent.get("AgentVersionMajor"),
                parsedUserAgent.get("AgentLanguage"),
                parsedUserAgent.get("AgentLanguageCode"),
                parsedUserAgent.get("AgentSecurity"),
                parsedUserAgent.get("WebviewAppName"),
                parsedUserAgent.get("WebviewAppVersion"),
                parsedUserAgent.get("WebviewAppVersionMajor")
        );
    }
}
