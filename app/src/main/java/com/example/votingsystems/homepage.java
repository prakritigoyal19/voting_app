package com.example.votingsystems;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class homepage extends AppCompatActivity {

    private Button button;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        button = (Button) findViewById(R.id.button);
        button3 = (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencreate();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openquestions();

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteAppData();
            }
        });
    }


    public void opencreate() {
        Intent intent = new Intent(this, create.class);
        startActivity(intent);
    }


    public void openquestions() {
        Intent intent = new Intent(this, questions.class);
        startActivity(intent);
    }


    //public void deleteAppData() {
      //  try {
            // clearing app data
        //    String packageName = getApplicationContext().getPackageName();
          //  Runtime runtime = Runtime.getRuntime();
            //runtime.exec("pm clear "+packageName);

       // } catch (Exception e) {
         //   e.printStackTrace();
        //} }

    public void deleteAppData()
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}