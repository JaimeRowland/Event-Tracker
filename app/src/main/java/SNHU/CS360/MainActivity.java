package com.example.eventtracker;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // create edittext, button and dbhandler variables
    private EditText editTextUsername, editTextTextPassword;
    private Button buttonCreateUser, buttonLogin;
    appDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // variables are initalized
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonCreateUser = findViewById(R.id.buttonCreateUser);
        buttonLogin = findViewById(R.id.buttonLogin);
    }
    public void RegisterClick(View v) {
        EditText usernameText = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        String nameTextValue = usernameText.getText().toString();
        String passwordTextValue = passwordText.getText().toString();
        if (!checkLogin(nameTextValue, passwordTextValue)) {
            createUser(nameTextValue, passwordTextValue);

        }
    }
    public void LoginClick(View v) {
        EditText usernameText = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        String nameTextValue = usernameText.getText().toString();
        String passwordTextValue = passwordText.getText().toString();
        if (checkLogin(nameTextValue, passwordTextValue)) {
            setContentView(R.layout.login);
        }
    }

    public boolean checkLogin(String username, String password){

        db.addUser(username,password);
        return username != null;
    }

    private void createUser(String username, String password){

        User user = new User();
        user.userName = username;
        user.password = password;

    }
}


