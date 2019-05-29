package com.example.a20190514_millionwaldeab_nycschools;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.data_layer.network.requests.SchoolsRequest;
import java.util.List;

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.SchoolArrayAdapter> {

    List<Schools> mSchoolList;

    public SchoolsAdapter(List<Schools> schoolList) {
        this.mSchoolList = schoolList;
    }

    @NonNull
    @Override
    public SchoolArrayAdapter onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);

        return new SchoolArrayAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolArrayAdapter schoolArrayAdapter, int position) {
        Schools schools = mSchoolList.get(position);
        /*SchoolsRequest request = new SchoolsRequest();
        Schools schools = new Schools(request.mSchoolsResponse.getDbn(), request.mSchoolsResponse.getSchoolName(),
                request.mSchoolsResponse.getNumOfSatTestTakers(), request.mSchoolsResponse.getSatCriticalReadingAvgScore(),
                request.mSchoolsResponse.getSatMathAvgScore(), request.mSchoolsResponse.getSatWritingAvgScore(), "");

        schoolArrayAdapter.dbn.setText(request.mSchoolsResponse.getDbn());
        schoolArrayAdapter.name.setText(request.mSchoolsResponse.getSchoolName());
        schoolArrayAdapter.boro.setText(request.mSchoolsResponse.getNumOfSatTestTakers());
        schoolArrayAdapter.overview.setText(request.mSchoolsResponse.getSatCriticalReadingAvgScore());
        schoolArrayAdapter.tenthSeats.setText(request.mSchoolsResponse.getSatMathAvgScore());
        schoolArrayAdapter.academicOpportunists1.setText(request.mSchoolsResponse.getSatWritingAvgScore());
        schoolArrayAdapter.academicOpportunists2.setText("");*/


        schoolArrayAdapter.dbn.setText(schools.getmDbn());
        schoolArrayAdapter.name.setText(schools.getmName());
        schoolArrayAdapter.boro.setText(schools.getmBoro());
        schoolArrayAdapter.overview.setText(schools.getmOverview());
        schoolArrayAdapter.tenthSeats.setText(schools.getmTenthSeats());
        schoolArrayAdapter.academicOpportunists1.setText(schools.getmAcademicOpportunists1());
        schoolArrayAdapter.academicOpportunists2.setText(schools.getmAcademicOpportunists2());
    }

    @Override
    public int getItemCount() {
        return mSchoolList.size();
    }

    public class SchoolArrayAdapter extends RecyclerView.ViewHolder {
        TextView dbn, name, boro, overview, tenthSeats, academicOpportunists1, academicOpportunists2;

        public SchoolArrayAdapter(@NonNull View itemView) {
            super(itemView);
            dbn = itemView.findViewById(R.id.tv_dbn);
            name = itemView.findViewById(R.id.tv_school_name);
            boro = itemView.findViewById(R.id.tv_schools_boro);
            overview = itemView.findViewById(R.id.tv_overview_paragraph);
            tenthSeats = itemView.findViewById(R.id.tv_school_10th_seats);
            academicOpportunists1 = itemView.findViewById(R.id.tv_accademic_opportunists1);
            academicOpportunists2 = itemView.findViewById(R.id.tv_accademic_opportunists2);
        }
    }
}
