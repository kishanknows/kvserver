package com.kishanknows.kvserver.client.service;

import com.kishanknows.kvserver.client.dto.KVClientGetRequest;
import com.kishanknows.kvserver.client.dto.KVClientPutRequest;
import com.kishanknows.kvserver.client.dto.KVClientResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KVClientService {
    private final RestTemplate restTemplate;

    public KVClientService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public KVClientResponse fetchKeyValue(KVClientGetRequest request){
        return restTemplate.postForObject(
                "http://kvcoordinator:8081/kv",
                request,
                KVClientResponse.class
        );
    }

    public KVClientResponse updateKeyValue(KVClientPutRequest request){
        ResponseEntity<KVClientResponse> response = restTemplate.exchange(
                "http://kvcoordinator:8081/kv",
                HttpMethod.PUT,
                new HttpEntity<>(request),
                KVClientResponse.class
        );
        return response.getBody();
    }
}
