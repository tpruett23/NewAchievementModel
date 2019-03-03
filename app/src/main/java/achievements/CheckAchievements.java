package achievements;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import achievements.Achievements;
import screens.UserCompleted;

public interface CheckAchievements {
    Context context = null;

    boolean checkAchievement(Achievements ach);

}



