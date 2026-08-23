package com.productservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor bearerTokenRequestInterceptor() {
        return requestTemplate -> {

            var authentication =
                    SecurityContextHolder.getContext().getAuthentication();

            if (authentication instanceof JwtAuthenticationToken jwtAuthentication) {

                String token = jwtAuthentication.getToken().getTokenValue();

                requestTemplate.header(
                        "Authorization",
                        "Bearer " + token
                );
                System.out.println("JWT FORWARDED TO: " + requestTemplate.url());
            }else {
                System.out.println("NO JWT FOUND IN SECURITY CONTEXT");
            }
        };
    }
}