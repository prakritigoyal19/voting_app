package com.example.votingsystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class create extends AppCompatActivity {

    private EditText question,choice1,choice2,choice3,choice4, name;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


    DatabaseReference ref;

    ref=FirebaseDatabase.getInstance().getReference("ms");



        question=(EditText)findViewById(R.id.editText);
        choice1=(EditText)findViewById(R.id.editText1);
        choice2=(EditText)findViewById(R.id.editText2);
        choice3=(EditText)findViewById(R.id.editText3);
        choice4=(EditText)findViewById(R.id.editText4);
        name= (EditText) findViewById(R.id.editText8);

        submit=(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                addques();
                openhome();
            }
        });
    }

    public void addques()
    {
        String q=question.getText().toString().trim();
        String a=choice1.getText().toString().trim();
        String b=choice2.getText().toString().trim();
        String c=choice3.getText().toString().trim();
        String d=choice4.getText().toString().trim();
        String e= name.getText().toString().trim();

        if(!TextUtils.isEmpty(q) && !TextUtils.isEmpty(a) && !TextUtils.isEmpty(b) && !TextUtils.isEmpty(c) && !TextUtils.isEmpty(d) && !TextUtils.isEmpty(e))
        {  String id =FirebaseDatabase.getInstance().getReference().push().getKey();

            ques questions=new ques(q,a,b,c,d);
            FirebaseDatabase.getInstance().getReference().child(e).setValue(questions);
            question.setText("");
            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");

        }
        else
        {
            Toast.makeText( create.this,"please type the question and 4 choice",Toast.LENGTH_LONG).show();
        }
    }

    public void openhome()
    {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }


}