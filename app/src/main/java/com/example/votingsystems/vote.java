package com.example.votingsystems;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class vote extends ArrayAdapter<ques>
{
    private Activity context;
    private List<ques> quesList;
    public vote (Activity context,List<ques>quesList)
    {
        super(context,R.layout.activity_list_view2,quesList);
        this.context= context;
        this.quesList= quesList;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View listView= inflater.inflate(R.layout.activity_list_view2,null,  true);

        TextView q=(TextView)listView.findViewById(R.id.editText);
        TextView a=(TextView) listView.findViewById(R.id.editText1);
        TextView b=(TextView) listView.findViewById(R.id.editText2);
        TextView c=(TextView) listView.findViewById(R.id.editText3);
        TextView d=(TextView) listView.findViewById(R.id.editText4);

        ques questions=quesList.get(position);
        q.setText(questions.getq());
        a.setText(questions.geta());
        b.setText(questions.getb());
        c.setText(questions.getc());
        d.setText(questions.getd());

        return listView;
    }
}
