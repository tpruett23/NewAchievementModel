package achievements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

import java.sql.Array;
import java.util.ArrayList;

import achievements.AchievementDescriptor;

/**
 * The class is the adapter to display the arraylist of achievement descriptors in the listview.
 *
 * @author Tori Pruett
 * @version 1.0
 */
public class CustomListAdapter extends ArrayAdapter<Achievements> {
    /**
     * ArrayList of positions to disable in the arraylist.
     */
    ArrayList<Integer> positions_to_disable = new ArrayList<>();
    /**
     * The arraylist of achievements.
     **/
    private ArrayList<Achievements> achievements;

    /**
     * The context needed for the adapter.
     **/
    private Context context;

    /**
     * The viewsource needed for the adapter.
     **/
    int viewSource;

    /**
     * The second viewsource needed for the adapter.
     **/
    int viewSource2;

    /**
     * Constructor for the CustomListAdapter.
     *
     * @param context
     * @param tvri
     * @param tvri2
     * @param achievements
     */
    public CustomListAdapter(Context context, int tvri, int tvri2, ArrayList<Achievements> achievements) {
        super(context, tvri, achievements);
        this.context = context;
        this.achievements = achievements;
        viewSource = tvri;
        viewSource2 = tvri2;
        //positions_to_disable.add(0);
       // positions_to_disable.add(2);

    }

    /**
     * Inflates the arraylist into the listview.
     *
     * @param position     The position in the listview.
     * @param listItemView The listview.
     * @param parent       The parent used to inflate.
     * @return The View.
     */
    public View getView(int position, View listItemView, ViewGroup parent) {

        View v = listItemView;

        if (v == null)//Only create if null - recycling a good idea
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(viewSource, parent, false);

        }


        //Get the views from the list item XML
        TextView bTitle = (TextView) v.findViewById(R.id.txtTitle);
        ImageView iButton = (ImageView) v.findViewById(R.id.ImageButton);


        //Set texts on views
        bTitle.setText(achievements.get(position).getName());
        v.setEnabled(false);

        return (v);//Return the layout view populated with data.

    }//=====================================

    /**
     * Not implemented yet, but method to disable achievements not been completed.
     * @param position The position of the disabled achievement.
     * @return
     */
    @Override
    public boolean isEnabled(int position) {


        for (int j = 0; j < positions_to_disable.size(); j++) {
            if (position == positions_to_disable.get(j)) {
                return false;
            }

        }
        return super.isEnabled(position);
    }


}

