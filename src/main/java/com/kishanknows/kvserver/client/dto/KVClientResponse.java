package com.kishanknows.kvserver.client.dto;

public record KVClientResponse(
        String key,
        String value
) {
}
