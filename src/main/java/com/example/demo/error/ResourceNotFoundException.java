package com.example.demo.error;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Serializable id) {
        super(String.format("%s with id %s not exists", resource, id));
    }
}
