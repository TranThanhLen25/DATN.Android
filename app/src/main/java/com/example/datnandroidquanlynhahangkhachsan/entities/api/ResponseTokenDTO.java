package com.example.datnandroidquanlynhahangkhachsan.entities.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResponseTokenDTO {
    private String access_token;
    private String token_type;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public ResponseTokenDTO(String access_token) {
        this.access_token = access_token;
    }

    public ResponseTokenDTO getResponseToken(String jsonString) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        Type type = new TypeToken<ResponseTokenDTO>() {
        }.getType();
        return gson.fromJson(jsonString, type);
    }

    public ArrayList<ResponseTokenDTO> getListResponseToken(String jsonString) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        Type type = new TypeToken<ArrayList<ResponseTokenDTO>>() {
        }.getType();
        return gson.fromJson(jsonString, type);
    }
}
