package Lesson_HW;

public class Team {


    private static String teamName = "ОРЛЕНОК";
    Lesson_HW.Student Sasha = new Lesson_HW.Boy("Саша", 12, 170);
    Lesson_HW.Student Pasha = new Lesson_HW.Boy("Паша", 14, 165);
    Lesson_HW.Student Dasha = new Lesson_HW.Girl("Даша", 11, 130);
    Lesson_HW.Student Masha = new Lesson_HW.Girl("Маша", 9, 140);
    Lesson_HW.Student[] team = {Sasha, Pasha, Dasha, Masha};
    Lesson_HW.Course Course = new Lesson_HW.Course();

    public Team() {
        teamMembers(team);
         doCourse( Course.getCourse(), team );


    }

    public static void teamMembers(Lesson_HW.Student[] team) {
        for (int i = 0; i < 4; i++)
            System.out.println("Участник команды " + teamName + " " + team[i].getData());
        System.out.println(("*************************************"));
    }

    public static void doCourse(int[] course, Lesson_HW.Student[] team) {

        for (int i = 0; i < 4; i++) {
            if ((course[0] <= team[i].getRunDistance()) && (Math.max(course[1], course[2]) <= team[i].getJumpHeight() ))
                System.out.println(" Участнику команды " + teamName + " по имени "  + team[i].getName() + " удалось преодолеть оба барьера, высотой " + course[1] + " и " + course[2] + " см и пробежать дистанцию длиной " + course[0] + " км.");
        }

    }
}

