package com.nanoka.pasteleria.dtos;

import lombok.Data;

@Data
public class DtoRegister {
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String phoneNumber;
    private String enabled;
}