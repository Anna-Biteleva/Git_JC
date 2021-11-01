package Lesson_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<Integer, String> phoneMap = new HashMap<>();

    public PhoneBook() {

    }

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Добавляем записи в телефонный справочник:");

        phoneBook.add(123, "Иванов");
        phoneBook.add(456, "Петров");
        phoneBook.add(256, "Иванов");
        phoneBook.add(289, "Петров");


        for (Map.Entry<Integer, String> o : phoneBook.phoneMap.entrySet()) {
            System.out.println(o.getValue() + ", тел: " + o.getKey());
        }

System.out.println("Поиск по фамилиям:" );

        phoneBook.get(phoneBook.phoneMap, "Иванов");

        phoneBook.get(phoneBook.phoneMap, "Петров");

    }


    public void add(Integer phone, String surname) {
        phoneMap.put(phone, surname);

    }

    public void get(HashMap<Integer, String> map, String surname) {

        for (Map.Entry<Integer, String> pair : map.entrySet()) {

            if (surname.equals(pair.getValue())) {
                System.out.println(surname + " " + pair.getKey());

            }
        }
    }
}