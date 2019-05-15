package com.example.data_layer.network.requests;

import com.example.data_layer.network.NetworkClient;
import com.example.data_layer.network.SchoolsApi;
import com.example.data_layer.network.responses.SchoolsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SchoolsRequest implements SchoolsRequestInterface {
    public SchoolsResponse mSchoolsResponse;

    @Override
    public void getSchoolData(String school) {
        //Obtain an instance of Retrofit by calling the static method.
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        SchoolsApi schoolsApi = retrofit.create(SchoolsApi.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        Call call = schoolsApi.getSchoolDetails(school);
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    mSchoolsResponse = (SchoolsResponse) response.body();
                    /*responseText.setText("Temp: " + schoolsResponse.getMain().getTemp() + "\n " +
                            "Humidity: " + schoolsResponse.getMain().getHumidity() + "\n" +
                            "Pressure: " + schoolsResponse.getMain().getPressure());*/
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                /*
                Error callback
                */
            }
        });
    }
}
