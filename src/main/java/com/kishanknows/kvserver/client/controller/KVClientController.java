package com.kishanknows.kvserver.client.controller;

import com.kishanknows.kvserver.client.dto.KVClientGetRequest;
import com.kishanknows.kvserver.client.dto.KVClientPutRequest;
import com.kishanknows.kvserver.client.dto.KVClientResponse;
import com.kishanknows.kvserver.client.mapper.KVClientMapper;
import com.kishanknows.kvserver.client.service.KVClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KVClientController {
    private final KVClientService service;

    public KVClientController(KVClientService service){
        this.service = service;
    }

    @PostMapping("/kv")
    public KVClientResponse getKeyValue(@RequestBody KVClientGetRequest request){
        return KVClientMapper.toResponse(service.fetchKeyValue(request));
    }

    @PutMapping("/kv")
    public KVClientResponse putKeyValue(@RequestBody KVClientPutRequest request){
        return KVClientMapper.toResponse(service.updateKeyValue(request));
    }
}
