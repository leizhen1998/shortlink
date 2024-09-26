package com.lazy.interfaces.facade;

import com.lazy.application.dto.RedirectRequest;
import com.lazy.application.dto.RedirectResponse;
import com.lazy.application.service.RedirectAppService;
import com.lazy.infrastructure.util.IPUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
}
