package Lesson_HW;

import java.util.Random;

public class Course {
    public static Random random = new Random();

    private int distance;
    private int height_1;
    private int height_2;
    private int[] course;



    public Course() {

    distance = randomValue( 9, 16);

    height_1 = randomValue( 120, 150);

    height_2 = randomValue(120, 150);

    course = new int[] {distance, height_1, height_2};

    }


    public static  int randomValue(int value1, int value2) {
        int tmp = value2 - value1;
        return value1 + random.nextInt(tmp + 1);
    }

    public int[] getCourse() {
        return course;
    }
    }

