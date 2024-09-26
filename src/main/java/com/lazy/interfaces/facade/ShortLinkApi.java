package com.lazy.interfaces.facade;

import com.lazy.application.service.CreateShortLinkAppService;
import com.lazy.application.dto.CreateShortLinkRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shortLink")
public class ShortLinkApi {
    private final CreateShortLinkAppService createShortLinkAppService;

    public ShortLinkApi(CreateShortLinkAppService createShortLinkAppService) {
        this.createShortLinkAppService = createShortLinkAppService;
    }

    @PostMapping("/create")
    public void createShortLink(@RequestBody @Valid CreateShortLinkRequest createShortLinkRequest) {
        Long createBy = 0L;
        createShortLinkRequest.setCreateBy(createBy);

        createShortLinkAppService.createShortLink(createShortLinkRequest);
    }
}
