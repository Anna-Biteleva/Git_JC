package Lesson_HW;

   public class Student {
       protected String name;
       protected int runDistance;
       protected int jumpHeight;

       public Student(String name, int runDistance, int jumpHeight) {
           this.name = name;
           this.runDistance = runDistance;
           this.jumpHeight = jumpHeight;

       }

       public String getData() {
           return ( "Ученик"+ name + ", который может пробежать " + runDistance + " км и преодолеть барьер высотой " + jumpHeight + " см." );
       }

       public String getName() {
           return name;
       }

       public int getRunDistance() {
           return runDistance;
       }

       public int getJumpHeight() {
           return jumpHeight;
       }
   }