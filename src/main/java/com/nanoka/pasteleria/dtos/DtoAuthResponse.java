package com.nanoka.pasteleria.dtos;

import lombok.Data;

@Data
public class DtoAuthResponse {
    private String token;

    public DtoAuthResponse(String token) {
        this.token = token;
    }
}