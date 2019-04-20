package com.example.votingsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Date;

public class signingup extends AppCompatActivity {

    private EditText email, password, name;
    String Name, Email, Password;
    private FirebaseAuth mAuth;
    Button button;
    DatabaseReference mdatabase;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signingup);
        email = (EditText) findViewById(R.id.editText6);
        password = (EditText) findViewById(R.id.editText9);
        name = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button5);
        mDialog = new ProgressDialog(this);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegister();
                openhomepage();
            }
        });


    }

    public void openhomepage() {


        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }

    private void UserRegister() {
        Name = name.getText().toString().trim();
        Password = password.getText().toString().trim();
        Email = email.getText().toString().trim();

        if (TextUtils.isEmpty(Name)) {
            Toast.makeText(signingup.this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(Email)) {
            Toast.makeText(signingup.this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(Password)) {
            Toast.makeText(signingup.this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        } else if (Password.length() < 6) {
            Toast.makeText(signingup.this, "Passwor must be greater then 6 digit", Toast.LENGTH_SHORT).show();
            return;
        }
        mDialog.setMessage("Creating User please wait...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    sendEmailVerification();
                    mDialog.dismiss();
                    OnAuth(task.getResult().getUser());
                    mAuth.signOut();
                } else {
                    Toast.makeText(signingup.this, "error on creating user", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

        private void sendEmailVerification() {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signingup.this, "Check your Email for verification", Toast.LENGTH_SHORT).show();
                            FirebaseAuth.getInstance().signOut();
                        }
                    }
                });
            }
        }

        private void OnAuth (FirebaseUser user) {
            createAnewUser(user.getUid());
        }

    private void createAnewUser(String uid) {
        User user = BuildNewuser();
        mdatabase.child(uid).setValue(user);
    }

    private User BuildNewuser(){
        return new User(
                getDisplayName(),
                getUserEmail(),
                new Date().getTime()
        );
    }
    public String getDisplayName() {
        return Name;
    }

    public String getUserEmail() {
        return Email;
    }
}
