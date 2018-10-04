package com.alldaypa.security2.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LdapUser {
    private String username;
    private ArrayList authorities;
    private boolean authenticated;
}
