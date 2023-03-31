package com.example.datnandroidquanlynhahangkhachsan.model.api;



import com.example.datnandroidquanlynhahangkhachsan.entities.api.LoginDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAPIServiceTokenRetrofit {
    public interface IOnGetAccessTokenFinishedListener {
        void onSuccess(ResponseTokenDTO itemToken);

        void onError(String error);
    }

    //get access token de goi nhung api ben duoi
    //Neu tra ve doi tuong ResponseTokenDTO
    @POST("/api/token")
    Call<ResponseTokenDTO> getAccessToken(@Body LoginDTO request);


    //get access token de goi nhung api ben duoi
    //Neu tra ve gia tri token
//    @POST("/api/login")
//    Call<String> getAccessToken(@Body LoginRequestDTO request);
}
