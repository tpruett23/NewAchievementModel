package com.example.toripruett.newachievementmodel;

public class AchievementFactory {
     static Achievements one ;
    static Achievements five;
    static Achievements flower;
    static Achievements hour;
    static boolean checked = false;






  public AchievementFactory(){

      one = new Achievements("1 Mile", 10,1.0);
      five = new Achievements("5 Miles", 15, 5.0);
      flower = new Achievements("Found Flower", 5, 0);
      hour = new Achievements("1 Hour", 15, 0);


      add();

  }

  public  static void add() {
      ListViewAchv.addAch(one);
      ListViewAchv.addAch(five);
      ListViewAchv.addAch(flower);
      ListViewAchv.addAch(hour);

      UserInfo.setTotalDistance(7);
      UserInfo.setTimePlayed(5);

      if (!checked) {
          checkAch();
      }
  }

  public static void checkAch(){
      double num = UserInfo.getTotalDistance();

      if(UserInfo.getTotalDistance() > 1 && UserInfo.getTotalDistance() < 5){
          UserInfo.addCompleted(one);
      }

      if(num > 5){
          UserInfo.addCompleted(five);
          UserInfo.addCompleted(one);

      }

      /*else if(foundFlower() == true){
          UserInfo.addCompleted(flower);
      }*/
      if(UserInfo.getTimePlayed() >= 1.0);
      UserInfo.addCompleted(hour);

      checked = true;

  }



}
