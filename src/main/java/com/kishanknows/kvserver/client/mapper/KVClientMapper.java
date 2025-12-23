package com.kishanknows.kvserver.client.mapper;

import com.kishanknows.kvserver.client.dto.KVClientResponse;
import com.kishanknows.kvserver.client.model.KVClientModel;

public class KVClientMapper {
    public static KVClientResponse toResponse(KVClientModel model){
        return new KVClientResponse(
                model.key(),
                model.value()
        );
    }
}
