package com.example.data_layer.network;

import com.example.data_layer.network.responses.SchoolNameResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolNameApi {
    @GET("/resource/s3k6-pzi2.json")
    Call<SchoolNameResponse> getSchoolName(@Query("q") String school);
}
