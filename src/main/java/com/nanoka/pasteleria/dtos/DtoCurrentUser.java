package com.nanoka.pasteleria.dtos;

import java.util.ArrayList;
import java.util.List;

import com.nanoka.pasteleria.models.Role;

import lombok.Data;

@Data
public class DtoCurrentUser {
    private String username;
    private String name;
    private List<Role> roles = new ArrayList<>();

    public DtoCurrentUser(String username, String name, List<Role> roles){
        this.username = username;
        this.name = name;
        this.roles = roles;
    }
}
