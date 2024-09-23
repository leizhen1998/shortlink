package com.lazy.infrastructure.util;

import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.init.ResourceReader;

import java.io.IOException;
import java.io.InputStream;

public class IPUtils {
    private static final IP2Location ip2Location = new IP2Location();
    static {
        try {
            byte[] bytes = new ClassPathResource("ip2location/IP2LOCATION-LITE-DB11.BIN").getInputStream().readAllBytes();
            ip2Location.Open(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public IPUtils() throws IOException {
    }


    public static String getIpAdrress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }

        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("Proxy-Client-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("WL-Proxy-Client-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("HTTP_CLIENT_IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }

        return request.getRemoteAddr();
    }

    public static IPResult getLocation(String ip) throws IOException {
        IPResult result = ip2Location.IPQuery(ip);
        return result;
    }

//    public static void main(String[] args) throws IOException {
//        System.out.println(getLocation("180.169.109.129"));
//    }
}
