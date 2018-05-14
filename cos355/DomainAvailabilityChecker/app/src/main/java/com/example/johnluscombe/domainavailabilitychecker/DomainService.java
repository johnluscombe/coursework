package com.example.johnluscombe.domainavailabilitychecker;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DomainService {

    @Headers("X-Mashape-Key: 4lFoMTrK30mshwj8MHIuanHosXV0p1L733fjsn4Ejh4SYZOMOP")
    @POST("/")
    Call<DomainData> check(@Body RequestBody domain);
}
