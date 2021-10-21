package Lesson_HW;

public class Team {


    private static String teamName = "ОРЛЕНОК";
    Student Sasha = new Boy("Саша", 12, 170);
    Student Pasha = new Boy("Паша", 14, 165);
    Student Dasha = new Girl("Даша", 11, 130);
    Student Masha = new Girl("Маша", 9, 140);
    Student[] team = {Sasha, Pasha, Dasha, Masha};
    Course Course = new Course();

    public Team() {
        teamMembers(team);
         doCourse( Course.getCourse(), team );


    }

    public static void teamMembers(Student[] team) {
        for (int i = 0; i < 4; i++)
            System.out.println("Участник команды " + teamName + " " + team[i].getData());
        System.out.println(("*************************************"));
    }

    public static void doCourse(int[] course, Student[] team) {

        for (int i = 0; i < 4; i++) {
            if ((course[0] <= team[i].getRunDistance()) && (Math.max(course[1], course[2]) <= team[i].getJumpHeight() ))
                System.out.println(" Участник команды " + teamName + " " + team[i].getName() + " сумел преодолеть оба барьера, высотой " + course[1] + " и " + course[2] + " см и пробежать дистанцию длиной " + course[0] + " км.");
        }

    }
}

