package com.nido.urlshrinker.api.v1.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UrlRequestV1 {

    private String longUrl;

    public UrlRequestV1(String longUrl){
        this.longUrl = longUrl;
    }
}
