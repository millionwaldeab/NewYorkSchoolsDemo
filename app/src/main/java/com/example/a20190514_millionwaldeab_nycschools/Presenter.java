package com.example.a20190514_millionwaldeab_nycschools;

import com.example.*;
import com.example.data_layer.network.requests.SchoolNameRequest;
import com.example.data_layer.network.requests.SchoolsRequest;
import com.example.data_layer.network.responses.SchoolNameResponse;
import com.example.data_layer.network.responses.SchoolsResponse;

/**
 * Class responsible of passing request to the underlying data layer and presenting the fetched data
* to the view, that way the activity/ fragment is only responsible to display data following MVP design. */
public class Presenter{

    public Schools getDataDetails(String school){
        SchoolsRequest request = new SchoolsRequest();
        request.getSchoolData(school);
        if(request.mSchoolsResponse != null) {
            Schools schools = new Schools(request.mSchoolsResponse.getDbn(), request.mSchoolsResponse.getSchoolName(),
                    request.mSchoolsResponse.getNumOfSatTestTakers(), request.mSchoolsResponse.getSatCriticalReadingAvgScore(),
                    request.mSchoolsResponse.getSatMathAvgScore(), request.mSchoolsResponse.getSatWritingAvgScore(), "");
            return schools;
        }
        return null;
    }

    public Schools getSchoolName(){
        SchoolNameRequest request = new SchoolNameRequest();
        if(request.mSchoolsNameResponse != null) {
            Schools schools = new Schools("", request.mSchoolsNameResponse.getSchoolName(), "", "", "", "", "");
            return schools;
        }
        return null;
    }
}
