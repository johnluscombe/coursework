package com.example.johnluscombe.faceservice;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface FaceService {

    @Multipart
    @POST("/facepp/v3/detect")
    Call<DetectionData> detect(
            @Part("api_key")RequestBody key,
            @Part("api_secret")RequestBody secret,
            @Part("image_base64")RequestBody image,
            @Part("return_attributes")RequestBody attributes
            );
}
