package com.example.votingsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class questions extends AppCompatActivity {
        private Button button;
        private Button button1;
        private Button button2;
        private Button button3;
        private Button button4;
        private TextView  ta;
        private TextView  tb;
        private TextView  tc;
        private TextView  td;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_questions);

            button = (Button) findViewById(R.id.button3);
            button1 = (Button) findViewById(R.id.button5);
            button2 = (Button) findViewById(R.id.button6);
            button3 = (Button) findViewById(R.id.button7);
            button4= (Button) findViewById(R.id.button10);
            ta=findViewById(R.id.textView8);
            tb=findViewById(R.id.textView15);
            tc=findViewById(R.id.textView16);
            td=findViewById(R.id.textView17);
        }

        public void onClick4(View view)
        {
            String count1=ta.getText().toString().trim();
            int count=Integer.parseInt(count1);
            count++;
            ta.setText(String.valueOf(count));
        }

        public void onClick1(View view)
        {
            String count2=tb.getText().toString().trim();
            int count=Integer.parseInt(count2);
            count++;
            tb.setText(String.valueOf(count));
        }

        public void onClick2(View view)
        {
            String count3=tc.getText().toString().trim();
            int count=Integer.parseInt(count3);
            count++;
            tc.setText(String.valueOf(count));
        }



        public void onClick3(View view)
        {
            String count4=td.getText().toString().trim();
            int count=Integer.parseInt(count4);
            count++;
            td.setText(String.valueOf(count));
        }

        public  void  onClick5(View view)
        {
            openhomepage();
        }

        public void openhomepage()
        {

            Intent intent = new Intent(this, homepage.class);
            startActivity(intent);
        }


    }



