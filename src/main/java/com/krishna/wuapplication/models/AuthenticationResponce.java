package com.krishna.wuapplication.models;

public class AuthenticationResponce {
   private final String jwt;

    public AuthenticationResponce(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
