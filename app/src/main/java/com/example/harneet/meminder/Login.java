package com.example.harneet.meminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;


public class Login extends Activity implements OnClickListener {

    private Button logInButton;
    private Button createAccountButton;

    private User_Login user_login;
    private User_Login_AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = User_Login_AppDatabase.getDatabase(getApplicationContext());

        database.user_login_dao().removeAllUsers();

        List<User_Login> user_logins = database.user_login_dao().getAllUser();
        if (user_logins.size() == 0) {
            database.user_login_dao().addUser(new User_Login(1, "Hsaini7844", "123456"));
            user_login = database.user_login_dao().getAllUser().get(0);
        }

        logInButton = (Button)
                findViewById(R.id.logInButton);
        createAccountButton = (Button)
                findViewById(R.id.createAccountButton);

        logInButton.setOnClickListener(this);
        createAccountButton.setOnClickListener(this);

        Toast m = Toast.makeText(this, "Welcome to MeMinder app", Toast.LENGTH_SHORT);
        m.show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.logInButton){
            Intent login = new Intent(Login.this,
                    Home.class);
            startActivity(login);
        }
        else if(v.getId() == R.id.createAccountButton){
            Intent create = new Intent(Login.this,
                    Create_Account.class);
            startActivity(create);
        }

        /*switch (v.getId()) {
            case R.id.logInButton:
                Intent login = new Intent(LoginActivity.this,1
                        Home.class);
                startActivity(login);
                break;
            case R.id.createAccountButton:
                Intent create = new Intent(LoginActivity.this,
                        Create_Account.class);
                startActivity(create);
                break;
        }*/
    }
}