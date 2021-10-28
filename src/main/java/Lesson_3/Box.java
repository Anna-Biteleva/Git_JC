package Lesson_3;

import jdk.internal.icu.text.UnicodeSet;


import java.util.ArrayList;
import java.util.Random;


public class Box <T extends Fruit > implements Comparable {

    private  ArrayList<T> fruitList = new ArrayList<>();


    public static Random random = new Random();
    private float boxWeight;


    public Box() {

    }


    public static void main(String[] args) {
        Apple apple = new Apple(1.0f);
        Orange orange = new Orange(1.5f);

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox_1 = new Box<>();


        System.out.print("Заполняем коробку с яблоками - ");
        appleBox.fillBox(apple, appleBox);

        System.out.print("Заполняем коробку с апельсинами - ");
        orangeBox.fillBox(orange, orangeBox);

        System.out.print("Коробка с яблоками весит ");
        appleBox.boxWeight(apple);
        System.out.print("Коробка с апельсинами весит ");
        orangeBox.boxWeight(orange);
        System.out.println("Правда ли,что коробки весят одинаково:");

        System.out.println((appleBox.compareTo(orangeBox) == 0) ? true : false);

        System.out.println("Пересыпаем яблоки в новую коробку:");

        appleBox.replace (appleBox_1, apple);

    }

    public void fillBox(T fruit, Box fruitBox) {
        for (int i = 1; i <= randomValue(7, 20); i++)
            fruitList.add(fruit);
        System.out.println("В ней поместилось " + fruitList.size() + " фруктов.");

    }

    public void boxWeight(Fruit fruit) {

        boxWeight = fruit.getWeight() * fruitList.size();
        System.out.println(boxWeight);

    }


     public void replace ( Box box,Fruit fruit){
       for  (int i = 0; i < fruitList.size() ; i++){
           box.fruitList.add(fruit);
           fruitList.set(i, null);
        }
  System.out.println( "В результате, в новой коробке "  + box.fruitList.size() + " яблок, а в прежней  - " + fruitList  );


}

    public static int randomValue(int value1, int value2) {
        int tmp = value2 - value1;
        return value1 + random.nextInt(tmp + 1);

    }


    @Override
    public int compareTo( Object o) {
        return (int) (((Box)o).boxWeight - boxWeight)*10;
    }


}



