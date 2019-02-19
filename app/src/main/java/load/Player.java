package load;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class Player {

    public static MediaPlayer mediaPlayer;

    public Player(Context context, int uri){
        mediaPlayer = MediaPlayer.create(context, uri);
    }
}
