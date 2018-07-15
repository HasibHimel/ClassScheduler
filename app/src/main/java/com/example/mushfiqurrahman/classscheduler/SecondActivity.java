package com.example.mushfiqurrahman.classscheduler;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button blogin,bregister;
    EditText etUsername,etPassword;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etUsername = (EditText)findViewById(R.id.user_nameid);
        etPassword = (EditText)findViewById(R.id.user_pass);
        blogin = (Button)findViewById(R.id.loginButton);
        bregister = (Button)findViewById(R.id.registerButton);

        blogin.setOnClickListener(this);
        bregister.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case    R.id.loginButton:

                    String username = etUsername.getText().toString();
                    String password = etPassword.getText().toString();

                    User user = new User(username, password);

                    authenticate(user);

                    userLocalStore.storeUserData(user);
                    userLocalStore.setUserLoggedIn(true);

                    break;

            case    R.id.registerButton:
                startActivity(new Intent(this,RegisterActivity.class));
                    break;

        }
    }

    private void authenticate(User user){

        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if(returnedUser == null){
                    showErrorMessage();
                }
                else {
                    logUserIn(returnedUser);
                }
            }
        });

    }

    private void showErrorMessage(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SecondActivity.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser){
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SecondActivity.this);
        dialogBuilder.setMessage("Successfull");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();

    }
}
