package com.template.appgateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

public class AuthFailureHandler {
    public Mono<Void> formatResponse(ServerHttpResponse response) {
        response.getHeaders()
                .add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder json = new StringBuilder();
        try {
            json.append(mapper.writeValueAsString("access Denied"));
        } catch (JsonProcessingException jsonProcessingException) {
        }

        String responseBody = json.toString();
        byte[] bytes = responseBody.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory()
                .wrap(bytes);
        return response.writeWith(Mono.just(buffer));
    }
}
