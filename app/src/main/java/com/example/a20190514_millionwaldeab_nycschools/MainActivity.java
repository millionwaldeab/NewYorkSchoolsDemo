package com.example.a20190514_millionwaldeab_nycschools;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mSchoolHolder;
    private SchoolsAdapter mSchoolsAdapter;
    @VisibleForTesting
    protected List<Schools> mSchoolsList = new ArrayList<>();
    private DialogInterface mDialog;
    @VisibleForTesting
    protected Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSchoolHolder = findViewById(R.id.rv_schools);
        mSchoolsAdapter = new SchoolsAdapter(mSchoolsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mSchoolHolder.setLayoutManager(layoutManager);
        mSchoolHolder.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mSchoolHolder.setItemAnimator(new DefaultItemAnimator());
        mSchoolHolder.setAdapter(mSchoolsAdapter);
        mPresenter = new Presenter();

        /*This populates the recyclerview with hard coded data*/
        //populateRecyclerView();

        populateRecyclerViewFromApi();

        mSchoolHolder.addOnItemTouchListener(new SchoolsItemTouch(getBaseContext(), mSchoolHolder, new ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Schools school = mSchoolsList.get(position);
                addToDialog(school);

            }
        }));
    }

    /**
     * This will populate the recyclerview from Api data requested by the data layer
     * */
    private void populateRecyclerViewFromApi() {
        mSchoolsList.add(mPresenter.getSchoolName());
        mSchoolsAdapter.notifyDataSetChanged();
    }

    /*This is to show a dialog when a user selects on school.*/
    @VisibleForTesting
    protected void addToDialog(Schools school) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.schoolTitle));
        builder.setMessage(school.getmDbn() + "/n" + school.getmName() + "/n" + school.getmBoro() + "/n" + school.getmOverview() + "/n" +
                school.getmTenthSeats() + "/n" + school.getmAcademicOpportunists1() + "/n" + school.getmAcademicOpportunists2());

        builder.setPositiveButton(getResources().getString(R.string.continue_viewing), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialog = dialog;
                mDialog.dismiss();
            }
        });

        builder.setNegativeButton(getResources().getString(R.string.cancel_dialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialog = dialog;
                mDialog.dismiss();
            }
        });

        builder.create();
        builder.show();
    }

    /*This is hardcoded data to populate the Recyclerview because the requirement wasn't clear whether to
    * exract the data from a Rest Api or not. If that was tha case then there is a data layer implemented
    * to host a network package that will handle exceptions and data mapping to the Presenter layer and also
    * data layer Constants..etc; the Presenter layer would then populate the Recyclerview by replacing this
    * ridiculous hard coded implementation.*/
    @VisibleForTesting
    protected void populateRecyclerView() {
        Schools school = new Schools("02M260", "Clinton School Writers & Artists, M.S. 260", "M", "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analytically and write creatively. Our arts programming builds on our 25 years of experience in visual, performing arts and music on a middle school level. We partner with New Audience and the Whitney Museum as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.\n", "1", "Free college ", "International");
        mSchoolsList.add(school);

        school = new Schools("21K728", "Liberation Diploma Plus High School", "K", "The mission of Liberation Diploma Plus Hig", "1", "Learning to Work, Student Council, Advisory Leadership, School Newspaper, Community Service Group, School Leadership Team, Extended Day/PM School, College Now\n" +
                "CAMBA, Diploma Plus, Medgar Evers College, Coney Island Genera on Gap, Urban Neighborhood Services, Coney Island Coalition Against Violence, I Love My Life Initiative, New York City Police Department\n" +
                "The Learning to Work (LTW) partner for Liberation Diploma Plus High School is CAMBA.\n" +
                "English as a New Language\n" +
                "French, Spanish\n" +
                "Seagate-Coney Island\n", "CAMBA, Diploma Plus, Medgar Evers College, Coney Island Gen");
        mSchoolsList.add(school);

        school = new Schools("08X282", "Women's Academy of Excellence", "X", "The WomenÂ’s Academy of Excellence is", "", "Genetic Research Seminar, Touro College Partnership, L'Or", "WAE Bucks Incentive Program, Monroe College JumpStart, Nation");
        mSchoolsList.add(school);

        school = new Schools("17K548", "Brooklyn School for Music & Theatre", "K", "Brooklyn School for Music & Theatre (BS", "1", "CTE program(s) in: Arts, A/V Technology & Communication", "iLearnNYC: Program for expanded online coursework and self" );
        mSchoolsList.add(school);

        school = new Schools("27Q314", "Epic High School - South", "K", "Epic High School Â– South, an outgrowth", "", "Culturally relevant practices; Blended instruction with both","Real-world problem-based learning, Student choice on elective c");
        mSchoolsList.add(school);

        mSchoolsAdapter.notifyDataSetChanged();
    }

    /*Recyclerview item click listenter*/
    public interface ClickListener{
        void onItemClick(View view, int Position);
    }

    /*Recyclerview item touch listener*/
    public interface TouchListener{
        void onItemTouch();
    }

    /*Custom touch listener to respond touch events in the recyclerview item. */
    public class SchoolsItemTouch implements RecyclerView.OnItemTouchListener{
        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public SchoolsItemTouch(Context context, final RecyclerView recyclerView, final ClickListener clickListener){
            this.clickListener = clickListener;
            this.gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                @Override
                public void onShowPress(MotionEvent e) {

                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    return false;
                }
            });
        }
        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if(child != null && clickListener != null && gestureDetector.onTouchEvent(motionEvent)){
                clickListener.onItemClick(child, recyclerView.getChildLayoutPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if(child != null && clickListener != null){
                clickListener.onItemClick(child, recyclerView.getChildLayoutPosition(child));
            }
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean b) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*This is clean up and prevent memory leak due to dialog staying after the system destroys the activity before user selects
        * positive or negative button of the dialog, which could dismiss the dialog.*/
        if(mDialog != null){
            mDialog.dismiss();
        }
    }
}
