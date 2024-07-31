package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.google.firebase.database.FirebaseDatabase;

public class Login_system extends AppCompatActivity {
    public static final String APPLICATION_ID = "319E692E-33D0-D3D8-FF74-425CDD1B6500";
    public static final String Secret_Key = "870316BB-0055-470C-9FCE-A151CBF7191E";
    private EditText firstNameEditText, lastNameEditText, usernameEditText, emailEditText, passwordEditText;
    private Button loginButton, signUpButton;
    private CheckBox stayLoggedInCheckBox;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_system);

        count = 0;


        String logged_in_user = Backendless.UserService.loggedInUser();
        Log.e("Login_System", "Logged in User" + logged_in_user);

        usernameEditText = findViewById(R.id.username_Edit_Text);
        passwordEditText = findViewById(R.id.password_Edit_Text);

        loginButton = findViewById(R.id.log_in_button);
        stayLoggedInCheckBox = findViewById(R.id.stay_Logged_In_Check_Box);
        loginButton.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        String userName = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Backendless.UserService.login(userName, password, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(Login_system.this, "Login Accepted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login_system.this, MainActivity.class);
                startActivity(intent);
                Login_system.this.finish();
                Log.e("Login_system", "Log In Successful");
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("LoginActivity", fault.toString());
                Log.e("LoginActivity", "UserName or Password is wrong");
                Toast.makeText(Login_system.this, "Email or Password Was Incorrect", Toast.LENGTH_SHORT).show();

                count += 1;
                Log.e("Login_System", "Count at " + count);

                if (count >= 3) {
                    Intent intent = new Intent(Login_system.this, MainActivity.class);
                    startActivity(intent);
                    count = 0;
                }
                stayLoggedInCheckBox.isChecked();
                passwordEditText.getText().clear();
            }
        });

        signUpButton.setOnClickListener(v1 -> {
            Toast.makeText(Login_system.this, "Transfer to the sign up screen", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login_system.this, Sign_up.class);
            startActivity(intent);
        }
        );

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast toast = new Toast(new Login_system().getIntent(Login_system.super.clone()));
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @NonNull
    private Context getIntent(Object clone) {
        AppCompatActivity s = new AppCompatActivity();
        return s;
    }
}