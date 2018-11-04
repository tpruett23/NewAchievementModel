package com.example.toripruett.newachievementmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Achievements> {
    private ArrayList<Achievements> achievements;
    private Context context;

    int viewSource;
    int viewSource2;


    public CustomListAdapter(Context context, int tvri, int tvri2, ArrayList<Achievements> achievements){
        super(context,tvri,achievements);
        this.context = context;
        this.achievements = achievements;
        viewSource = tvri;
        viewSource2 = tvri2;

    }
    public View getView(int position, View listItemView, ViewGroup parent){

        View v = listItemView;

        if (v == null)//Only create if null - recycling a good idea
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(viewSource, parent,false);

        }


        //Get the views from the list item XML
        TextView bTitle = (TextView) v.findViewById(R.id.txtTitle);
        ImageView iButton = (ImageView)	v.findViewById(R.id.ImageButton);

        //set the drawable on the image button.

        //iButton.setImageDrawable();//##CHANGE
       // iButton.setBackgroundDrawable(null);

        //Set texts on views
        bTitle.setText(achievements.get(position).getName());

        return (v);//Return the layout view populated with data.

    }//=====================================


}

