package com.example.harneet.meminder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class Create_Account extends Activity implements OnClickListener {

    private Button create_AccountButton;
    private Button backButton;

    private User_Create_Account user_create_account;
    private User_Create_Account_AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = User_Create_Account_AppDatabase.getDatabase(getApplicationContext());

        database.user_create_account_dao().removeAllUsers();

        List<User_Create_Account> user_create_accounts = database.user_create_account_dao().getAllUser();
        if (user_create_accounts.size() == 0) {
            database.user_create_account_dao().addUser(new User_Create_Account(1, "Harneet",
                    "Saini", "harneet9saini@gmail.com", "123456",
                    "123456"));
            user_create_account = database.user_create_account_dao().getAllUser().get(0);
        }

        create_AccountButton = (Button)
                findViewById(R.id.register);
        backButton = (Button)
                findViewById(R.id.backButton);

        create_AccountButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

        Toast m = Toast.makeText(this, "Welcome to MeMinder app", Toast.LENGTH_SHORT);
        m.show();


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.register){
            Intent login = new Intent(Create_Account.this,
                    Home.class);
            startActivity(login);
        }
        else if(v.getId() == R.id.backButton){
            Intent create = new Intent(Create_Account.this,
                    Login.class);
            startActivity(create);
        }
    }
}