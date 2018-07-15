package com.example.mushfiqurrahman.classscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Button  bRegisternow;
    EditText    etName,etUsername,etPassword,etSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText)findViewById(R.id.new_name);
        etUsername = (EditText)findViewById(R.id.new_user_name);
        etPassword = (EditText)findViewById(R.id.new_pass);
        etSession = (EditText)findViewById(R.id.session);
        bRegisternow = (Button)findViewById(R.id.regButton);

        bRegisternow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case    R.id.regButton:

                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String session = etPassword.getText().toString();

                User user = new User(name, username, password);
                User user1 = new User(session);

                registerUser(user);

                break;

        }
    }

    private void registerUser(User user){

        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                startActivity(new Intent(RegisterActivity.this,SecondActivity.class));
            }
        });


    }
}
