package com.nido.urlshrinker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "original_url", nullable = false, length = 2048)
    private String originalUrl;

    @Getter
    @Setter
    @Column(name = "short_code", nullable = false, length = 200, unique = true)
    private String shortCode;

    @Getter
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
