package com.example.harneet.meminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity implements View.OnClickListener {

    private Button assignment;
    private Button course;
    private Button calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        assignment = (Button)
                findViewById(R.id.button_assignment);
        course = (Button)
                findViewById(R.id.button_course);
        calendar = (Button)
                findViewById(R.id.button_calendar);

        assignment.setOnClickListener(this);
        course.setOnClickListener(this);
        calendar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        if(v.getId() == R.id.button_assignment){
            Intent assignment = new Intent(Home.this, Assignments.class);
            startActivity(assignment);
        }
        if(v.getId() == R.id.button_course){
            Intent course = new Intent(Home.this, Courses.class);
            startActivity(course);
        }
        if(v.getId() == R.id.button_calendar){
            Intent calendar = new Intent(Home.this, Calendar.class);
            startActivity(calendar);
        }
    }
}
