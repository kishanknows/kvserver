package com.kishanknows.kvserver.client.service;

import com.kishanknows.kvserver.client.dto.KVClientGetRequest;
import com.kishanknows.kvserver.client.dto.KVClientPutRequest;
import com.kishanknows.kvserver.client.model.KVClientModel;
import com.kishanknows.kvserver.client.repository.KVClientRepository;
import org.springframework.stereotype.Service;

@Service
public class KVClientService {
    private final KVClientRepository repo;

    public KVClientService(KVClientRepository repo){
        this.repo = repo;
    }

    public KVClientModel fetchKeyValue(KVClientGetRequest request){
        return repo.get(request.key());
    }

    public KVClientModel updateKeyValue(KVClientPutRequest request){
        return repo.put(request.key(), request.value());
    }
}
