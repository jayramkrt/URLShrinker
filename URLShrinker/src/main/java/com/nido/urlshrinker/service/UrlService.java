package com.nido.urlshrinker.service;

import com.nido.urlshrinker.api.v1.dto.request.UrlRequestV1;
import com.nido.urlshrinker.api.v1.dto.response.ShortUrlResponseV1;
import com.nido.urlshrinker.entity.UrlEntity;
import com.nido.urlshrinker.exception.UrlNotFoundException;
import com.nido.urlshrinker.repository.UrlRepository;
import com.nido.urlshrinker.util.ShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final ShortCodeGenerator shortCodeGenerator;

    //constructor injection
    public UrlService(UrlRepository urlRepository, ShortCodeGenerator shortCodeGenerator){
        this.urlRepository = urlRepository;
        this.shortCodeGenerator = shortCodeGenerator;
    }

    public ShortUrlResponseV1 shrinkUrlV1(UrlRequestV1 request) {
        String shortCode = shortCodeGenerator.generateCode();

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setShortCode(shortCode);
        urlEntity.setOriginalUrl(request.getLongUrl());
        urlRepository.save(urlEntity);

        String shrinkenUrl = "https://shr.nk/"+shortCode;
        return new ShortUrlResponseV1(shrinkenUrl);
    }

    public String getOriginalUrl(String shortCode){
        Optional<UrlEntity> urlEntity = urlRepository.findByShortCode(shortCode);

        if(urlEntity.isPresent()){
            UrlEntity url = urlEntity.get();
            return url.getOriginalUrl();
        }
        else {
            throw new UrlNotFoundException(shortCode);
        }
    }
}
