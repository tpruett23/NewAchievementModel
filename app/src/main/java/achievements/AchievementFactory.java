package achievements;

public class AchievementFactory {
   UserInfo UI = new UserInfo();
   UserCompleted UC = new UserCompleted();
   boolean checked = false;


    static Steps steps = new Steps();
    static Trails trails = new Trails();
    static Question question = new Question();
    static Challenges challenges = new Challenges();
    static Distance distance = new Distance();
    static Time time = new Time();
    static Speed speed = new Speed();



    public AchievementFactory() {
        if(checked == false) {
            addCompleted();
        }
    }

  public void addCompleted(){
       boolean see = trails.checkCompleted(UC.getTrails());
     if(trails.checkCompleted(UC.getTrails())){
         UI.completed.add(trails);
      }
      if(speed.checkCompleted(UserInfo.getSpeed())){
          UI.completed.add(speed);
      }
      if(steps.checkCompleted(UserInfo.getSteps())){
         UI.completed.add(steps);
      }
      if(question.checkCompleted(UC.getQuestionsCorrect())){
         UI.completed.add(question);
      }

      if(distance.checkCompleted(UserInfo.getTotalDistance())){
          UI.completed.add(distance);
      }
      if(challenges.checkCompleted(UC.getChallenges())){
          UI.completed.add(challenges);
      }
      if(time.checkCompleted(UserInfo.getTimePlayed())){
          UI.completed.add(time);
      }
      checked = true;

        }



    }

