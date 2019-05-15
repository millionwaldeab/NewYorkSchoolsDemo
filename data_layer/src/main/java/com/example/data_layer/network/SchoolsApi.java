package com.example.data_layer.network;

import com.example.data_layer.network.responses.SchoolsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolsApi {
    @GET("/resource/s3k6-pzi2.json")
    Call<SchoolsResponse> getSchoolByCity(@Query("q") String city);

}
