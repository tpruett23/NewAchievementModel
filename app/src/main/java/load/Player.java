package load;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
/**
 * The class represents the media player.
 * @author Melchor Dominguez
 */
public class Player {
    /**
     * The media player.
     */
    public static MediaPlayer mediaPlayer;
    /**
     * Constructor
     */
    public Player(Context context, int uri){
        mediaPlayer = MediaPlayer.create(context, uri);
    }
}
