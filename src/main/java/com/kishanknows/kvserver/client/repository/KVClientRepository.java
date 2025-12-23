package com.kishanknows.kvserver.client.repository;

import com.kishanknows.kvserver.client.model.KVClientModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class KVClientRepository {
    private final HashMap<String, String> keyValueStore;

    public KVClientRepository(HashMap<String, String> kv){
        this.keyValueStore = kv;
    }

    public KVClientModel get(String key){
        if (keyValueStore.containsKey(key)) {
            return new KVClientModel(key, keyValueStore.get(key));
        }
        return null;
    }

    public KVClientModel put(String key, String value){
        keyValueStore.put(key, value);
        return new KVClientModel(key, value);
    }
}
