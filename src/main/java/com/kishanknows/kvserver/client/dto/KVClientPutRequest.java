package com.kishanknows.kvserver.client.dto;

public record KVClientPutRequest(
        String key,
        String value
) {
}