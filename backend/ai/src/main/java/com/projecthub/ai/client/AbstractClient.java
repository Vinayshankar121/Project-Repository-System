package com.projecthub.ai.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AbstractClient {

    private final WebClient webClient;

    public AbstractClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:2109").build();
    }

    public String getApprovedAbstracts(String department) {
        return webClient.get()
                .uri("/abstract/departmentAi/" + department)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
