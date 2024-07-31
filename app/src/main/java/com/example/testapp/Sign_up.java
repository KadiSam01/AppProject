package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {
    
    private EditText firstNameEditText, lastNameEditText, usernameEditText, emailEditText, passwordEditText;
    private Button signUpButton, cancelSignUpButton, LoginButton;
    private CheckBox stayLoggedInCheckBox;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       // setContentView(R.layout.activity_login_system);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        firstNameEditText = findViewById(R.id.firstName_Edit_Text);
        lastNameEditText = findViewById(R.id.lastName_Edit_Text);
        usernameEditText = findViewById(R.id.username_Edit_Text);
        emailEditText = findViewById(R.id.email_Edit_Text);
        passwordEditText = findViewById(R.id.password_Edit_Text);
        signUpButton = findViewById(R.id.sign_up_button);
        cancelSignUpButton = findViewById(R.id.cancel_Sign_Up_Button);
        LoginButton = findViewById(R.id.log_in_button);
       // stayLoggedInCheckBox = findViewById(R.id.stay_Logged_In_Check_Box);

        signUpButton.setOnClickListener(v -> {
            String firstName = firstNameEditText.getText().toString();
            String lastName = lastNameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String username = usernameEditText.getText().toString();


            boolean first_name = !firstName.isEmpty();
            boolean last_name = !lastName.isEmpty();
            boolean email_name = !email.isEmpty();
            boolean password_name = !password.isEmpty();
            boolean user_name = !username.isEmpty();

            if(first_name && last_name && email_name && password_name && user_name){
                // do not forget to call Backendless.initApp when your app initializes

                BackendlessUser user = new BackendlessUser();
                user.setProperty("firstName", firstName);
                user.setProperty("lastName", lastName);
                user.setPassword(password);
                user.setEmail(email);
                user.setProperty("username", username);

                Backendless.UserService.register( user, new AsyncCallback<BackendlessUser>()
                {
                    public void handleResponse( BackendlessUser response )
                    {
                        Intent intent = new Intent(Sign_up.this, Login_system.class);
                        startActivity(intent);
                        Toast.makeText(Sign_up.this, response.getEmail() + "was registered", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.e("Sign_Up", fault.toString());

                    }
                });


            }
            emailEditText.getText().clear();
            passwordEditText.getText().clear();
            usernameEditText.getText().clear();
        });

        while(cancelSignUpButton.callOnClick()){
            cancelSignUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Sign_up.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        }
       /* while(usernameEditText.equals(usernameEditText.getText().toString())){
           BackendlessUser user = new BackendlessUser();
           user.getUserId().
        }*/

    }

}
