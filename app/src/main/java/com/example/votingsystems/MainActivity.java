package com.example.votingsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button9);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openstart();
            }});

    }

    public void openstart() {
        Intent intent = new Intent(this, page2.class);
        startActivity(intent);
    }
}
