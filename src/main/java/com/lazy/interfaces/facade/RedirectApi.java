package com.lazy.interfaces.facade;

import com.ip2location.IPResult;
import com.lazy.application.dto.RedirectRequest;
import com.lazy.application.dto.RedirectResponse;
import com.lazy.application.service.RedirectAppService;
import com.lazy.infrastructure.util.IPUtils;
import com.lazy.infrastructure.util.UserAgentUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping
public class RedirectApi {
    private final RedirectAppService redirectAppService;

    public RedirectApi(RedirectAppService redirectAppService) {
        this.redirectAppService = redirectAppService;
    }

    @GetMapping("/{shortCode}")
    public void redirect(@PathVariable String shortCode, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String clientIp = IPUtils.getIpAdrress(request);
        String referer = request.getHeader("Referer");
        String userAgent = request.getHeader("User-Agent");
        RedirectRequest redirectRequest = new RedirectRequest(shortCode, clientIp, referer, userAgent);
        RedirectResponse redirectResponse = redirectAppService.redirect(redirectRequest);
        response.sendRedirect(redirectResponse.originalUrl());
    }

    @GetMapping("/test")
    @ResponseBody
    public Map<String, String> test(HttpServletRequest request) throws IOException {
        String clientIp = IPUtils.getIpAdrress(request);
        String referer = request.getHeader("Referer");
        String userAgent = request.getHeader("User-Agent");
        Map<String, String> uaParseInfo = UserAgentUtils.parse(userAgent);
        IPResult location = IPUtils.getLocation(clientIp);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("ip：", clientIp);
        map.putAll(uaParseInfo);
        map.put("country", location.getCountryLong());
        map.put("region", location.getRegion());
        map.put("city", location.getCity());
        return map;
    }
}
