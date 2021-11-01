package HW_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordsArr /*implements Comparator<String>*/ {


    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(new String("кошка"), new String("мышка"), new String("белка"), new String("сурок"), new String("пес"), new String("лось"), new String("кошка"), new String("лось"), new String("кошка"), new String("мышка"), new String("выдра"), new String("пес"), new String("кошка"), new String("мышка"), new String("белка")));
        System.out.print("Массив слов: ");
        for (String word : wordList) {
            System.out.print(word + " ");
        }
        System.out.println();
        System.out.print("Массив без повторов: " );
        HashSet hsWord = new HashSet(wordList);
        System.out.print(hsWord);
        System.out.println();
        System.out.print("Количество повторов в массиве: ");

        HashMap<String, Integer> anHash = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            int n = 0;

            for (int j = 0; j < wordList.size(); j++) {
                if (wordList.get(i).equals(wordList.get(j))) {
                    n = n + 1;
                }
                anHash.put(wordList.get(i), n);

            }
        }
            System.out.print(anHash);


    }
}




