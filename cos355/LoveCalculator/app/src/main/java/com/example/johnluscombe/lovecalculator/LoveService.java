package com.example.johnluscombe.lovecalculator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface LoveService {

    @Headers("X-Mashape-Key: 4lFoMTrK30mshwj8MHIuanHosXV0p1L733fjsn4Ejh4SYZOMOP")
    @GET("/getPercentage")
    Call<LoveData> detect(
            @Query("fname")String first_name,
            @Query("sname")String last_name
    );
}
