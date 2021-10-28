package Lesson_3;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
       Integer[] intArr = {1,3,5 };
        System.out.println(Arrays.toString(intArr));
       int i = intArr[2];
       intArr[2] = intArr[1];
       intArr[1] = i;
       System.out.println(Arrays.toString(intArr));

    }

}
