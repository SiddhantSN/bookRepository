package com.books.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {
    @Bean("openLibraryRestClient")
    public RestClient openLibraryRestClient(RestClient.Builder builder) {
        return builder.baseUrl("https://openlibrary.org").build();
    }
}
