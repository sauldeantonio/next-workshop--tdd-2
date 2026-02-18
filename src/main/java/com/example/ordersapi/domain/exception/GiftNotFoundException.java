package com.example.ordersapi.domain.exception;

public class GiftNotFoundException extends RuntimeException {
    public GiftNotFoundException(Long id) {
        super("Gift with id " + id + " not found");
    }
}
