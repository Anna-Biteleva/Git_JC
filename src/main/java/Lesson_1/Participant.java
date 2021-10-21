package Lesson_1;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

 /* class Participant  {
  private static String teamName = "School team";
     private String name;
      private int runDistance;
      private int jumpHeight;
      Participant [] team = new Participant[];


    public Participant (String name, int runDistance, int jumpHeight){
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;


        Participant num1= new Participant("Саша", 12, 180);
        Participant num2 = new Participant("Петя", 14, 160);
        Participant num3 = new Participant("Маша", 11, 120);
        Participant num4 = new Participant("Даша", 10, 130);

        Participant[] team = {num1, num2, num3, num4};}



    public String getData() {
        return ( name + ", который может пробежать " + runDistance + " км и преодолеть барьер высотой " + jumpHeight + " см." );
    }

    public static void teamMembers(Participant[] team) {
        for (int i = 0; i < 4; i++)
            System.out.println("Участник команды " + teamName + " " + team[i].getData());
    }




    /*@Override
    public void run(int runLength) {
  System.out.println( name  + "   может пробежать  " + runDistance + " км.");
    }

    @Override
    public void jump(int jumpHeight) {
        System.out.println(  name + " может прыгнуть на " + jumpHeight + " см." );

    }*/



