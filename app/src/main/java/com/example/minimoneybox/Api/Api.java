package com.example.minimoneybox.Api;

import com.example.minimoneybox.Models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface Api {

    String BASE_URL = "https://api-test01.moneyboxapp.com";

    @Headers({"AppId: 3a97b932a9d449c981b595", "Content-Type: application/json", "appVersion: 5.10.0", "apiVersion: 3.0.0"})
    @POST("/users/login")
    Call<SessionResponse> postLoginDetails(@Body BearerRequest bearerRequest);


    @GET("/investorproducts")
    Call<InverstorProducts> getInvestorProducts(@Header("Authorization") String bearer,
                                                @Header("AppId") String appId,
                                                @Header("Content-Type") String contentType,
                                                @Header("appVersion") String appVersion,
                                                @Header("apiVersion") String apiVersion);

    @POST("/oneoffpayments")
    Call<OneOffPayments> postOneOffPayments(@Header("Authorization") String bearer,
                                            @Header("AppId") String appId,
                                            @Header("Content-Type") String contentType,
                                            @Header("appVersion") String appVersion,
                                            @Header("apiVersion") String apiVersion, @Body OneOffPaymentRequest oneOffPaymentRequest);

}
