package com.example.datnandroidquanlynhahangkhachsan.model.api;

import android.text.TextUtils;
import android.util.Log;

import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ClaimTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.LoginDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.utils.PublicVariables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    String userName = "admin";
    String pass = "123456";

    int MY_SOCKET_TIMEOUT_MS = 10000;
    public IAPIServiceRetrofit apiServiceRetrofit;

    public IAPIServiceTokenRetrofit iapiServiceTokenRetrofit;

    public APIService() {
        apiServiceRetrofit = getClient(PublicVariables.url_server).create(IAPIServiceRetrofit.class);
    }

    Date dateCurrent;

    //Goi api lay token
    public void getAccessToken(IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener listener) {
        Calendar c = Calendar.getInstance();
        dateCurrent = c.getTime();
        //Neu con thay han token thi khong lay lai token
        if (PublicVariables.exp_access_token != null && PublicVariables.exp_access_token.compareTo(dateCurrent) > 0) {
            listener.onSuccess(new ResponseTokenDTO(PublicVariables.access_token));
            return;
        }
        iapiServiceTokenRetrofit = getClientToken(PublicVariables.url_server).create(IAPIServiceTokenRetrofit.class);


        LoginDTO requestToken = new LoginDTO(userName, pass);
        iapiServiceTokenRetrofit.getAccessToken(requestToken).enqueue(new Callback<ResponseTokenDTO>() {
            //Thanh cong
            @Override
            public void onResponse(Call<ResponseTokenDTO> call, Response<ResponseTokenDTO> response) {
                if (response == null || response.body() == null) {
                    listener.onError(PublicVariables.error_msg_token);
                    return;
                }

//                //neu tra ve ResponseTokenDTO thi dung doan nay
                ResponseTokenDTO tokenInfo = response.body();
                if (tokenInfo == null || TextUtils.isEmpty(tokenInfo.getAccess_token())) {
                    listener.onError(PublicVariables.error_msg_token);
                    return;
                }
                PublicVariables.access_token = tokenInfo.getAccess_token();


                //Neu chi tra ve chi gia tri token
//                PublicVariables.access_token = response.body().toString();


                String encodedString = PublicVariables.access_token.split("\\.")[1];
                byte[] decodedBytes = new byte[0];
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    decodedBytes = java.util.Base64.getDecoder().decode(encodedString);
                }
                String decodedString = new String(decodedBytes);

                Type type = new TypeToken<ClaimTokenDTO>() {
                }.getType();

                ClaimTokenDTO obCalim = getResponse(decodedString, type);
                PublicVariables.exp_access_token = new Date(obCalim.getExp() * 1000);

                listener.onSuccess(tokenInfo);
            }

            //That bai
            @Override
            public void onFailure(Call<ResponseTokenDTO> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public static <T> ErrorMessageDTO getMessageResponse(Response<ResponseDTO<T>> response) {
        ErrorMessageDTO error = new ErrorMessageDTO();

        if (response != null && response.raw() != null && response.errorBody() != null) {
            String data = null;
            try {
                data = response.errorBody().string();
            } catch (IOException e) {
            }

            if (!TextUtils.isEmpty(data)) {
                try {
                    Log.d("ErrorAPI", data);
                    ResponseDTO res = new Gson().fromJson(data, ResponseDTO.class);
                    if (res != null && res.getStatus_code() == 500) {
                        PublicVariables.exp_access_token = null;
                        PublicVariables.access_token = "";
                    }
                } catch (Exception e) {
                }
            }
        }

        ResponseDTO obResponse = response.body();

        if (obResponse == null) {
            error.setFlagSuccess(false);
            String message = "";
            if (response != null && response.raw() != null) {
                message = response.raw().message();
            }
            if (TextUtils.isEmpty(message)) {
                message = "";
            }

            error.setErrorMessage(PublicVariables.error_msg_unknown + " " + message + " (Body)");
            return error;
        }
        if (!TextUtils.isEmpty(obResponse.getError_code())) {
            error.setFlagSuccess(false);
            error.setErrorMessage(obResponse.getMessage());
            return error;
        }

        error.setFlagSuccess(true);
        return error;
    }


    //Cau hinh header ket noi api
    static OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(chain -> {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder()
                        //Tuong tu o postman chon Bearer token o Authorization
                        //PublicVariables.access_token duoc gan khi goi getAccessToken
                        .addHeader("Authorization", "Bearer " + PublicVariables.access_token)
                        .addHeader("Accept", "application/json;versions=1")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded");
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }).build();


    static Gson gson = new GsonBuilder()
            //Dinh dang thoi gian cua file json
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();


    //Khoi tao Retrofit
    public static Retrofit getClient(String baseUrl) {
        //            .create(IAPIServiceRetrofit.class);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    ////Khoi tao Retrofit token
    public static Retrofit getClientToken(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static <T> T getResponse(String jsonString, Type typeOfT) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
//        Type type = new TypeToken<T>() {
//        }.getType();
        return gson.fromJson(jsonString, typeOfT);
    }


    public static <T> ArrayList<T> getListResponse(String jsonString, Type typeOfT) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
//        Type type = new TypeToken<ArrayList<T>>() {
//        }.getType();

        return gson.fromJson(jsonString, typeOfT);
    }
}
