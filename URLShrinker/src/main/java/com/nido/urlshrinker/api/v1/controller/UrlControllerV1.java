package com.nido.urlshrinker.api.v1.controller;

import com.nido.urlshrinker.api.v1.dto.request.UrlRequestV1;
import com.nido.urlshrinker.api.v1.dto.response.ShortUrlResponseV1;
import com.nido.urlshrinker.service.UrlService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlControllerV1 {

    UrlService urlService;

    public UrlControllerV1(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public ShortUrlResponseV1 shorten(@RequestBody UrlRequestV1 req){
        return urlService.shrinkUrlV1(req);
    }

    @GetMapping("/{shortCode}")
    public RedirectView redirect(@PathVariable String shortCode){
        String originalUrl = urlService.getOriginalUrl(shortCode);
        if(originalUrl != null){
            return new RedirectView(originalUrl);
        }
        else{
            return null;
        }
    }

}
