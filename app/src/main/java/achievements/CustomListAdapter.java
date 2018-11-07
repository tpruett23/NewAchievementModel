package achievements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

import java.util.ArrayList;

import achievements.AchievementDescriptor;

public class CustomListAdapter extends ArrayAdapter<AchievementDescriptor> {
    private ArrayList<AchievementDescriptor> achievements;
    private Context context;

    int viewSource;
    int viewSource2;


    public CustomListAdapter(Context context, int tvri, int tvri2, ArrayList<AchievementDescriptor> achievements){
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



        //Set texts on views
        bTitle.setText(achievements.get(position).getName());

        return (v);//Return the layout view populated with data.

    }//=====================================


}

