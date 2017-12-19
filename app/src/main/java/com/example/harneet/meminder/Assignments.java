package com.example.harneet.meminder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Assignments extends Activity implements View.OnClickListener {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        back = (Button)
                findViewById(R.id.button_back_home);

        back.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.button_back_home) {
            Intent login = new Intent(Assignments.this,
                    Home.class);
            startActivity(login);
        }
    }

}
