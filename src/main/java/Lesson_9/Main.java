package Lesson_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main  {

public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
       // Course course = new Course();

        Course physics = new Course ("Физика");
        Course chemistry = new Course ("Химия");
        Course math = new Course ("Математика");
        Course literature = new Course ("Литература");
        Course history = new Course ("История");
        Course biology = new Course("Биология");
        Course geography = new Course("География");
        studentList.add ( new Student("Иванов", Arrays.asList (geography, math, literature, history,biology )));
        studentList.add ( new Student("Петров", Arrays.asList ( math, chemistry, history,biology )));
        studentList.add ( new Student("Сидоров", Arrays.asList (physics, math, literature, history,biology, geography )));
        studentList.add ( new Student("Михайлов", Arrays.asList ( physics, literature, history)));
        studentList.add ( new Student("Викторов", Arrays.asList (physics, math, geography,  literature, history,biology,chemistry )));

        System.out.println("1. Список курсов, посещаемых студентами: ");
        System.out.println(  studentList.stream()
        .map(s->s.getCourseList())
        .flatMap(c -> c.stream())
        .collect(Collectors.toSet()));

        System.out.println(" 2.Три самых любознательных студента:");

        System.out.println(studentList.stream()
        .sorted((s1,s2) -> s2.getCourseList().size() - s1.getCourseList().size())
        .limit(3)
        .collect(Collectors.toList()));

          studentsCourse( studentList, physics );
           studentsCourse( studentList,  math );

        }

       public static void studentsCourse (List<Student> students, Course course ){
    System.out.println("3.Студенты, посещающие курс \" " + course + "\":");
        System.out.println (students.stream()
                .filter(s -> s.getCourseList()
                            .contains(course))
                        .collect(Collectors.toList())); }
        }
