package com.example.votingsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page2 extends AppCompatActivity {
    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openlogin();
            }});
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });

        }

        public void openlogin(){
         Intent intent = new Intent(this, login.class);
         startActivity(intent);
        }

        public void opensignup(){
        Intent intent = new Intent(this, signingup.class);
        startActivity(intent);
        }
}
