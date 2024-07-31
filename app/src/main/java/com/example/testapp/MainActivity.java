package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Backendless s;
    private Button signup;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Run wonder = new Run();
        wonder.setDistance("ten");
        wonder.setMood("sad"); //allow the user to select an emoji


        }
    public void checkCurrentUser() {
        // [START check_current_user]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.getEmail();

        } else {
            // No user is signed in
        }
        // [END check_current_user]
    }
        /**Backendless.Data.of(Run.class).save(wonder, new AsyncCallback<Run>() {
            @Override
            public void handleResponse(Run response) {
                Intent intent = new Intent(MainActivity.this, Sign_up.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "welcome to the website", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
            }
        }**/;
    }