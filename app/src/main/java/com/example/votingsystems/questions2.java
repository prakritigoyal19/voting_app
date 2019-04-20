package com.example.votingsystems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class questions2 extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<ques> list;
    ArrayAdapter <ques> adapter;
    ques ques1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);
        listView=(ListView) findViewById(R.id.list_view2);
        database= FirebaseDatabase.getInstance();
        ref= database.getReference().child("ms");
        list= new ArrayList<>();
        adapter= new ArrayAdapter<ques>(this, R.layout.activity_list_view2, list);
        ques1= new ques();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    ques1 = ds.getValue(ques.class);
                    list.add(ques1);
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){}
        });
    }
}
